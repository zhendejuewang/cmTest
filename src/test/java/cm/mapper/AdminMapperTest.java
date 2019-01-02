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
public class AdminMapperTest {

    private AdminMapper adminMapper;
    @Test
    public void queryById() throws Exception {
        Admin admin = adminMapper.getByAdminId("1");
        System.out.println(admin.getAccount());

    }
}
