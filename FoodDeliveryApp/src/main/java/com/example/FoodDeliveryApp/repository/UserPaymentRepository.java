package com.example.FoodDeliveryApp.repository;

import com.example.FoodDeliveryApp.entities.User.UserPayment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPaymentRepository extends CrudRepository<UserPayment,Integer> {

    public UserPayment findUserPaymentByTransactionId(int  transactionId);
    public List<UserPayment> findAllPaymentsByUserId(int userId);

    public UserPayment findUserPaymentByOrderId(int orderId);
    public UserPayment findUserPaymentByUserId(int userId);













}
