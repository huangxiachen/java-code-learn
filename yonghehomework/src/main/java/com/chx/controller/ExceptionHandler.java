package com.chx.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = RuntimeException.class)
    public ModelAndView handleServiceException(RuntimeException exception) {
        ModelAndView modelAndView = new ModelAndView("500");
        modelAndView.addObject("msg",exception.getMessage());
        return modelAndView;
    }
}
