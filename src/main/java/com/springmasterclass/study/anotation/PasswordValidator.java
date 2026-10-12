package com.springmasterclass.study.anotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

     @Override
     public boolean isValid(String value, ConstraintValidatorContext context) {

          if (value == null || value.isBlank()) {
               return false;
          }

          String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{6,}$";

          return value.matches(regex);
     }

}
