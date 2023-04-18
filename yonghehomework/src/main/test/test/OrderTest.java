package test;

import com.chx.dao.OrderMapper;
import com.chx.pojo.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("src/main/resources")
@ContextConfiguration(locations = { "classpath:spring/**.xml" })
public class OrderTest {

    @Resource
    OrderMapper orderMapper;

    @Test
    public void testSelectOne(){
        Order doorByOrderId = orderMapper.getDoorByOrderId(1);
        System.out.println(doorByOrderId);
    }

}
