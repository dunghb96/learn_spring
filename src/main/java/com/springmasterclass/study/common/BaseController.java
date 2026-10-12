package com.springmasterclass.study.common;

import org.springframework.http.HttpStatus;

public abstract class BaseController {
     
     protected <T> ApiResponse<T> responseSuccessData(T data) {
          return ApiResponse.success(HttpStatus.OK, data);
     }
}
