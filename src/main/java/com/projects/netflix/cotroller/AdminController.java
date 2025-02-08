package com.projects.netflix.cotroller;

import com.projects.netflix.dto.MovieDto;
import com.projects.netflix.dto.WebSeriesDto;
import com.projects.netflix.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add-new-movie")
    public ResponseEntity<String> addNewMovie(@RequestBody MovieDto newMovie) {
        try {
            return new ResponseEntity<>(adminService.addNewMovie(newMovie), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-movie/{movieId}")
    public ResponseEntity<String> updateMovie(@PathVariable String movieId, @RequestBody MovieDto updatedMovie) {
        try {
            return new ResponseEntity<>(adminService.updateMovie(movieId, updatedMovie), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-movie/{movieId}")
    public ResponseEntity<String> deleteMovie(@PathVariable String movieId) {
        try {
            return new ResponseEntity<>(adminService.deleteMovie(movieId), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add-new-web-series")
    public ResponseEntity<String> addNewWebSeries(@RequestBody WebSeriesDto newWebSeries) {
        try {
            return new ResponseEntity<>(adminService.addNewWebSeries(newWebSeries), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-web-series/{webSeriesId}")
    public ResponseEntity<String> updateWebSeries(@PathVariable String webSeriesId, @RequestBody WebSeriesDto updatedWebSeries) {
        try {
            return new ResponseEntity<>(adminService.updateWebSeries(webSeriesId, updatedWebSeries), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-web-series/{webSeriesId}")
    public ResponseEntity<String> deleteWebSeries(@PathVariable String webSeriesId) {
        try {
            return new ResponseEntity<>(adminService.deleteWebSeries(webSeriesId), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
