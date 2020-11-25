package com.rango.manager.service;

import com.rango.manager.pojo.GoodsCategory;

import java.util.List;

// 商品分类接口
public interface GoodsCategoryService {

    // 查询顶级分类
    List<GoodsCategory> queryTopGoodsCategory();

    // 级联查询 根据上级分类的id查询商品的二级分类 数据库的smallint 对应 java的short
    List<GoodsCategory> queryGoodsCategoryByParentId(short parentId);

    // 保存分类 返回值是影响的行数
    int goodsCategorySave(GoodsCategory goodsCategory);

}
