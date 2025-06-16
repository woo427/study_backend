package com.study.myselectshop.presentation.dto.naver;

import com.study.myselectshop.domain.entity.naver.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductResponseDto {
    private Long id;
    private String title;
    private String image;
    private String link;
    private int price;
    private int myprice;

    public ProductResponseDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.link = product.getLink();
        this.image = product.getImage();
        this.price = product.getPrice();
        this.myprice = product.getMyprice();
    }
}
