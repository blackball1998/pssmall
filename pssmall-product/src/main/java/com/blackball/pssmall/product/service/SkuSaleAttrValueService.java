package com.blackball.pssmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackball.common.utils.PageUtils;
import com.blackball.pssmall.product.entity.SkuSaleAttrValueEntity;

import java.util.Map;

/**
 * sku销售属性&值
 *
 * @author blackball
 * @email blackball@outlook.com
 * @date 2020-12-30 21:24:38
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

