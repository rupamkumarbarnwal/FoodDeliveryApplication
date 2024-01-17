package com.example.FoodDeliveryApp.controller;

import com.example.FoodDeliveryApp.entities.Order.OrderDetails;
import com.example.FoodDeliveryApp.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping("/order")
    public ResponseEntity<String> createOrder(@RequestBody OrderDetails order) {
        String str = service.createOrder(order).toString();
        return new ResponseEntity<String>(str, HttpStatus.CREATED);
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<String> updateOrderStatus(
            @PathVariable("id") int orderId,
            @RequestBody OrderDetails order) {
        // Order updatedOrder = service.updateOrderStatus(orderId,status);
        String str = " Order status updated successfully";
        return new ResponseEntity<String>(str, HttpStatus.OK);

    }


    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDetails> getOrder(@PathVariable int id) {
        OrderDetails order = service.getOrder(id);
        return new ResponseEntity<OrderDetails>(order, HttpStatus.OK);
    }

    @GetMapping("/order/{userId}")
    public ResponseEntity<List<OrderDetails>> getAllOrderByUserId(@PathVariable int id) {
        return new ResponseEntity<List<OrderDetails>>(service.getAllOrdersByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/order/{restaurantId}")
    public ResponseEntity<List<OrderDetails>> getAllOrderByRestaurantId(@PathVariable int id) {
        return new ResponseEntity<List<OrderDetails>>(service.getAllOrdersByRestaurantId(id), HttpStatus.OK);
    }

    @GetMapping("/order/{riderId}")
    public ResponseEntity<List<OrderDetails>> getAllOrderByRiderId(@PathVariable int id) {
        return new ResponseEntity<List<OrderDetails>>(service.getAllOrdersByRiderId(id), HttpStatus.OK);
    }
        // For admin
        @GetMapping("/order")
        public ResponseEntity<List<OrderDetails>> getAllOrdersForAdmin() {
            return new ResponseEntity<List<OrderDetails>>(service.getAllOrdersForAdmin(), HttpStatus.OK);
        }
    }


    

