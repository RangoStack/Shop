package com.rango.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("goods")
public class GoodsCategoryController {

    @RequestMapping("category/list")
    public String categoryList() {
        return "goods/category/category-list";
    }

    @RequestMapping("category/add")
    public String categoryAdd() {
        return "goods/category/category-add";
    }
}
