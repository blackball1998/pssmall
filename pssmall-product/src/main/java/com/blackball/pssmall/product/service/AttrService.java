package com.blackball.pssmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackball.common.utils.PageUtils;
import com.blackball.pssmall.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author blackball
 * @email blackball@outlook.com
 * @date 2020-12-30 21:24:39
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

