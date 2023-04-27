package com.chx.controller;

import com.chx.pojo.Door;
import com.chx.pojo.Order;
import com.chx.service.impl.DoorServiceImpl;
import com.chx.service.impl.OrderServiceInterImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @description://TODO
 * @author: Luck_chen
 * @date: 2023/4/18 12:05
 * @Version 1.0.0.0
 */
@Controller
@RequestMapping("order")
public class OrderController {
    @Resource(name = "OrderServiceInterImpl")
    OrderServiceInterImpl orderServiceInter;

    @Resource(name = "DoorServiceImpl")
    DoorServiceImpl doorService;

    /**
     * 订单列表
     */
    @RequestMapping("list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        List<Order> list = orderServiceInter.list();
        modelAndView.setViewName("order_list");
        modelAndView.addObject("orderList",list);
        return modelAndView;
    }
    /**
     * 订单添加页面
     */
    @RequestMapping("addPage")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView();
        List<Door> doors = doorService.list();
        modelAndView.setViewName("order_add");
        modelAndView.addObject("doorList",doors);
        return modelAndView;
    }
    /**
     * 订单新增
     */
    @RequestMapping("add")
    public ModelAndView add(
            @RequestParam Integer doorId,
            @RequestParam String orderNo,
            @RequestParam String orderType,
            @RequestParam Integer pnum,
            @RequestParam String cashier,
            @RequestParam String payType,
            @RequestParam String price
            ){
        Order order = new Order();
        order.setDoorId(doorId);
        order.setOrderNo(orderNo);
        order.setOrderType(orderType);
        order.setPnum(pnum);
        order.setCashier(cashier);
        order.setPayType(payType);
        order.setPrice(new BigDecimal(price));
        Date now = new Date();
        order.setOrderTime(now);
        order.setPayTime(now);

        boolean success = orderServiceInter.save(order);

        ModelAndView modelAndView = new ModelAndView();
        //返回列表页面
        modelAndView.setViewName("redirect:/order/list");
        return modelAndView;
    }
    /**
     * 订单更新
     */
    @RequestMapping("update")
    public ModelAndView update(
            @RequestParam Integer id,
            @RequestParam Integer doorId,
//            @RequestParam String orderNo,
            @RequestParam String orderType,
            @RequestParam Integer pnum,
            @RequestParam String cashier,
            @RequestParam String payType,
            @RequestParam String price,
            @RequestParam String orderTime,
            @RequestParam String payTime
    ) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Order order = new Order();
        order.setId(id);
        order.setDoorId(doorId);
//        order.setOrderNo(orderNo);
        order.setOrderType(orderType);
        order.setPnum(pnum);
        order.setCashier(cashier);
        order.setPayType(payType);
        order.setPrice(new BigDecimal(price));
        order.setOrderTime(dateFormat.parse(orderTime));
        order.setPayTime(dateFormat.parse(payTime));

        orderServiceInter.update(order);

        ModelAndView modelAndView = new ModelAndView();
        //返回列表页面
        modelAndView.setViewName("redirect:/order/list");
        return modelAndView;
    }
    /**
     * 订单更新页面
     */
    @RequestMapping("updatePage")
    public ModelAndView updatePage(@RequestParam Integer id){
        Order order = orderServiceInter.findOneOrder(id);
        List<Door> doors = doorService.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order_update");
        modelAndView.addObject("order",order);
        modelAndView.addObject("doorList",doors);
        return modelAndView;
    }
    /**
     * 订单删除页面
     */
    @RequestMapping("delete")
    public ModelAndView delete(@RequestParam Integer id){
        orderServiceInter.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        //返回列表页面
        modelAndView.setViewName("redirect:/order/list");
        return modelAndView;
    }

}
