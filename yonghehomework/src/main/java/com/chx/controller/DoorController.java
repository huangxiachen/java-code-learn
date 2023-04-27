package com.chx.controller;

import com.chx.pojo.Door;
import com.chx.service.DoorServiceInter;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/door")
public class DoorController {

    @Resource(name = "DoorServiceImpl")
    DoorServiceInter doorServiceInter;

    /**
     * 门店列表
     */
    @RequestMapping("list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("door_list");
        modelAndView.addObject("list",doorServiceInter.list());
        return modelAndView;
    }
    /**
     * 删除门店
     */
    @RequestMapping("delete")
    public ModelAndView delete(@RequestParam Integer id){
        ModelAndView modelAndView = new ModelAndView();
        doorServiceInter.delete(id);
        //重定向到列表页面
        modelAndView.setViewName("redirect:/door/list");
        return modelAndView;
    }
    /**
     * 门店的更新页面
     */
    @RequestMapping("updatePage")
    public ModelAndView updatePage(@RequestParam Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("door_update");
        modelAndView.addObject("door",doorServiceInter.getOne(id));
        return modelAndView;
    }
    /**
     * 门店的添加页面
     */
    @RequestMapping("addPage")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("door_add");
        return modelAndView;
    }
    /**
     * 门店更新或添加
     */
    @RequestMapping("updateOrAdd")
    public ModelAndView update(@RequestParam(required = false) Integer id,
                               @RequestParam String name,
                               @RequestParam String tel,
                               @RequestParam String addr
                              ){
        ModelAndView modelAndView = new ModelAndView();
        //重定向到列表页面
        modelAndView.setViewName("redirect:/door/list");
        Door door = new Door();
        door.setId(id);
        door.setName(StringUtils.isEmpty(name)? null : name.trim());
        door.setTel(StringUtils.isEmpty(tel)? null : tel.trim());
        door.setAddr(StringUtils.isEmpty(addr)? null : addr.trim());
        doorServiceInter.updateOrAdd(door);
        return modelAndView;
    }
}
