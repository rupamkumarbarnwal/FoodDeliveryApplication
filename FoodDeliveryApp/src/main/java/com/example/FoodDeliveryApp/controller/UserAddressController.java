package com.example.FoodDeliveryApp.controller;

import com.example.FoodDeliveryApp.entities.Order.OrderDetails;
import com.example.FoodDeliveryApp.entities.User.User;
import com.example.FoodDeliveryApp.entities.User.UserAddress;
import com.example.FoodDeliveryApp.services.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserAddressController {
    @Autowired
    UserAddressService service;
    @PostMapping("/userAddress")
    public ResponseEntity<UserAddress> createUserAddress(@RequestBody UserAddress userAddress){
        UserAddress temp= service.createUserAddress(userAddress);
        return new ResponseEntity<UserAddress>(temp, HttpStatus.CREATED);
    }

    @GetMapping("/userAddress/{id}")
    public ResponseEntity<UserAddress> getUser(@PathVariable int id){
        UserAddress userAddress = service.getUserAddressByUserId(id);
        return new ResponseEntity<UserAddress>(userAddress,HttpStatus.OK);
    }

    @DeleteMapping("/userAddress")
    public ResponseEntity<String> deleteUserAddress(@PathVariable int id){
        return  new ResponseEntity<String>(service.deleteUserAddress(id),HttpStatus.OK);
    }
    @GetMapping("/userAddress/{userId}")
    public ResponseEntity<UserAddress> getUserAddressByUserId(@PathVariable int userId){
        return new ResponseEntity<UserAddress>(service.getUserAddressByUserId(userId),HttpStatus.OK);
    }
    @GetMapping("/userAddress/{city}")
    public ResponseEntity<List<UserAddress>> getAllUserAddressByCity(@PathVariable String city){
        return new ResponseEntity<List<UserAddress>>(service.getAllUserAddressByCity(city),HttpStatus.OK);

    }
    @GetMapping("/userAddress/{state}")
    public ResponseEntity<List<UserAddress>> getAllUserAddressByState(@PathVariable String state ){
        return new ResponseEntity<List<UserAddress>>(service.getAllUserAddressByState(state),HttpStatus.OK);
    }
    @GetMapping("/userAddress/{pinCode}")
    public ResponseEntity<List<UserAddress>> getAllUserAddressByPinCode(@PathVariable int pinCode){
        return new ResponseEntity<List<UserAddress>>(service.getAllUserAddressByPinCode(pinCode),HttpStatus.OK);
    }
    @GetMapping("/userAddress")
    public ResponseEntity<List<UserAddress>>  getAllUserAddress() {
        return new ResponseEntity<List<UserAddress>>(service.getAllUserAddress(),HttpStatus.OK);
    }

}
