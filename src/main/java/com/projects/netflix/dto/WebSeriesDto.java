package com.projects.netflix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebSeriesDto extends MovieDto {

    @DBRef
    private List<String> episodes = new ArrayList<>();

}
