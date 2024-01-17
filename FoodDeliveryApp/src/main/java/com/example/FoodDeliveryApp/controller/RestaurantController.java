package com.example.FoodDeliveryApp.controller;

import com.example.FoodDeliveryApp.entities.Restaurant.Restaurant;
import com.example.FoodDeliveryApp.entities.User.User;
import com.example.FoodDeliveryApp.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;
    @PostMapping("/restaurant")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant  restaurant){
        Restaurant temp= restaurantService.createRestaurant(restaurant);
        return new ResponseEntity<Restaurant>(temp, HttpStatus.CREATED);
    }


    @GetMapping("/restaurant/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable int id){
        Restaurant restaurant = restaurantService.getRestaurant(id);
        return new ResponseEntity<Restaurant>(restaurant,HttpStatus.OK);
    }
    @PutMapping("/restaurant")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant updatedRestaurant= restaurantService.updateRestaurant(restaurant);
        return new ResponseEntity<Restaurant>(updatedRestaurant,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/restaurant")
    public ResponseEntity<String> deleteRestaurant(@RequestParam int id){
        return  new ResponseEntity<String>(restaurantService.deleteRestaurant(id),HttpStatus.OK);
    }






}
