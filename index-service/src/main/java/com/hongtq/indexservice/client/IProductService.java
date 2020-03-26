package com.hongtq.indexservice.client;

import com.hongtq.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

//feignclinet配置调用对应的实例名称
@FeignClient(name = "BUSINESS-SERVICE",fallback = IProductService.ProductServiceFallback.class)
public interface IProductService {

    //接口对应后缀
    @RequestMapping("product/list")
    public List<Product> list();

    @Component
    static class ProductServiceFallback implements IProductService{
        @Override
        public List<Product> list() {
            System.out.println("进入hystrix熔断处理");
            return new ArrayList<>();
        }
    }

}
