package Com.chx.Test;

import com.chx.dao.FruitDaoInter;
import com.chx.service.FruitServiceInter;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description://TODO
 * @author: Luck_chen
 * @date: 2023/4/20 22:34
 * @Version 1.0.0.0
 */
public class App1 {
    @Test
    public void  testComponent(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        FruitDaoInter fruitDao = (FruitDaoInter) ctx.getBean("fruitDao");
        fruitDao.fruit();
        FruitServiceInter fruitService = ctx.getBean(FruitServiceInter.class);
        fruitService.fruit();

    }
}
