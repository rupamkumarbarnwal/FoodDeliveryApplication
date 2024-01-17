package com.example.FoodDeliveryApp.controller;

import com.example.FoodDeliveryApp.entities.Restaurant.RestaurantPayment;
import com.example.FoodDeliveryApp.entities.Rider.RiderPayment;
import com.example.FoodDeliveryApp.services.RiderPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class RiderPaymentController {
    @Autowired
    RiderPaymentService riderPaymentService;
    @PostMapping("/riderPayment")
    public ResponseEntity<RiderPayment> createRiderPayment(@RequestBody RiderPayment riderPayment){
        RiderPayment  temp = riderPaymentService.createRiderPayment(riderPayment);
        return new ResponseEntity<RiderPayment>(riderPayment, HttpStatus.CREATED);
    }
    @GetMapping("/riderPayment/{riderId}")
    public ResponseEntity<RiderPayment> getRiderPaymentByRiderId(@PathVariable int id){
        RiderPayment riderPayment = riderPaymentService.getRiderPaymentByRiderId(id);
        return new ResponseEntity<RiderPayment>(riderPayment,HttpStatus.OK);
    }
    @GetMapping("/riderPayments/{riderId}")
    public ResponseEntity<List<RiderPayment>> getAllPaymentsByRiderId(@PathVariable int riderId){
        List<RiderPayment> riderPayments = riderPaymentService.getAllPaymentsByRiderId(riderId);
        return new ResponseEntity<List<RiderPayment>>(riderPayments,HttpStatus.OK);
    }

    @GetMapping("/riderPayment/{transactionId}")
    public ResponseEntity<RiderPayment> getRiderPaymentByTransactionId(@PathVariable int transactionId){
        RiderPayment riderPayment = riderPaymentService.getRiderPaymentByTransactionId(transactionId);
        return new ResponseEntity<RiderPayment>(riderPayment,HttpStatus.OK);
    }
}
