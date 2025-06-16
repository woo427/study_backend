package com.study.myselectshop.presentation.controller.naver;

import com.study.myselectshop.presentation.dto.ApiResponse;
import com.study.myselectshop.presentation.dto.naver.ItemDto;
import com.study.myselectshop.presentation.dto.naver.ProductMypriceRequestDto;
import com.study.myselectshop.presentation.dto.naver.ProductRequestDto;
import com.study.myselectshop.presentation.dto.naver.ProductResponseDto;
import com.study.myselectshop.application.service.naver.NaverApiService;
import com.study.myselectshop.application.service.naver.ProductService;
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
