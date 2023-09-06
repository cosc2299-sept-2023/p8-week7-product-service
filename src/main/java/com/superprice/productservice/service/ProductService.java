package com.superprice.productservice.service;

import com.superprice.productservice.dto.ProductDto;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public ProductDto getProductById(Integer productId) {
        //fetching this from Db --> call repo (JPA) repo
        return new ProductDto(productId,"Laptop", "JB-HiFi");
    }
}
