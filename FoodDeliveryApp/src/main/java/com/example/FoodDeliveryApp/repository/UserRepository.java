package com.example.FoodDeliveryApp.repository;

import com.example.FoodDeliveryApp.entities.User.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    public Optional<User> findByMail(String mail);

}
