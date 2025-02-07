package com.projects.netflix.cotroller;

import com.projects.netflix.dto.LoginDto;
import com.projects.netflix.dto.UserDto;
import com.projects.netflix.service.PublicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PublicController {

    @Autowired
    private PublicService pService;

    @Autowired
    private AuthenticationManager authManager;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto userDetails) {
        try {
            return new ResponseEntity<>(pService.register(userDetails), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto userLoginDTODetails) {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userLoginDTODetails.getEmail(), userLoginDTODetails.getPassword()));
            return new ResponseEntity<>("Welcome to Netflix", HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Unable to login to account: ", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
