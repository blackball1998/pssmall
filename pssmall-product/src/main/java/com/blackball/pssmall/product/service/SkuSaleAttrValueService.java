package com.blackball.pssmall.product.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.blackball.common.utils.PageUtils;
import com.blackball.pssmall.product.entity.SkuSaleAttrValueEntity;

import java.util.Map;

/**
 * sku销售属性&值
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-01 21:08:49
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

