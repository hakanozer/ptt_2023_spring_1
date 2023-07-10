package com.works.utils;

import com.works.models.RestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Rest {

    public static ResponseEntity success( Object obj ) {
        RestModel restModel = new RestModel();
        restModel.setStatus(true);
        restModel.setResult(obj);
        return new ResponseEntity(restModel, HttpStatus.OK);
    }

    public static ResponseEntity fail( Object obj, HttpStatus httpStatus ) {
        RestModel restModel = new RestModel();
        restModel.setStatus(false);
        restModel.setResult(obj);
        return new ResponseEntity(restModel, httpStatus);
    }

}
