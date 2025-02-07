package com.projects.netflix.service;

import com.projects.netflix.dto.UserDto;
import com.projects.netflix.entity.User;
import com.projects.netflix.entity.enums.Subscription;
import com.projects.netflix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PublicService {

    @Autowired
    private UserRepository uRepo;

    PasswordEncoder passEncoder = new BCryptPasswordEncoder();

    public String register(UserDto userDetails) {
        User user = new User();
        user.setEmail(userDetails.getEmail());
        user.setName(userDetails.getName());
        user.setPassword(passEncoder.encode(userDetails.getPassword()));
        user.setSubscription(Subscription.NO);
        uRepo.save(user);
        return "Account created";
    }
}
