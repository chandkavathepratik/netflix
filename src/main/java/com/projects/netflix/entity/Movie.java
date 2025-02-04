package com.projects.netflix.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "movies")
@Data
@NoArgsConstructor
public class Movie {

    @Id
    private ObjectId id;

    @NonNull
    private String title;

    @NonNull
    private String description;

    @NonNull
    private List<String> genre;

    @NonNull
    private Integer releaseYear;

    @NonNull
    private String thumbnailUrl;

    @NonNull
    private String url;

}
