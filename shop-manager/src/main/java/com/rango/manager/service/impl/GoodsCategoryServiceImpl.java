package com.rango.manager.service.impl;

import com.rango.manager.mapper.GoodsCategoryMapper;
import com.rango.manager.pojo.GoodsCategory;
import com.rango.manager.pojo.GoodsCategoryExample;
import com.rango.manager.service.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    // 查询顶级分类的具体实现
    @Override
    public List<GoodsCategory> queryTopGoodsCategory() {
        // 设置查询对象
        GoodsCategoryExample example = new GoodsCategoryExample();
        // 设置查询条件 顶级分类 parent_id = 0
        example.createCriteria().andParentIdEqualTo((short)0);
        // 查询
        return goodsCategoryMapper.selectByExample(example);
    }

    // 根据父id 查询二级分类
    @Override
    public List<GoodsCategory> queryGoodsCategoryByParentId(short parentId) {
        // 创建查询对象
        GoodsCategoryExample example = new GoodsCategoryExample();
        // 设置查询条件
        example.createCriteria().andParentIdEqualTo(parentId);
        // 返回结果
        return goodsCategoryMapper.selectByExample(example);
    }

    // 保存分类
    // 这里 insertSelective 是只会对传过来有值的属性赋值 做非空判断 没穿这个值就不会赋值
    // insert 会对所有的值 不管传没值都会赋一遍 即使是空
    @Override
    public int goodsCategorySave(GoodsCategory goodsCategory) {
        return goodsCategoryMapper.insertSelective(goodsCategory);
    }
}
