package com.springmasterclass.study.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.springmasterclass.study.dto.record.ProductResponse;
import com.springmasterclass.study.entity.Product;

@Mapper (componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

     ProductResponse toResponse(Product product);


}
