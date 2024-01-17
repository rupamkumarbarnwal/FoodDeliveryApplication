package com.example.FoodDeliveryApp.repository;

import com.example.FoodDeliveryApp.entities.Rider.RiderRating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiderRatingRepository extends CrudRepository<RiderRating,Integer>{


    public List<RiderRating> findRiderRatingByRiderId(int riderId);


    public List<RiderRating> findRiderRatingByUserId(int userId);


    public RiderRating findRiderRatingByUserIdAndRiderId(int userId, int riderId);



}
