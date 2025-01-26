package com.projects.NetFlix.entity;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "movies")
@Data
public class Movie {

    @Id
    private ObjectId id;

    private String name;

    private String description;

    private List<String> genre;

    private int releaseYear;

    private int rating;
}
