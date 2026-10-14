package com.springmasterclass.study.common;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import com.springmasterclass.study.entity.Checkup;

public class Example {
     
     @PersistenceContext
     EntityManager entityManager;

     public String findNameProduct() {
          Checkup checkup = entityManager.find(Checkup.class, 1);
          return checkup.getDiagnosis();
     }
}
