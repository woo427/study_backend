package com.study.myselectshop.naver.controller;

import com.study.myselectshop.naver.dto.ItemDto;
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
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto requestDto){
        return productService.createProduct(requestDto);
    }
}
