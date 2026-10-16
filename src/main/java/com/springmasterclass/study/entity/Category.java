package com.springmasterclass.study.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "catrgories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;

     @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
     @Builder.Default
     private List<Product> products = new ArrayList<>();

     // hepler method
     public void addProduct(Product p) {
          products.add(p);
          p.setCategory(this);
     }

     public void removeProduct(Product p) {
          products.remove(p);
          p.setCategory(null);
     }


}
