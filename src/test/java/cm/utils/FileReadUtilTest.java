package cm.utils.FileReadUtil;

import cm.entity.Student;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FileReadUtilTest {
    @Autowired
    private FileReadUtil fileReadUtil;

    public static List<Student> listStudentByExcel(MultipartFile multipartFile)
    {
        System.out.println(fileReadUtil.listStudentByExcel("456"));
    }

}