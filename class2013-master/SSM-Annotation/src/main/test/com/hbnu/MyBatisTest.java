package com.hbnu;

import com.hbnu.config.SpringRepositoryConfig;
import com.hbnu.dao.GoodsDao;
import com.hbnu.pojo.Goods;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author chendikai
 * @date 2023-04-11 9:18
 */
public class MyBatisTest {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringRepositoryConfig.class);

    @Test
    public void findAllGoods() {
        GoodsDao goodsDao = applicationContext.getBean("goodsDao", GoodsDao.class);
        List<Goods> goodsList = goodsDao.findAllGoods();
        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
    }
}
