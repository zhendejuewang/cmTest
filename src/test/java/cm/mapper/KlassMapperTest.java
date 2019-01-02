package cm.mapper;

import cm.entity.Admin;
import cm.mapper.AdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class KlassMapperTest {

    private KlassMapper klassMapper;
    @Test
    public Long getCourseIdByKlassId() throws Exception {
        Long courseId = klassMapper.getCourseIdByKlassId(22L);
        System.out.println(courseId);
    }
}
