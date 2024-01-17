package com.example.FoodDeliveryApp.controller;

import com.example.FoodDeliveryApp.entities.Restaurant.RestaurantRating;
import com.example.FoodDeliveryApp.entities.Rider.RiderRating;
import com.example.FoodDeliveryApp.services.RiderRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class RiderRatingController {
    @Autowired
    RiderRatingService riderRatingService;
    @PostMapping("/riderRating")
    public ResponseEntity<RiderRating> addRiderRating(@RequestBody RiderRating riderRating) {
        RiderRating temp = riderRatingService.addRiderRating(riderRating);
        return new ResponseEntity<RiderRating>(temp, HttpStatus.CREATED);
    }

    @GetMapping("/riderRating")
   public ResponseEntity<List<RiderRating>> getAllRiderRating(){
        return new ResponseEntity<List<RiderRating>>(riderRatingService.getAllRiderRatings(),HttpStatus.OK);
    }
    @GetMapping("/riderRating/{riderRatingId}")
    public ResponseEntity<RiderRating> getRiderRatingFromRiderRatingId(@RequestParam int riderRatingId){
        RiderRating riderRating = riderRatingService.getRiderRatingFromRiderRatingId( riderRatingId);
        return new ResponseEntity<RiderRating>(riderRating,HttpStatus.OK);
    }
    @GetMapping("/riderRating/{riderId}")
    public ResponseEntity<List<RiderRating>> getRiderRatingByRiderId(@RequestParam int riderId){
        return new ResponseEntity<List<RiderRating>>(riderRatingService.getRiderRatingByRiderId(riderId),HttpStatus.OK);
    }

    @GetMapping("/riderRating/{riderId}/{userId}")
    public ResponseEntity<RiderRating>getRiderRatingByUserIdAndRiderId(@RequestParam int riderId,@RequestParam int userId){
        return new ResponseEntity<RiderRating>(riderRatingService.getRiderRatingByUserIdAndRiderId(riderId,userId),HttpStatus.OK);
    }
    @PutMapping("/riderRating/{riderId}")
    public ResponseEntity<RiderRating > updateRiderRating(@RequestParam int riderId,@RequestParam int rating){
        RiderRating riderRating = riderRatingService.updateRiderRating(riderId,rating);
        return new ResponseEntity<RiderRating>(riderRating,HttpStatus.OK);
    }
    @DeleteMapping("/riderRating/{riderId}")
    public ResponseEntity<String> deleteRiderRating(@RequestParam int riderId){
        return  new ResponseEntity<String>(riderRatingService.deleteRiderRating(riderId),HttpStatus.OK);
    }

}
