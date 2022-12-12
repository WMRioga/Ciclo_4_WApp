package com.banco_essence.banco_essence.Validations;

import java.util.ArrayList;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.banco_essence.banco_essence.Models.ErrorModel;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler{
    @Override
    protected ResponseEntity <Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        ArrayList<ErrorModel> errores = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach((errorModel) -> {
            ErrorModel err = new ErrorModel();
            err.setCampo(((FieldError) errorModel).getField());
            err.setMensaje(errorModel.getDefaultMessage());
            errores.add(err);
        });
        return new ResponseEntity<Object>(errores, HttpStatus.PARTIAL_CONTENT);
    }
}
