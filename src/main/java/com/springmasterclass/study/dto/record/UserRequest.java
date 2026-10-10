package com.springmasterclass.study.dto.record;

public record UserRequest(
     String name,
     String address,
     String email,
     String username,
     String password
) {

}
