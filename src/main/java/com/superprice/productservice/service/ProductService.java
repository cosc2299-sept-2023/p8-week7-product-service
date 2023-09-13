package com.superprice.productservice.service;

import com.superprice.productservice.dto.ProductDto;
import com.superprice.productservice.model.Product;
import com.superprice.productservice.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getProductById() {

        List<Product> products = productRepository.findAll();
        //fetching this from Db --> call repo (JPA) repo
        List<ProductDto> productDtos = new ArrayList<>();
        products.forEach(product -> {
            productDtos.add(ProductDto.builder()
                                .productId(product.getProductId())
                                .store(product.getStore())
                                .productName(product.getProductName())
            .build());
        });
        return productDtos;
    }

    public ProductDto addProduct(ProductDto productDto) {
        Product product = Product.builder()
                .productName(productDto.getProductName())
                .store(productDto.getStore()).build();

        product = productRepository.save(product);

        return ProductDto.builder()
                .productId(product.getProductId())
                .store(product.getStore())
                .productName(product.getProductName())
                .build();
    }
}
