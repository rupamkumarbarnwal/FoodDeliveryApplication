package com.example.FoodDeliveryApp.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.FoodDeliveryApp.entities.User.UserAddress;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAddressRepository extends CrudRepository<UserAddress,Integer> {

    public List<UserAddress> findAllUserAddressByCity(  String city);
    public List<UserAddress> findAllUserAddressByState( String state);
    public List<UserAddress> findAllUserAddressByPinCode ( int pinCode);


    public UserAddress findUserAddressByUser_UserId(int userId);



}
