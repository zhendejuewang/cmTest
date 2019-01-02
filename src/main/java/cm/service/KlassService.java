package cm.service;

import cm.entity.*;
import cm.vo.KlassVO;
import org.springframework.stereotype.Service;
import cm.dao.CourseDAO;
import cm.dao.KlassDAO;
import cm.dao.KlassSeminarDAO;
import cm.dao.StudentDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

import cm.utils.FileReadUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Yunfeng Huang
 * @Description:
 * @Date: Created in 2018/12/30
 */
@Service
public class    KlassService {

    @Autowired
    private CourseDAO courseDAO;

    @Autowired
    private KlassDAO klassDAO;

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private KlassSeminarDAO klassSeminarDAO;

    @Autowired
    private KlassSeminarService klassSeminarService;

    @Autowired
    private TeamService teamService;

    /**
     * 根据KlassVO，CourseId与TeacherId创建Klass 用在CourseController 新建班级
     * @param klassVO
     * @param courseId
     * @param teacherId
     * @return java.lang.Long
     */
    public Long createKlassByKlassVOAndCourseIdAndTeacherId(KlassVO klassVO, Long courseId, Long teacherId){
        Course course=courseDAO.getByCourseIdAndTeacherId(courseId, teacherId);
        if (course == null) {
            return null;
        }
        Klass klass=new Klass();
        klass.setGrade(klassVO.getGrade());
        klass.setKlassSerial(klassVO.getKlassSerial());
        klass.setKlassTime(klassVO.getKlassTime());
        klass.setKlassLocation(klassVO.getKlassLocation());

        if (0==klassDAO.createByCourseId(klass,courseId)){
            return null;
        }
        return klass.getId();
    }

    /**
     * 根据File，CourseId与KlassId创建KlassStudent 用在CourseController 新建完后导入学生
     * @param multipartFile
     * @param klassId
     * @param courseId
     */
    @Transactional(rollbackFor = Exception.class)
    public void createKlassStudentByFileAndCourseIdAndKlassId(MultipartFile multipartFile,Long klassId,Long courseId){
        List<Student>studentList=FileReadUtil.listStudentByExcel(multipartFile);
        studentDAO.createStudent(studentList);
        klassDAO.createKlassStudentListByStudentListAndKlassIdAndCourseId(studentList,klassId,courseId);
    }

    /**
     * 根据File，TeacherId与KlassId创建KlassStudent 用在KlassController 判断权限再导入
     * @param multipartFile
     * @param teacherId
     * @param klassId
     * @return java.lang.Long
     */
    @Transactional(rollbackFor = Exception.class)
    public Long createKlassStudentByFileAndTeacherIdAndKlassId(MultipartFile multipartFile,Long teacherId,Long klassId){
        Course course=courseDAO.getByKlassIdAndTeacherId(klassId,teacherId);
        if (course == null) {
            return null;
        }
        List<Student>studentList=FileReadUtil.listStudentByExcel(multipartFile);
        studentDAO.createStudent(studentList);
        klassDAO.createKlassStudentListByStudentListAndKlassIdAndCourseId(studentList,klassId,course.getId());
        return klassId;
    }

    public Boolean deleteKlassByKlassIdAndTeacherId(Long klassId, Long teacherId){
        /**
         * 判断权限
         */
        Klass klass=klassDAO.getByKlassIdAndTeacherId(klassId, teacherId);
        if (klass == null) {
            return null;
        }
        try {
            deleteByKlass(klass);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void deleteByKlass(Klass klass){

        List<KlassSeminar>klassSeminarList=klassSeminarDAO.listByKlassId(klass.getId());
        for (KlassSeminar klassSeminar:klassSeminarList) {
            klassSeminarService.deleteByKlassSeminarId(klassSeminar.getId());
        }
        for (Team team:klass.getTeams()) {
            teamService.deleteTeam(team.getId());
        }
        klassDAO.deleteKlass(klass.getId());
    }
}
