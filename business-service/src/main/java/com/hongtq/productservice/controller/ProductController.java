package com.hongtq.productservice.controller;

import com.hongtq.entity.Product;
import com.hongtq.productservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Value("${server.port}")
    private String servicePort;

    @Value("${image.server}")
    private String id;

    @RequestMapping("list")
    @ResponseBody
    public List<Product> list(){
        System.out.println("id:"+id);
        System.out.println("serverport:"+servicePort);
        return productService.getList();
    }

}
