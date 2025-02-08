package com.projects.netflix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

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
