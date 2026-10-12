package com.springmasterclass.study.dto.record;

import com.springmasterclass.study.anotation.Password;

import jakarta.validation.constraints.*;

public record UserRequest(

     @NotEmpty // check khác null và độ dài chuỗi phải lớn hơn 0
     @NotBlank //check khác null và sau khi bỏ hết dấu cách thì độ dài phải lớn hơn 0
     @NotNull(message = "Trường này ko được null")
     String name,
     String address,
     @Email
     @NotBlank
     String email,
     String username,
     @Password
     String password
) {

}
