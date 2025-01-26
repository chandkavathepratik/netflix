package com.projects.NetFlix.entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
@Data
public class User {

    @Id
    private ObjectId userId;

    @NonNull
    private String email;

    @NonNull
    private String password;

    private List<Movie> watchHistory;

    private List<Movie> wishlist;

    private String subscription;

}
