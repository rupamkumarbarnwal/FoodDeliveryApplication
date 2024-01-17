package com.example.FoodDeliveryApp.services;

import com.example.FoodDeliveryApp.Exception.EntityNotFoundException;
import com.example.FoodDeliveryApp.Exception.InvalidDataException;
import com.example.FoodDeliveryApp.entities.Order.OrderDetails;
import com.example.FoodDeliveryApp.entities.Restaurant.Menu;
import com.example.FoodDeliveryApp.entities.User.UserAddress;
import com.example.FoodDeliveryApp.repository.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressService {
    @Autowired
    UserAddressRepository userAddressRepository;

    public UserAddress createUserAddress(UserAddress address) {
        userAddressRepository.save(address);
        return address;
    }

    public UserAddress getAddressById(int addressId) {
        return (UserAddress) userAddressRepository.findById(addressId).orElseThrow(() -> new InvalidDataException("No restaurant  exist"));
    }

    public UserAddress updateAddress(UserAddress address) {
        UserAddress old_address = getAddressById(address.getAddressId());
        if (old_address.getUser().getUserId() == 0 || old_address.getAddress() == null || old_address.getPinCode() == 0)
            old_address.setCity(address.getCity());
        old_address.setAddress(address.getAddress());
        old_address.setState(address.getState());
        old_address.setPinCode(address.getPinCode());
        userAddressRepository.save(address);
        return old_address;
    }
    public String deleteUserAddress(int addressId) {
        getUserAddressByUserId(addressId);
        userAddressRepository.deleteById(addressId);
        return "User with given addressId is deleted  successfully";

    }
    public List<UserAddress> getAllUserAddress(){
        return (List<UserAddress>) userAddressRepository.findAll();
    }

    public List<UserAddress> getAllUserAddressByCity(String city){
        return(List<UserAddress>) userAddressRepository.findAllUserAddressByCity(city);
    }
    public List<UserAddress> getAllUserAddressByState(String state){
        return(List<UserAddress>) userAddressRepository.findAllUserAddressByState(state);
    }
    public List<UserAddress> getAllUserAddressByPinCode(int pinCode){
        return(List<UserAddress>) userAddressRepository.findAllUserAddressByPinCode(pinCode);
    }
    public UserAddress getUserAddressByUserId(int userId){
        return  userAddressRepository.findUserAddressByUser_UserId(userId);
    }
}

