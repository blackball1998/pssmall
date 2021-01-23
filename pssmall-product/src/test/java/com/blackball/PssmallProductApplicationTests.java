package com.blackball;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blackball.pssmall.product.PssmallProductApplication;
import com.blackball.pssmall.product.entity.BrandEntity;
import com.blackball.pssmall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = PssmallProductApplication.class)
class PssmallProductApplicationTests {

    @Autowired
    BrandService brandService;

//    @Autowired
//    OSSClient ossClient;

    @Test
    void test1() {
        BrandEntity brand = new BrandEntity();
        brand.setName("苹果");
        brandService.save(brand);
        System.out.println("success");
    }

    @Test
    void test2() {
        BrandEntity brand = new BrandEntity();
        brand.setBrandId(1L);
        brand.setDescript("Apple");
        brandService.updateById(brand);
        System.out.println("success");
    }

    @Test
    void test3() {
        BrandEntity entity = brandService.getOne(new QueryWrapper<BrandEntity>().eq("brand_id", 1));
        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1));
        System.out.println(entity);
        list.forEach(System.out::println);
    }

//    @Test
//    void upLoad() throws FileNotFoundException {
//        FileInputStream inputStream = new FileInputStream("D:\\Users\\Azure\\Desktop\\英文读物.png");
//        ossClient.putObject("pssmall", "test.png", inputStream);
//        ossClient.shutdown();
//        System.out.println("success");
//    }

}
