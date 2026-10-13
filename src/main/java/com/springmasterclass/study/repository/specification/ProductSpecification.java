package com.springmasterclass.study.repository.specification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.springmasterclass.study.entity.Product;



public class ProductSpecification {
     
     public static Specification<Product> filterProduct(String name, BigDecimal price, String category) {
          return ((root, query, criteriaBuiler) -> {
               List<Predicate> predicates = new ArrayList<>();

               if (StringUtils.hasText(name)) {
                    predicates.add(criteriaBuiler.like(criteriaBuiler.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
               }

               if (price != null) {
                    predicates.add(criteriaBuiler.lessThan(root.get("price"), price));
               }

               if (StringUtils.hasText(category)) {
                    predicates.add(criteriaBuiler.like(criteriaBuiler.lower(root.get("category")), "%" + category.toLowerCase() + "%"));
               }

               return criteriaBuiler.and(predicates.toArray(new Predicate[0]));
          });
     }
}
