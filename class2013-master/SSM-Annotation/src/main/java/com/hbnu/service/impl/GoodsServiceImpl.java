package com.hbnu.service.impl;

import com.hbnu.dao.GoodsDao;
import com.hbnu.pojo.Goods;
import com.hbnu.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chendikai
 * @date 2023-04-11 9:26
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    // @Autowired
    @Resource
    private GoodsDao goodsDao;

    @Override
    public List<Goods> findAllGoods() {
        return goodsDao.findAllGoods();
    }
}
