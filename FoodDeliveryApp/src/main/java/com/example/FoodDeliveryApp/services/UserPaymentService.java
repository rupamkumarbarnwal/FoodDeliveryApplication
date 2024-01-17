package com.example.FoodDeliveryApp.services;

import com.example.FoodDeliveryApp.Exception.EntityNotFoundException;
import com.example.FoodDeliveryApp.entities.User.UserPayment;
import com.example.FoodDeliveryApp.repository.UserPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPaymentService {
    @Autowired
    UserPaymentRepository paymentRepository;
    public UserPayment createUserPayment(UserPayment userPayment){
        paymentRepository.save(userPayment);
        return userPayment;
    }
    public UserPayment getUserPaymentByPaymentId(int userPaymentId) {
        return (UserPayment) paymentRepository.findById(userPaymentId).orElseThrow(() -> new EntityNotFoundException("UserPayment with given id does not exist"));
    }

    public List<UserPayment> getAllPaymentsByUserId(int userId){
        return (List<UserPayment>) paymentRepository.findAllPaymentsByUserId(userId);
    }

    public UserPayment getUserPaymentByTransactionId(int  transactionId){
        return paymentRepository.findUserPaymentByTransactionId(transactionId);
    }
    public UserPayment getUserPaymentByUserId(int userId){
        return paymentRepository.findUserPaymentByUserId(userId);
    }
    public UserPayment getUserPaymentByOrderId(int orderId){
        return paymentRepository.findUserPaymentByOrderId(orderId);
    }



}
