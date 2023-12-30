package com.hbnu.controller;

import com.hbnu.pojo.Goods;
import com.hbnu.service.GoodsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chendikai
 * @date 2023-04-11 9:27
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @RequestMapping("/findAllGoods")
    public List<Goods> findAllGoods() {
        return goodsService.findAllGoods();
    }

}
