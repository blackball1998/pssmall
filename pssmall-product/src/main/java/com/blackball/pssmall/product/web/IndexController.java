package com.blackball.pssmall.product.web;

import com.blackball.pssmall.product.entity.CategoryEntity;
import com.blackball.pssmall.product.service.CategoryService;
import com.blackball.pssmall.product.vo.Catalog2Vo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping({"/", "index.html"})
    public String getIndex(Model model) {
        //获取所有的一级分类
        List<CategoryEntity> catagories = categoryService.getLevel1Categories();
        model.addAttribute("catagories", catagories);
        return "index";
    }

    @GetMapping("index/json/catalog.json")
    @ResponseBody
    public Map<String, List<Catalog2Vo>> getCategoryMap() throws JsonProcessingException {
        return categoryService.getCatalogJson();
    }

//    @ResponseBody
//    @GetMapping("/getSeckillSkuInfo/{skuId}")
//    public R getSeckillSkuInfo(@PathVariable("skuId") Long skuId) {
//        return seckillFeignService.getSeckillSkuInfo(skuId);
//    }
}
