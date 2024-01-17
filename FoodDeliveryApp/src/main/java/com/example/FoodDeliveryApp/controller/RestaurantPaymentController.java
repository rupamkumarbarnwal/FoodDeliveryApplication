package com.example.FoodDeliveryApp.controller;

import com.example.FoodDeliveryApp.entities.Restaurant.RestaurantPayment;
import com.example.FoodDeliveryApp.entities.User.UserPayment;
import com.example.FoodDeliveryApp.services.RestaurantPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class RestaurantPaymentController {
    @Autowired
    RestaurantPaymentService restaurantPaymentService;
    @PostMapping("/restaurantPayment")
    public ResponseEntity<RestaurantPayment> createRestaurantPayment(@RequestBody RestaurantPayment restaurantPayment){
        RestaurantPayment  temp = restaurantPaymentService.createRestaurantPayment(restaurantPayment);
        return new ResponseEntity<RestaurantPayment>(restaurantPayment, HttpStatus.CREATED);
    }
    @GetMapping("/restaurantPayment/{restaurantId}")
    public ResponseEntity<RestaurantPayment> getPaymentByRestaurantId(@PathVariable int id){
        RestaurantPayment restaurantPayment = restaurantPaymentService.getPaymentByRestaurantId(id);
        return new ResponseEntity<RestaurantPayment>(restaurantPayment,HttpStatus.OK);
    }

    @GetMapping("/restaurantPayments/{restaurantId}")
    public ResponseEntity<List<RestaurantPayment>> getAllPaymentsByRestaurantId(@PathVariable int restaurantId){
        List< RestaurantPayment> restaurantPayments = restaurantPaymentService.getAllPaymentsByRestaurantId(restaurantId);
        return new ResponseEntity<List<RestaurantPayment>>(restaurantPayments,HttpStatus.OK);
    }


    @GetMapping("/restaurantPayment/{transactionId}")
    public ResponseEntity<RestaurantPayment> getRestaurantPaymentByTransactionId(@PathVariable int transactionId){
        RestaurantPayment restaurantPayment = restaurantPaymentService.getRestaurantPaymentByTransactionId(transactionId);
        return new ResponseEntity<RestaurantPayment>(restaurantPayment,HttpStatus.OK);
    }
}
