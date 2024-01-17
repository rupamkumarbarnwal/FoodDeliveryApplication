package com.example.FoodDeliveryApp.controller;

import com.example.FoodDeliveryApp.entities.Restaurant.Menu;

import com.example.FoodDeliveryApp.entities.User.User;
import com.example.FoodDeliveryApp.services.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class MenuController {
    @Autowired
    private MenuService service;
    @PostMapping("/menu")
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu){
        Menu temp= service.createMenu(menu);
        return new ResponseEntity<Menu>(temp, HttpStatus.CREATED);
    }
    @GetMapping("/menu/{restaurantId}")
    public ResponseEntity<Menu> getMenu(@PathVariable int restaurantId){
        Menu menu= service.getMenu(restaurantId);
        return new ResponseEntity<Menu>(menu,HttpStatus.OK);
    }
    @PutMapping("/menu")
    public ResponseEntity<Menu> updateMenu(@RequestBody Menu menu) {
        Menu updatedMenu= service.updateMenu(menu);
        return new ResponseEntity<Menu>(updatedMenu,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/menu/{menuId}")
    public ResponseEntity<String> deleteMenu(@PathVariable int menuId){
        return  new ResponseEntity<String>(service.deleteMenu(menuId),HttpStatus.OK);
    }
    @PostMapping(path="/menu/createFromCSV")
    public ResponseEntity<List<Menu>> createFromCSV(@RequestParam("file") MultipartFile file) throws IOException
    {
        return new ResponseEntity<List<Menu>>(service.createMenusFromCSV(file), HttpStatus.CREATED);
    }
}
