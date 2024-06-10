package com.library.collection.exception;

import com.library.collection.constants.StatusCode;
import com.library.collection.models.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse> handleGlobalException(Exception ex) {
        // Log the exception
        ex.printStackTrace();
        // Return a response entity with an error response class and status code
        return new ResponseEntity<>(new BaseResponse(StatusCode.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
