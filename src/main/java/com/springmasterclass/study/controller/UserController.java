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

import com.springmasterclass.study.dto.record.UserRequest;
import com.springmasterclass.study.dto.record.UserResponse;

import com.springmasterclass.study.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/users")
public class UserController {
     private final UserService userService;

     @GetMapping("")
     public ResponseEntity<List<UserResponse>> listUser() {
         return new ResponseEntity<>(userService.index(), HttpStatus.OK);
     }

     @PostMapping("")
     public ResponseEntity<String> createUser(@RequestBody UserRequest rq) {
          userService.create(rq);
          return new ResponseEntity<> ("tạo user thành công", HttpStatus.CREATED);
     }

     @PostMapping("/{id}")
     public ResponseEntity<String> updateUser(@PathVariable("id") Long id, @RequestBody UserRequest rq) {
          userService.update(id, rq);
          return new ResponseEntity<> ("Sửa user thành công", HttpStatus.OK);
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
          userService.delete(id);
          return new ResponseEntity<> ("Xóa user thành công", HttpStatus.OK);
     }
}
