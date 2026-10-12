package com.springmasterclass.study.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springmasterclass.study.common.ApiResponse;

@RestControllerAdvice
public class GlobaExceptionHandler {
     
     @ExceptionHandler(MethodArgumentNotValidException.class)
     public ResponseEntity<ApiResponse<Map<String, String>>> handlerValidationException(MethodArgumentNotValidException ex) {
          Map<String, String> errors = new HashMap<>();

          ex.getBindingResult().getFieldErrors().forEach(error -> {
               errors.put(error.getField(), error.getDefaultMessage());
          });

          HttpStatus status = HttpStatus.BAD_REQUEST;
          ApiResponse<Map<String, String>> apiResponse = ApiResponse.errors(status, "List of erros colums", errors);
          return ResponseEntity.status(status).body(apiResponse);
     }

     @ExceptionHandler(RuntimeException.class)
     public ResponseEntity<ApiResponse<Object>> handleRuntimeException(RuntimeException ex) {
          HttpStatus status = HttpStatus.BAD_REQUEST;
          ApiResponse<Object> apiResponse = ApiResponse.error(status, ex.getLocalizedMessage());
          return ResponseEntity.status(status).body(apiResponse);
     }
}
