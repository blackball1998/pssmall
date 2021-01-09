package com.blackball.pssmall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackball.common.utils.PageUtils;
import com.blackball.common.utils.Query;

import com.blackball.pssmall.product.dao.CategoryDao;
import com.blackball.pssmall.product.entity.CategoryEntity;
import com.blackball.pssmall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listAsTree() {
        List<CategoryEntity> categoryList = baseMapper.selectList(null);
        return categoryList.stream()
                .filter(menu -> menu.getParentCid() == 0)
                .peek(menu -> menu.setChildren(getSubmenu(menu, categoryList)))
                .sorted(Comparator.comparingInt(CategoryEntity::getSort))
                .collect(Collectors.toList());
    }

    private List<CategoryEntity> getSubmenu(CategoryEntity root, List<CategoryEntity> categoryList) {
        return categoryList.stream()
                .filter(menu -> menu.getParentCid().equals(root.getCatId()))
                .peek(menu -> menu.setChildren(getSubmenu(menu, categoryList)))
                .sorted(Comparator.comparingInt(CategoryEntity::getSort))
                .collect(Collectors.toList());
    }

}