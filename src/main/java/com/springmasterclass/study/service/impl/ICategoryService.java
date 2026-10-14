package com.springmasterclass.study.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.stereotype.Service;

import com.springmasterclass.study.dto.record.CategoryRequest;
import com.springmasterclass.study.dto.record.ProductRequest;
import com.springmasterclass.study.entity.Category;
import com.springmasterclass.study.entity.Product;
import com.springmasterclass.study.mapper.CategoryMapper;
import com.springmasterclass.study.repository.CategoryRepository;
import com.springmasterclass.study.repository.ProductRepository;
import com.springmasterclass.study.service.CategoryService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ICategoryService implements CategoryService{

     private final ProductRepository productRepository;
     private final CategoryRepository categoryRepository;
     private final CategoryMapper categoryMapper;

     @Override
     public Category createCategory(CategoryRequest rq) {
          Category category = categoryMapper.toEntity(rq);

          //xử lý logic 1 category kèm 1 danh sách
          if (Objects.nonNull(rq.products())) {
               for (ProductRequest product : rq.products()) {
                    Product pro = categoryMapper.toProductEntity(product);
                    category.addProduct(pro);
               }
          }
          // Category saveCategory = categoryRepository.save(category);

          return categoryRepository.save(category);
     }

     @Override
     public Category updateCategory(Long catId, CategoryRequest rq) {
          Category category = categoryRepository.findById(catId).orElseThrow(() -> new RuntimeException("Category not found1111"));

          category.setName(rq.name());

          //xử lý product cũ
          List<Long> newProductIds = Objects.nonNull(rq.products())
          ? rq.products().stream().map(ProductRequest::id).filter(Objects::nonNull).toList()
          : List.of();

          // xóa các product mà ko còn nằm trong dto hay request mới nữa
          category.getProducts().removeIf(product -> newProductIds.contains(product.getId()));

          if (Objects.nonNull(rq.products())) {
               for (ProductRequest pDto : rq.products()) {
                    if(pDto.id() == null ) {
                         Product newProduct = categoryMapper.toProductEntity(pDto);
                         category.addProduct(newProduct);
                    } else {
                         Product existing = category.getProducts().stream()
                              .filter(product -> product.getId().equals(pDto.id()))
                              .findFirst()
                              .orElse(null);
                         if (existing != null) {
                              existing.setName(pDto.name());
                              existing.setPrice(pDto.price());
                         }
                    }
               }
          }
          return categoryRepository.save(category);
     }

     public void deleteCategory(Long id) {
         Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
         // không có cascade REMOVE nên product sẽ chỉ bị set category = null nếu orphanRemoval = false
         categoryRepository.delete(category);
     }

}
