package com.study.myselectshop.naver.service;

import com.study.myselectshop.entity.Product;
import com.study.myselectshop.naver.dto.ProductRequestDto;
import com.study.myselectshop.naver.dto.ProductResponseDto;
import com.study.myselectshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponseDto createProduct(ProductRequestDto requestDto){
        Product product = productRepository.save(new Product(requestDto));
        return new ProductResponseDto(product);
    }

}
