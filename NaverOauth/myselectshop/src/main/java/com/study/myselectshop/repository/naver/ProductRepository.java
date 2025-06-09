package com.study.myselectshop.repository.naver;

import com.study.myselectshop.entity.naver.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
