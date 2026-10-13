package com.springmasterclass.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmasterclass.study.common.ApiResponse;
import com.springmasterclass.study.common.BaseController;
import com.springmasterclass.study.dto.record.ProductResponse;
import com.springmasterclass.study.service.ProductService;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController extends BaseController {

     private final ProductService producService;

     @GetMapping()
     public ApiResponse<Page<ProductResponse>> index(
          @RequestParam(value = "page", defaultValue = "0") int page,
          @RequestParam(value = "limit", defaultValue = "20") int limit,
          @RequestParam(defaultValue = "id") String sortCol,
          @RequestParam(defaultValue = "desc") String sortBy,
          @RequestParam(value = "name", required = false) String name,
          @RequestParam(value = "category", required = false) String category,
          @RequestParam(value = "price", required = false) BigDecimal price

     ) {
         Sort sort = sortBy.equalsIgnoreCase(Sort.Direction.DESC.name()) ? Sort.by(sortCol).descending() : Sort.by(sortCol).ascending();
         Pageable pageable = PageRequest.of(page == 0 ? page : page - 1, limit, sort);

         return ApiResponse.success(HttpStatus.OK, producService.getAllProduct(name, category, pageable, price));

     }


}
