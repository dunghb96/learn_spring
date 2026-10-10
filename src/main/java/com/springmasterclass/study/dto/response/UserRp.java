package com.springmasterclass.study.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserRp {

     private Long id;
     private String name;
     private String address;
     private String email;
     private String username;
}
