package com.projects.netflix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class LoginDto {

    @NonNull
    private String email;

    @NonNull
    private String password;
}
