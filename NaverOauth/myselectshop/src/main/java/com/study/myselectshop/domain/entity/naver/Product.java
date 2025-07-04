package com.study.myselectshop.domain.entity.naver;

import com.study.myselectshop.presentation.dto.naver.ProductMypriceRequestDto;
import com.study.myselectshop.presentation.dto.naver.ProductRequestDto;
import com.study.myselectshop.domain.entity.common.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product")
@NoArgsConstructor
public class Product extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int myprice;

    public Product(ProductRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.image = requestDto.getImage();
        this.link = requestDto.getLink();
        this.price = requestDto.getLprice();
    }

    public void update(ProductMypriceRequestDto mypriceRequestDto) {
        this.myprice = mypriceRequestDto.getMyprice();
    }
}
