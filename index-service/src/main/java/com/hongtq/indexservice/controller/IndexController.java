package com.hongtq.indexservice.controller;

import com.hongtq.entity.Product;
import com.hongtq.indexservice.client.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("index")
public class IndexController {

    //使用feign声明式rest调用接口后，无需再使用此接口连接
//    private String BUSINESS_SERVICE_URL = "http://BUSINESS-SERVICE/product/list";

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private IProductService productService;

    /**
     * 测试使用restTemplate和Feign声明式调用
     * restTemplate和Feign
     * @param model
     * @return
     */
    @RequestMapping("home")
    @ResponseBody
    public List<Product> home(Model model){

        //1.使用restTemplate声明式实现负载均衡调用
        //当使用restTemplate调用服务时,重试机制需要配置
//        String list = restTemplate.getForObject(BUSINESS_SERVICE_URL,String.class);
//        List<Product> list2 = new ArrayList<>();

        //2.使用Feign调用服务组件
        //feign组件已经实现了重试机制
        List<Product> list = productService.list();
        model.addAttribute("list",list);
        return list;
    }
}
