package com.rango.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    //页面跳转 RestFul风格
    @RequestMapping("/{page}")
    public String page(@PathVariable String page) {
        System.out.println(page);
        return page;
    }
}
