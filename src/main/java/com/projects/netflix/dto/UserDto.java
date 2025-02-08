package com.projects.netflix.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserDto {

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String password;

}
