package cm.service;

        import cm.dao.StudentDAO;
        import cm.entity.Student;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentDAO studentDAO;
    public Student getByStudentId(Long studentId)
    {
        return studentDAO.getByStudentId(studentId);
    }
}
