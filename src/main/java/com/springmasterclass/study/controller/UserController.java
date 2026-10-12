package com.springmasterclass.study.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmasterclass.study.common.ApiResponse;
import com.springmasterclass.study.common.BaseController;
import com.springmasterclass.study.dto.record.UserRequest;
import com.springmasterclass.study.dto.record.UserResponse;

import com.springmasterclass.study.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/users")
public class UserController extends BaseController {
     private final UserService userService;

     @GetMapping("")
     public ApiResponse<List<UserResponse>> listUser() {
     //     return new ResponseEntity<>(userService.index(), HttpStatus.OK);
          return responseSuccessData(userService.index());
     }

     @PostMapping("")
     public ApiResponse<String> createUser(@Valid @RequestBody UserRequest rq) {
          userService.create(rq);
          return responseSuccessData("Tạo user thành công");
     }

     @PostMapping("/{id}")
     public ApiResponse<String> updateUser(@PathVariable("id") Long id, @RequestBody UserRequest rq) {
          userService.update(id, rq);
          return responseSuccessData("Sửa user thành công");
     }

     @DeleteMapping("/{id}")
     public ApiResponse<String> deleteUser(@PathVariable("id") Long id) {
          userService.delete(id);
          return responseSuccessData("Xóa user thành công");
     }
}
