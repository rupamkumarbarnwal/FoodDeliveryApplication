package com.example.FoodDeliveryApp.services;

import com.example.FoodDeliveryApp.Exception.EntityNotFoundException;
import com.example.FoodDeliveryApp.entities.Restaurant.RestaurantRating;
import com.example.FoodDeliveryApp.entities.Rider.RiderRating;
import com.example.FoodDeliveryApp.repository.RiderRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderRatingService {
    @Autowired
    RiderRatingRepository riderRatingRepository;
    public RiderRating addRiderRating(RiderRating riderRating ){
        riderRatingRepository.save(riderRating);
        return riderRating;
    }
    public List<RiderRating> getAllRiderRatings()
    {
        return (List<RiderRating>) riderRatingRepository.findAll();
    }
    public RiderRating getRiderRatingFromRiderRatingId(int riderRatingId)
    {
        return riderRatingRepository.findById(riderRatingId).orElseThrow(()->new EntityNotFoundException("No RiderRating exists with this riderRatingId"));
    }

    public List<RiderRating> getRiderRatingByRiderId(int riderId)
    {
        return riderRatingRepository.findRiderRatingByRiderId(riderId);
    }

    public List<RiderRating> getRiderRatingByUserId(int userId)
    {
        return riderRatingRepository.findRiderRatingByUserId(userId);
    }

    public RiderRating getRiderRatingByUserIdAndRiderId(int userId, int riderId)
    {
        return riderRatingRepository.findRiderRatingByUserIdAndRiderId(riderId, userId);
    }

    public RiderRating updateRiderRating(int riderId,int rating)
    {
        RiderRating old_rating  = riderRatingRepository.findById(riderId).orElseThrow(() -> new EntityNotFoundException("Rider with given id does not exist"));
        old_rating.setRating(rating);

        return old_rating;

    }
    public String deleteRiderRating(int riderId){
        riderRatingRepository.deleteById(riderId);
        return "Restaurant rating deleted successfully";


    }


}
