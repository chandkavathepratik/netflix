package com.projects.netflix.service;

import com.projects.netflix.entity.Movie;
import com.projects.netflix.entity.User;
import com.projects.netflix.entity.enums.Subscription;
import com.projects.netflix.repository.MovieRepository;
import com.projects.netflix.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StreamingService {

    @Autowired
    private MovieRepository mRepo;

    @Autowired
    private UserRepository uRepo;

    public String stream(String movieId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = uRepo.findByUsername(username);



        if(user.getSubscription().equals(Subscription.NO) || user.getPlanExpiry().isBefore(LocalDate.now())){
            return "Please subscribe to continue watching..";
        }
        else {
            Movie movie =  mRepo.findById(new ObjectId(movieId)).orElse(null);
            if(movie!=null) {
                return movie.getUrl();
            }
            return "Url not found";
        }
    }

}
