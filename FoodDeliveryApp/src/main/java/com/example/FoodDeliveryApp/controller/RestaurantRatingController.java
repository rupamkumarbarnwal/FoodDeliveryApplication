package com.example.FoodDeliveryApp.controller;

import com.example.FoodDeliveryApp.entities.Restaurant.RestaurantRating;
import com.example.FoodDeliveryApp.entities.User.User;
import com.example.FoodDeliveryApp.repository.RestaurantRatingRepository;
import com.example.FoodDeliveryApp.services.RestaurantRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantRatingController {
    @Autowired
    RestaurantRatingService restaurantRatingService;

    @PostMapping("/restaurantRating")
    public ResponseEntity<RestaurantRating> addRestaurantRating(@RequestBody RestaurantRating restaurantRating) {
        RestaurantRating temp = restaurantRatingService.addRestaurantRating(restaurantRating);
        return new ResponseEntity<RestaurantRating>(temp, HttpStatus.CREATED);
    }

    @GetMapping("/restaurantRating/{restaurantId}")
    public ResponseEntity<RestaurantRating> getRestaurantRatingByRestaurantId(@RequestParam int restaurantId) {
        RestaurantRating restaurantRating = restaurantRatingService.getRestaurantRatingByRestaurantId(restaurantId);
        return new ResponseEntity<RestaurantRating>(restaurantRating, HttpStatus.OK);

    }
    @GetMapping("/restaurantRating/{userId}/{restaurantId}")
    public ResponseEntity<RestaurantRating> getRestaurantRatingByUserId(@RequestParam int userId, @RequestParam int restaurantId) {
        RestaurantRating restaurantRating = restaurantRatingService.getRestaurantRatingByUserId(userId, restaurantId);
        return new ResponseEntity<RestaurantRating>(restaurantRating, HttpStatus.OK);
    }


    @PutMapping("/restaurantRating/{restaurantId}")
    public ResponseEntity<RestaurantRating > updateRestaurantRating(@RequestParam int restaurantId,@RequestParam int rating){
        RestaurantRating restaurantRating = restaurantRatingService.updateRestaurantRating(restaurantId,rating);
        return new ResponseEntity<RestaurantRating>(restaurantRating,HttpStatus.OK);
    }
    @DeleteMapping("/restaurantRating/{restaurantId}")
    public ResponseEntity<String> deleteRestaurantRating(@PathVariable int restaurantId){
        return  new ResponseEntity<String>(restaurantRatingService.deleteRestaurantRating(restaurantId),HttpStatus.OK);
    }

}


