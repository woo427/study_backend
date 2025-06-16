package com.study.myselectshop.infrastructure.repository.naver;

import com.study.myselectshop.domain.entity.naver.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
