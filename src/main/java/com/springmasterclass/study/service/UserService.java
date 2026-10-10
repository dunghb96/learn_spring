package com.springmasterclass.study.service;

import java.util.List;

import com.springmasterclass.study.dto.record.UserRequest;
import com.springmasterclass.study.dto.record.UserResponse;
// import com.springmasterclass.study.dto.request.UserRq;
// import com.springmasterclass.study.dto.response.UserRp;

public interface UserService {
     void create(UserRequest rq);

     void update(Long id, UserRequest rq);

     List<UserResponse> index();

     void delete(Long id);
}
