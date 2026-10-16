package com.springmasterclass.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmasterclass.study.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
     // Category createCategory();
     // Category updateCategory();

}
