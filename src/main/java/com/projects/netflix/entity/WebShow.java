package com.projects.netflix.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "web_shows")
@Data
public class WebShow extends Movie {

    @DBRef
    private List<Movie> episodes = new ArrayList<> ();

}
