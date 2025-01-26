package com.projects.NetFlix.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "web_series")
public class WebSeries {

    @Id
    private ObjectId id;

    private String name;

    private String description;

    @DBRef
    private List<Movie> series = new ArrayList<> ();

}
