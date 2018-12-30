package cm.controller;

import cm.entity.Course;
import cm.entity.KlassSeminar;
import cm.entity.Round;
import cm.entity.Seminar;
import cm.service.CourseService;
import cm.service.KlassService;
import cm.service.RoundService;
import cm.service.SeminarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/cm/teacher")
public class TeacherController {

    CourseService courseService=new CourseService();
    KlassService klassService=new KlassService();
    RoundService roundService=new RoundService();
    SeminarService seminarService=new SeminarService();
    Course course;
    //////////////////////////////////////账户设置
    @RequestMapping(value="/setting",method= RequestMethod.GET)
    public String teacherAccountSet(Model model, HttpSession httpSession) {
        model.addAttribute("curTeacher",teacher);
        model.addAttribute("adminEmail",httpSession.getAttribute("adminEmail"));/////////////////不知如何获取adminEmail
        return "teacher_setting";
    }

    //////////////////////////////修改邮箱按钮
    @RequestMapping(value="/setting/modifyEmail",method=RequestMethod.GET)
    public String teacherModifyEmail(){
        return "modifyEmailPage";
    }

    ////////////////////////////修改邮箱提交待修改
    @RequestMapping(value="/setting/modifyEmail",method=RequestMethod.POST)
    @ResponseBody
    public String teacherModifyEmailSubmit(String email){
        if(teacherService.modifyEmail(teacher,email))
            return "修改成功 HttpStatus(200)";
        else
            return "修改失败 HttpStatus(400)";
    }

    /////////////////////////////////修改账户密码按钮
    @RequestMapping(value="/setting/modifyPwd",method = RequestMethod.GET)
    public String teacherModifyPwd(){
        return "modifyPwdPage";
    }

    ////////////////////////////////修改账户密码提交
    @RequestMapping(value="/setting/modifyPwd",method=RequestMethod.POST)
    @ResponseBody
    public void teacherModifyPwdSubmit(HttpServletResponse response, String password)throws IOException {
        if(teacherService.modifyPwd(teacher,password)){
            response.setStatus(200);
            response.getWriter().append("修改成功");
        }
        else{
            response.setStatus(409);
            response.getWriter().append("修改失败");
        }
    }

    /////////////////////////////////////通知页面
    @RequestMapping(value="/notification",method = RequestMethod.GET)
    public String teacherNotification(){
        return "teacher_notification";
    }

    ////////班级管理
    @RequestMapping(value="/course/klassList",method = RequestMethod.POST)
    public String teacherKlassManage(Model model){
        long course_id;//此处应从security获取当前课程
        model.addAttribute("klassList",klassService.findKlassesByCourseId(course_id));
        return "teacher_klassList";
    }

    ////////删除班级
    @RequestMapping(value = "/course/klass/{klassId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void teacherKlassDelete(HttpServletResponse response,@PathVariable long klassId)throws IOException{
        if(klassService.deleteKlassById(klassId)){
            response.setStatus(200);
            response.getWriter().append("删除成功");
        }
    }

    ///////////讨论课列表
    @RequestMapping(value = "/course/seminar",method = RequestMethod.GET)
    public String teacherSeminar(Model model){
        long courseId;//此处从security获取当前课程Id
        model.addAttribute("courseId",courseId);
        model.addAttribute("roundList",roundService.findRoundsByCourseId(courseId));
        model.addAttribute("klassList",klassService.findKlassesByCourseId(courseId));

        return "teacher_seminarList";
    }

    ////////////////////获取轮次设置
    @RequestMapping(value = "/course/seminar/setting/{round_id}",method = RequestMethod.POST)
    public String teacherSeminarSetting(@PathVariable long round_id){
        return "roundSetting";
    }

    //////////////////修改轮次设置
    @RequestMapping(value = "/course/seminar/setting",method = RequestMethod.PATCH,consumes = "application/json")
    @ResponseBody
    public void teacherSeminarSettingSubmit(HttpServletResponse response,@RequestBody Round round)throws IOException{
        long roundId;//此处应该从security获取
        if(roundService.updateRound(roundId,round)){
            response.setStatus(200);
        }
    }

    ////////////////////创建讨论课
    @RequestMapping(value = "/course/seminar/create",method = RequestMethod.POST)
    @ResponseBody
    public void teacherSeminarCreate(@RequestBody Seminar seminar,HttpServletResponse response)throws IOException{
        if(seminarService.addSeminar(seminar)){
            response.setStatus(200);
            response.getWriter().append("新建成功");
        }
    }

    //////////讨论课详情
    @RequestMapping(value = "/course/seminar/info/{klassId}/{seminarId}",method = RequestMethod.GET)
    public String teacherSeminar(@PathVariable long klassId,@PathVariable long seminarId,Model model){
        model.addAttribute("klassSeminar",seminarService.findKlassSeminarById(klassId,seminarId));
        return "teacher_seminarInfo";
    }

    /////////讨论课修改
    @RequestMapping(value="/course/seminar",method = RequestMethod.PATCH,consumes = "application/json")
    @ResponseBody
    public void teacherSeminarUpdate(@RequestBody Seminar seminar,HttpServletResponse response){
        long seminarId;
        if(seminarService.updateSeminar(seminarId,seminar)){
            response.setStatus(200);
        }
    }

    ///////////////删除讨论课
    @RequestMapping(value = "/course/seminar/{seminarId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void teacherSeminarDelete(@PathVariable long seminarId,HttpServletResponse response){
        if(seminarService.deleteSeminarById(seminarId)){
            response.setStatus(200);
        }
    }

    ///////////////讨论课报名列表
    @RequestMapping(value = "/course/seminar/enrollList",method = RequestMethod.GET)
    public String teacherSeminarEnrollList(Model model){
        long klassSeminarId;
        model.addAttribute("enrollList",seminarService.findAttendanceById(klassSeminarId));
        return "teacher_seminar_enrollList";
    }

    ///////////////////讨论课正在进行websocket
    @RequestMapping(value = "/course/seminar/progressing",method = RequestMethod.GET)
    public String teacherSeminarProgressing(Model model){
        long klassSeminarId;
        model.addAttribute("enrollList",seminarService.findAttendanceById(klassSeminarId));
        return "teacher_seminar_progressing";
    }

    //////讨论课结束报告页
    @RequestMapping(value = "/course/seminar/finished",method = RequestMethod.GET)
    public String teacherSeminarFinished(Model model){
        long klassSeminarId;
        model.addAttribute("enrollList",seminarService.findAttendanceById(klassSeminarId));
        return "teacher_seminar_finished";
    }

    /////////////////讨论课分数
    @RequestMapping(value ="/course/seminar/grade",method = RequestMethod.GET)
    public String teacherSeminarGrade(Model model){
        long klassSeminarId;
        model.addAttribute("score",seminarService.findSeminarScoreById(klassSeminarId));
        return "teacher_seminar_grade";
    }


}
