package com.study.myselectshop.presentation.dto.naver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {
    private String title;
    private String image;
    private String link;
    private int lprice;
}
