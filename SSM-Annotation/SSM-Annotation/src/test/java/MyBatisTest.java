import com.chx.config.SpringRepositoryConfig;
import com.chx.dao.GoodsDao;
import com.chx.pojo.Goods;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author chendikai
 * @date 2023-04-10 9:27
 */
public class MyBatisTest {

    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRepositoryConfig.class);

    @Test
    public void findAllGoods() {
        GoodsDao dao = ctx.getBean("goodsDao", GoodsDao.class);

        List<Goods> goodsList = dao.findAllGoods();

        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
    }
}
