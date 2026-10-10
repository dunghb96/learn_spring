package com.springmasterclass.study.dto.record;

public record UserResponse(
     Long id,
     String name,
     String address,
     String email,
     String username
) {

}
