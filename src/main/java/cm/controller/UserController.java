package cm.controller;

import cm.entity.Course;
import cm.entity.Student;
import cm.entity.Teacher;
import cm.service.KlassService;
import cm.service.CourseService;
//import cm.service.UserService;
import cm.service.StudentService;
import cm.service.TeacherService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/cm")
public class UserController {
	@Autowired
    TeacherService teacherService=new TeacherService();
	StudentService studentService=new StudentService();


	Teacher teacher;
	Student student;

	//登录
	@RequestMapping(value="/login",method= RequestMethod.GET)
	public String Login() {
		return "userlogin";
	}
	
	//登录提交表单
	@RequestMapping(value="/login",method= RequestMethod.POST)
	public String LoginSubmit(String id, String password) {
		if(id.length()==11) {
			Student tmp = studentService.findStudentByAccount(id);
			if (tmp.getPassword().equals(password)) {
				student=tmp;
				if(student.getIs_active()==0)//0是未激活
					return "student_activation";
				return "student_main";
			}
		}
		else{
			Teacher tmp=teacherService.findTeacherByAccount(id);
			if(tmp.getPassword().equals(password)) {
				teacher=tmp;
				if(teacher.getIs_active()==0)
					return "teacher_activation";
				return "teacher_main";
			}
		}
		return "userlogin";
	}
}
