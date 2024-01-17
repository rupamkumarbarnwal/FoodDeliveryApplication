package com.example.FoodDeliveryApp.services;

import com.example.FoodDeliveryApp.Exception.InvalidDataException;
import com.example.FoodDeliveryApp.entities.Rider.Rider;
import com.example.FoodDeliveryApp.entities.Enum.RiderAvailability;
import com.example.FoodDeliveryApp.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiderService {
    @Autowired
    RiderRepository repository;

    public Rider createRider(Rider rider){
        repository.save(rider);
        return rider;
    }
    public Rider getRider(int id)
    {
        return (Rider) repository.findById(id).orElseThrow(()-> new InvalidDataException("Rider with such id does not exist"));
    }
    public Rider  updateRider(Rider rider) throws RuntimeException
    {
        Rider old_rider = getRider(rider.getRiderId());
        if(rider.getName()==null || rider.getPhoneNumber()==null || rider.getPassword()==null)
            throw new InvalidDataException("Name , phonenumber and password cannot be null");
        old_rider.setName(rider.getName());
        old_rider.setPhoneNumber(rider.getPhoneNumber());
        old_rider.setRiderId(rider.getRiderId());
        old_rider.setPassword(rider.getPassword());
        // old_user.setValid(user.getValid());
        old_rider.setMail(rider.getMail());
        repository.save(old_rider);
        return old_rider;
    }
    public String deleteRider(int riderId ){
        repository.deleteById(riderId);
        return "Rider with given riderId is blocked successfully";
    }
    public boolean getRiderAvailability(int riderId){
        Rider old_rider = getRider(riderId);
         return old_rider.isAvailable();

    }
    public boolean  setRiderAvailability(int riderId, boolean status){
            Rider old_rider =  getRider(riderId);
            old_rider.setAvailable(status);
            repository.save(old_rider);
            return true;
    }


}
