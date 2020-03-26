package com.hongtq.productservice.service.impl;

import com.hongtq.entity.Product;
import com.hongtq.productservice.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{

    @Override
    public List<Product> getList() {
        ArrayList list = new ArrayList<Product>();
        list.add(new Product(1L,"华为",3000L));
        list.add(new Product(2L,"苹果",9000L));
        return list;
    }
}
