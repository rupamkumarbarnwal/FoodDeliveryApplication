package com.example.FoodDeliveryApp.services;

import com.example.FoodDeliveryApp.Exception.InvalidDataException;
import com.example.FoodDeliveryApp.entities.User.User;
import com.example.FoodDeliveryApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class UserService
{
    @Autowired
   private  UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public User createUser(User user)

    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
        return user;
    }

    public User getUser(int id)
    {
        return (User) repository.findById(id).orElseThrow(()-> new InvalidDataException("User with such id does not exist"));
    }

    public User updateUser(User user) throws RuntimeException
    {
        User old_user = getUser(user.getUserId());
        if(user.getName()==null || user.getPhoneNumber()==null || user.getPassword()==null)
            throw new InvalidDataException("Name , phonenumber and password cannot be null");
        old_user.setName(user.getName());
        old_user.setPhoneNumber(user.getPhoneNumber());
        old_user.setUserId(user.getUserId());
        old_user.setPassword(user.getPassword());
        old_user.setAge(user.getAge());
        old_user.setImage(user.getImage());
        old_user.setValid(user.getValid());
       old_user.setMail(user.getMail());
       repository.save(old_user);
       return old_user;

    }

    public String  changeProfilePicture(int userId, MultipartFile file)  {
        User user = getUser(userId);
        try {
            user.setImage(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        repository.save(user);
        return "Profile picture changed successfully";
    }

    public  String blockUser(int userId)
    {
        getUser(userId);
        repository.deleteById(userId);
        return "User with given userId is blocked successfully";

    }
    public InputStreamResource getProfilePicture(int userId)
    {
        byte[] bytes = getUser(userId).getImage();
        InputStream stream = new ByteArrayInputStream(bytes);
        InputStreamResource resource = new InputStreamResource(stream);
        return resource;
    }

}
