package com.springmasterclass.study.service.impl;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springmasterclass.study.dto.record.ProductResponse;
import com.springmasterclass.study.entity.Product;
import com.springmasterclass.study.mapper.ProductMapper;
import com.springmasterclass.study.repository.ProductRepository;
import com.springmasterclass.study.repository.specification.ProductSpecification;
import com.springmasterclass.study.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IProductService implements ProductService{

     private final ProductRepository productRepository;

     private final ProductMapper productMapper;


     @Override
     public Page<ProductResponse> getAllProduct(String name, String category, Pageable pageable, BigDecimal price) {
          // Page<Product> products = productRepository.findAll(pageable);

          // custom query
          // Page<Product> products = productRepository.findActiveByCategory(category, pageable);

          // Jpa Specitication
          Page<Product> products = productRepository.findAll(ProductSpecification.filterProduct(name, price, category), pageable);

          // return products.map(product -> productMapper.toResponse(product));
          return products.map(productMapper::toResponse);
     }

}
