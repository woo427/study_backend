package com.study.myselectshop.service;

import com.study.myselectshop.entity.Product;
import com.study.myselectshop.dto.ProductMypriceRequestDto;
import com.study.myselectshop.dto.ProductRequestDto;
import com.study.myselectshop.dto.ProductResponseDto;
import com.study.myselectshop.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public static final int MIN_MY_PRICE = 100;

    public ProductResponseDto createProduct(ProductRequestDto requestDto){
        Product product = productRepository.save(new Product(requestDto));
        return new ProductResponseDto(product);
    }

    @Transactional
    public ProductResponseDto updateProduct(Long id, ProductMypriceRequestDto productMypriceRequestDto){

        Product product = productRepository.findById(id).orElseThrow(()->new NullPointerException("해당 상품을 찾을 수 없습니다."));

        int myprice = productMypriceRequestDto.getMyprice();
        if (myprice < MIN_MY_PRICE) {
            throw new IllegalArgumentException(" 유효하지 않은 관심 가격입니다. 최소 " + MIN_MY_PRICE + "원 이상으로 설정해 주세요.");
        }

        product.update(productMypriceRequestDto);
        return new ProductResponseDto(product);
    }

}
