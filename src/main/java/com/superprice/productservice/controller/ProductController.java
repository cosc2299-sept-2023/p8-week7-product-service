package com.superprice.productservice.controller;


import com.superprice.productservice.dto.ProductDto;
import com.superprice.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/get")
    public ProductDto getProduct(@RequestParam Integer productId) {
        ProductDto productDto = productService.getProductById(productId);
        return productDto;
    }
}
