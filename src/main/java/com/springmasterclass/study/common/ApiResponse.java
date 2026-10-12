package com.springmasterclass.study.common;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(int code, String msg, T result) {
     public static <T> ApiResponse<T> success(HttpStatus status, T result) {
          return new ApiResponse<>(status.value(), "Success", result);
     }

     public static <T> ApiResponse<T> errors(HttpStatus status, String message, T result) {
          return new ApiResponse<>(status.value(), message, result);
     }
     public static <T> ApiResponse<T> error(HttpStatus status, String message) {
          return new ApiResponse<>(status.value(), message, null);
     }
}
