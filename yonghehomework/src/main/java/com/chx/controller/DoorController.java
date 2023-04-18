package com.chx.controller;

import com.chx.pojo.Door;
import com.chx.service.DoorServiceInter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/door")
public class DoorController {

    @Resource(name = "DoorServiceImpl")
    DoorServiceInter doorServiceInter;

    @RequestMapping("list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("door_list");
        modelAndView.addObject("list",doorServiceInter.list());
        return modelAndView;
    }

    @RequestMapping("delete")
    public ModelAndView delete(@RequestParam Integer id){
        ModelAndView modelAndView = new ModelAndView();
        doorServiceInter.delete(id);
        modelAndView.setViewName("redirect:/door/list");
        return modelAndView;
    }

    @RequestMapping("updatePage")
    public ModelAndView updatePage(@RequestParam Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("door_update");
        modelAndView.addObject("door",doorServiceInter.getOne(id));
        return modelAndView;
    }

    @RequestMapping("addPage")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("door_add");
        return modelAndView;
    }

    @RequestMapping("updateOrAdd")
    public ModelAndView update(@RequestParam(required = false) Integer id,
                               @RequestParam String name,
                               @RequestParam String tel,
                               @RequestParam String addr
                              ){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/door/list");
        Door door = new Door();
        door.setId(id);
        door.setName(name);
        door.setTel(tel);
        door.setAddr(addr);
        doorServiceInter.updateOrAdd(door);
        return modelAndView;
    }
}
