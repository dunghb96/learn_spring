package com.springmasterclass.study.entity;

import java.math.BigDecimal;

import org.modelmapper.internal.bytebuddy.build.HashCodeAndEqualsPlugin.Identity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;
     private BigDecimal price;
     private String status;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "category_id")
     private Category category;
}
