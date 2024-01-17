package com.example.FoodDeliveryApp.controller;

import com.example.FoodDeliveryApp.entities.Rider.Rider;
import com.example.FoodDeliveryApp.services.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RiderController {
    @Autowired
    private RiderService service;
    @PostMapping("/rider")
    public ResponseEntity<String> createRider(@RequestBody Rider rider){
        String str = String.valueOf(service.createRider(rider));
        return new ResponseEntity<String>(str, HttpStatus.CREATED);
    }
    @GetMapping("/rider/{id}")
    public ResponseEntity<Rider> getRider(@PathVariable int id){
        Rider rider = service.getRider(id);
        return new ResponseEntity<Rider>(rider,HttpStatus.OK);
    }
    @PutMapping("/rider")
    public ResponseEntity<Rider> updateRider(@RequestBody Rider rider ) {
        Rider updatedRider= service.updateRider(rider);
        return new ResponseEntity<Rider>(updatedRider,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/rider/{id}")
    public ResponseEntity <String> deleteRider(@PathVariable int id ){
        return  new ResponseEntity<String>(service.deleteRider(id),HttpStatus.OK);
    }

}
