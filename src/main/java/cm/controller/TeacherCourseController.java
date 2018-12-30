package cm.controller;

import cm.entity.Course;
import cm.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/cm/teacher/course")
public class TeacherCourseController {

    CourseService courseService=new CourseService();

    //课程管理
    @RequestMapping(method= RequestMethod.GET)
    public String teacherCourseManage(Model model) {
        model.addAttribute("courseList", courseService.findCoursesByTeacher(teacher));
        return "teacher_courseList";
    }

    /////////////////////////////////////课程详情页
    @RequestMapping(value="/info/{courseId}")
    public String teacherCourseInfo(Model model, @PathVariable long course_id){
        course=courseService.findCourseById(course_id);
        model.addAttribute("curCourse",course);
        return "teacher_courseInfo";
    }

    ////////////////////////////////创建课程
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String teacherCourseCreate(){
        return "teacher_course_create";
    }

    @RequestMapping(value = "/create",method = RequestMethod.PUT,consumes ="application/json" )
    @ResponseBody
    public void teacherCourseCreateSubmit(HttpServletResponse response, @RequestBody Course course)throws IOException {
        if(courseService.addCourse(course)){
            response.setStatus(200);
            response.getWriter().append("创建成功");
        }
        else{
            response.setStatus(409);
            response.getWriter().append("因课程重名而失败");
        }
    }

    @RequestMapping(value = "/{courseID}",method = RequestMethod.DELETE)
    @ResponseBody
    public void teacherCourseDelete(HttpServletResponse response, @PathVariable long courseID)throws IOException {
        if(courseService.deleteCourseById(courseID)) {
            response.setStatus(200);
            response.getWriter().append("删除成功！");
        }
    }

    @RequestMapping(value = "",method = RequestMethod.PATCH,consumes = "application/json")
    @ResponseBody
    public void teacherCourseUpdate(HttpServletResponse response,@RequestBody Course course)throws IOException{
        long courseId;
        if(courseService.updateCourse(courseId,course)){
            response.setStatus(200);
            response.getWriter().append("修改成功");
        }
    }
}
