package com.example.FoodDeliveryApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice// to handle exceptions globally
public class ServerException {
    @ExceptionHandler(RuntimeException.class)// to handle exceptions specifically
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<String> handleInvalidDataException(InvalidDataException ex){
        return new ResponseEntity<>(ex.getMsg(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex){
        return new ResponseEntity<>(ex.getMsg(),HttpStatus.NOT_FOUND);
    }
   @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String,String> resp = new HashMap<>();
        //BindingResult is a container that holds the errors in structured way so we can access and handle them in our code
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName= ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            resp.put(fieldName,message);
        });
     return new ResponseEntity<Map<String,String>>(resp, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EnumOptionNotAvailableException.class)
    public ResponseEntity<String > handleEnumOptionNotAvailableException(EnumOptionNotAvailableException ex){
            return new ResponseEntity<>(ex.getMsg(),HttpStatus.BAD_REQUEST);
    }
}


