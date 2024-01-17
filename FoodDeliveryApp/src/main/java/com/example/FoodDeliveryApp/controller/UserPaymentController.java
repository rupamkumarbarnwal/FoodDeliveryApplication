package com.example.FoodDeliveryApp.controller;

import com.example.FoodDeliveryApp.entities.Order.OrderDetails;
import com.example.FoodDeliveryApp.entities.User.User;
import com.example.FoodDeliveryApp.entities.User.UserPayment;
import com.example.FoodDeliveryApp.repository.UserPaymentRepository;
import com.example.FoodDeliveryApp.services.UserPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserPaymentController {
    @Autowired
    UserPaymentService service;
    @PostMapping("/userPayment")
    public ResponseEntity<UserPayment> createUserPayment(@RequestBody UserPayment userPayment){
        UserPayment  temp = service.createUserPayment(userPayment);
        return new ResponseEntity<UserPayment>(userPayment, HttpStatus.CREATED);
    }
    @GetMapping("/userPayment/{paymentId}")
    public ResponseEntity<UserPayment> getPaymentByPaymentId(@PathVariable int id){
        UserPayment userPayment = service.getUserPaymentByPaymentId(id);
        return new ResponseEntity<UserPayment>(userPayment,HttpStatus.OK);
    }
    @GetMapping("/userPayments/{userid}")
    public ResponseEntity<List<UserPayment>> getAllPaymentsByUserId(@PathVariable int id){
       List< UserPayment> userPayments = service.getAllPaymentsByUserId(id);
        return new ResponseEntity<List<UserPayment>>(userPayments,HttpStatus.OK);
    }
    @GetMapping("/userPayment/{userid}")
    public ResponseEntity<UserPayment> getPaymentByUserId(@PathVariable int id){
         UserPayment userPayment = service.getUserPaymentByUserId(id);
        return new ResponseEntity<UserPayment>(userPayment,HttpStatus.OK);
    }
    @GetMapping("/userPayment/{orderId}")
    public ResponseEntity<UserPayment> getPaymentByOrderId(@PathVariable int id){
        UserPayment userPayment = service.getUserPaymentByOrderId(id);
        return new ResponseEntity<UserPayment>(userPayment,HttpStatus.OK);
    }
    @GetMapping("/userPayment/{transactionId}")
    public ResponseEntity<UserPayment> getPaymentByTransactionId(@PathVariable int id){
        UserPayment userPayment = service.getUserPaymentByTransactionId(id);
        return new ResponseEntity<UserPayment>(userPayment,HttpStatus.OK);
    }





}
