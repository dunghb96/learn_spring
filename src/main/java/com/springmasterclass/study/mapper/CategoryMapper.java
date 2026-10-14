package com.springmasterclass.study.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.springmasterclass.study.dto.record.CategoryRequest;
import com.springmasterclass.study.dto.record.ProductRequest;
import com.springmasterclass.study.entity.Product;
import com.springmasterclass.study.entity.Category;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {

     @Mapping (target = "products", ignore = true)
     Category toEntity(CategoryRequest categoryRequest);

     ProductRequest toProductDto(Product product);

     Product toProductEntity(ProductRequest productRequest);
}
