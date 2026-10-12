package com.springmasterclass.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmasterclass.study.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

     
}
