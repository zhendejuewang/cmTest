package cm.controller;

import cm.entity.Teacher;
import cm.service.AdminService;
import cm.service.StudentService;
import cm.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cm/pc/admin")
public class AdminPCController {

    AdminService adminService=new AdminService();
    TeacherService teacherService=new TeacherService();
    StudentService studentService=new StudentService();

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String adminLogin(){
        return "pcLogin";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String adminLoginSubmit(String account, String password) {
        if (adminService.vertify(account, password)) {
            return "admin_teacherList";
        }
        else {
            return "redirect:/cm/pc/admin/login";
        }
    }

    @RequestMapping(value = "/teacherList",method = RequestMethod.GET)
    public String adminTeacherList(Model model){
        model.addAttribute("TeacherList",teacherService.listAllTeacher());
        return "admin_teacherList";
    }

    @RequestMapping(value = "/teacherList/search",method = RequestMethod.GET)
    @ResponseBody
    public Teacher adminTeacherSearch(String teacherAccount){
        return teacherService.getTeacherByAccount(teacherAccount);
    }

    @RequestMapping(value = "/addTeacher",method = RequestMethod.GET)
    public String adminAddTeacher(){
        return "admin_addTeacher";
    }

    @RequestMapping(value = "/addTeacher",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity adminAddTeacherSubmit(String account,String teacherName,String email,String password){
        if(adminService.addTeacher(account,teacherName,email,password))
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.CONFLICT);
    }

    @RequestMapping(value="/modifyTeacher",method = RequestMethod.GET)
    public String adminModifyTeacher(String teacherAccount,Model model){
        model.addAttribute("teacher",teacherService.getTeacherByAccount(teacherAccount));
        return "admin_modify_teacher";
    }

    @RequestMapping(value="/modifyTeacher",method=RequestMethod.PATCH)
    @ResponseBody
    public ResponseEntity adminModifyTeacherSubmit(Long id,String account,String teacherName,String email){
        teacherService.modifyTeacher(id,account,teacherName,email);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/teacher/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity adminDeleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacher(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/studentList",method=RequestMethod.GET)
    public String adminStudentList(Model model){
        model.addAttribute("studentList",studentService.findAllStudents());
        return "admin_studentList";
    }

    @RequestMapping(value = "/modifyStudent",method = RequestMethod.GET)
    public String adminModifyStudent(String studentId,Model model){
        model.addAttribute("student",studentService.findStudentByAccount(studentId));
        return "admin_modify_student";
    }

    @RequestMapping(value = "/modifyStudent",method = RequestMethod.PATCH)
    @ResponseBody
    public ResponseEntity adminModifyStudentSubmit(Long id,String account,String studentName,String email){
        studentService.modifyStudent(id,account,studentName,email);
        return new ResponseEntity(HttpStatus.OK);
    }
}
