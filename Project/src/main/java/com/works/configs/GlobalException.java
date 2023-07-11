package com.works.configs;

import com.works.utils.Rest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValid( MethodArgumentNotValidException ex ) {
        return Rest.fail(ex.getFieldErrors(), HttpStatus.BAD_REQUEST);
    }

}
