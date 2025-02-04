package com.projects.netflix.entity;

import com.projects.netflix.entity.enums.Subscription;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    private ObjectId userId;

    @NonNull
    private String name;

    @NonNull
    @Indexed(unique = true)
    private String email;

    @NonNull
    private String password;

    private List<Movie> watchHistory;

    private List<Movie> wishlist;

    private Subscription subscription;

    private LocalDate planExpiry;

}
