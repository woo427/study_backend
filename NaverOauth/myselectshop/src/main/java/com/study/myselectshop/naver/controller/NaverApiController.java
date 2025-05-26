package com.study.myselectshop.naver.controller;

import com.study.myselectshop.dto.ApiResponse;
import com.study.myselectshop.naver.dto.ItemDto;
import com.study.myselectshop.naver.dto.ProductMypriceRequestDto;
import com.study.myselectshop.naver.dto.ProductRequestDto;
import com.study.myselectshop.naver.dto.ProductResponseDto;
import com.study.myselectshop.naver.service.NaverApiService;
import com.study.myselectshop.naver.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class NaverApiController {

    private final NaverApiService naverApiService;
    private final ProductService productService;

    @GetMapping("/search")
    public List<ItemDto> searchItems(@RequestParam String query) {
        return naverApiService.searchItems(query);
    }

    @PostMapping("/products")
    public ApiResponse<ProductResponseDto> createProduct(@RequestBody ProductRequestDto requestDto){
        ProductResponseDto data =  productService.createProduct(requestDto);
        return ApiResponse.success("상품 등록 완료", data);
    }

    @PostMapping("/products/{id}")
    public ApiResponse<ProductResponseDto> updateProduct(@RequestBody ProductMypriceRequestDto mypriceRequestDto, @PathVariable Long id){
        ProductResponseDto data =  productService.updateProduct(id, mypriceRequestDto);
        return ApiResponse.success("관심 상품 최저가 변경 완료", data);
    }
}
