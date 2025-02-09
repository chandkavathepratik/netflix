package com.projects.netflix.cotroller;

import com.projects.netflix.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stream")
public class StreamingController {

    @Autowired
    private StreamingService streamingService;

    @GetMapping("/{movieId}")
    public ResponseEntity<String> stream(@PathVariable String movieId) {
        try {
            return new ResponseEntity<>(streamingService.stream(movieId), HttpStatus.FOUND);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
