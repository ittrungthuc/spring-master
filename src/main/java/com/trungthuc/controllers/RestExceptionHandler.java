package com.trungthuc.controllers;

import com.trungthuc.domains.ApiError;
import com.trungthuc.domains.ResponseAPI;
import com.trungthuc.exception.InvalidRequestException;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    @Autowired
    MessageSource messageSource;

   /* @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    //@ResponseBody
    public ResponseEntity<ResponseMessage> handleGenericException(Exception ex, WebRequest request) {
        if (log.isDebugEnabled()) {
            log.debug("handling exception...");
        }
        return new ResponseEntity<>(new ResponseMessage(ResponseMessage.Type.danger, ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    //@ResponseBody
    public ResponseEntity<ResponseMessage> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        if (log.isDebugEnabled()) {
            log.debug("handling ResourceNotFoundException...");
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {UsernameAlreadyUsedException.class})
    //@ResponseBody
    public ResponseEntity<ResponseMessage> handleUsernameExistedException(UsernameAlreadyUsedException ex, WebRequest request) {
        if (log.isDebugEnabled()) {
            log.debug("handling UsernameExistedException...");
        }

        ResponseMessage error = ResponseMessage.danger("username existed.");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }*/


    @ExceptionHandler(value = {InvalidRequestException.class})
    public ResponseEntity<ApiError> handleInvalidRequestException(InvalidRequestException ex, WebRequest req) {
        if (log.isDebugEnabled()) {
            log.debug("handling InvalidRequestException...");
        }
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getErrors().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getErrors().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        ApiError apiError =new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);

        return new ResponseEntity<ApiError>(apiError, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<ResponseAPI> constraintViolationException(ConstraintViolationException ex, WebRequest req) {
        if (log.isDebugEnabled()) {
            log.debug("handling InvalidRequestException...");
        }
        ResponseAPI alert = new ResponseAPI();
        alert.setCode("200");
        alert.setMessage(ex.getMessage());
        alert.setObject(null);
        return new ResponseEntity<>(alert, HttpStatus.UNPROCESSABLE_ENTITY);
    }


}
