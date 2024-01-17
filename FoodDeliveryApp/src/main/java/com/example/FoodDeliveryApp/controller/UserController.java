package com.example.FoodDeliveryApp.controller;

import com.example.FoodDeliveryApp.entities.User.User;
import com.example.FoodDeliveryApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UserController {
    @Autowired
    private UserService service;
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User temp= service.createUser(user);
        return new ResponseEntity<User>(temp, HttpStatus.CREATED);
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id){
        User user = service.getUser(id);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser= service.updateUser(user);
        return new ResponseEntity<User>(updatedUser,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("user/{id}/")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        return  new ResponseEntity<String>(service.blockUser(id),HttpStatus.OK);
    }
    @PutMapping("/user/{id}/image")
    public ResponseEntity<String> changeProfilePicture(@PathVariable int id, @RequestParam("file")MultipartFile file ){
        return new ResponseEntity<String>(service.changeProfilePicture(id,file),HttpStatus.OK);
    }
    @GetMapping(path="/user/{userId}/getProfilePicture")
    public ResponseEntity<InputStreamResource> getProfilePicture(@PathVariable int userId)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=userProfilePic.jpg");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.IMAGE_JPEG).body(service.getProfilePicture(userId));
    }



}
