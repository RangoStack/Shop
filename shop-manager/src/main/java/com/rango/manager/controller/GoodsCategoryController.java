package com.rango.manager.controller;

import com.rango.common.result.BaseResult;
import com.rango.manager.pojo.GoodsCategory;
import com.rango.manager.service.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("goods")
public class GoodsCategoryController {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    /**
     *  跳转商品分类-列表页
     * @return
     */
    @RequestMapping("category/list")
    public String categoryList() {
        return "category/category-list";
    }

    /**
     *  跳转商品分类-新增页面
     * @return
     */
    @RequestMapping("category/add")
    public String categoryAdd(Model model) {

        // 当点击新增按钮的时候 跳转到新增页面 把顶级分类的数据页也带过去
        List<GoodsCategory> goodsCategories = goodsCategoryService.queryTopGoodsCategory();
        // 放入model
        model.addAttribute("goodsTopCategory",goodsCategories);
        return "category/category-add";
    }

    /**
     *  级联查询 根据父分类 查询 二级分类
     *  异步请求 直接返回结果数据
     *
     * @param parentId
     * @return
     *
     * 此时要是parentId 是-1的话很容易报错 无法保持健壮性
     */
    @RequestMapping("category/nextStage/{parentId}")
    @ResponseBody
    public List<GoodsCategory> queryGoodsCategoryByParentId(@PathVariable("parentId") short parentId) {
        return goodsCategoryService.queryGoodsCategoryByParentId(parentId);
    }

    @RequestMapping("category/save")
    @ResponseBody
    public BaseResult CategorySave(GoodsCategory goodsCategory) {

        int i = goodsCategoryService.goodsCategorySave(goodsCategory);
        return i > 0 ? BaseResult.success() : BaseResult.error();
    }
}
