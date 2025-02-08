package com.projects.netflix.service;

import com.projects.netflix.dto.MovieDto;
import com.projects.netflix.dto.WebSeriesDto;
import com.projects.netflix.entity.Movie;
import com.projects.netflix.entity.WebShow;
import com.projects.netflix.repository.MovieRepository;
import com.projects.netflix.repository.WebSeriesRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {

    @Autowired
    private MovieRepository mRepo;

    @Autowired
    private WebSeriesRepository seriesRepo;

    public String addNewMovie(MovieDto newMovie) {
        Movie movie = new Movie();
        movie.setTitle(newMovie.getTitle());
        movie.setDescription(movie.getDescription());
        movie.setThumbnailUrl(newMovie.getThumbnailUrl());
        movie.setReleaseYear(newMovie.getReleaseYear());
        movie.setGenre(newMovie.getGenre());
        movie.setUrl(newMovie.getUrl());
        mRepo.save(movie);
        return "Movie added";
    }

    @Transactional
    public String updateMovie(String movieId, MovieDto updatedMovie) {
        Movie old = mRepo.findById(new ObjectId(movieId)).orElse(null);

        if(old!=null) {
            old.setTitle(updatedMovie.getTitle());
            old.setDescription(updatedMovie.getDescription());
            old.setThumbnailUrl(updatedMovie.getThumbnailUrl());
            old.setReleaseYear(updatedMovie.getReleaseYear());
            old.setGenre(updatedMovie.getGenre());
            old.setUrl(updatedMovie.getUrl());
            mRepo.save(old);
        }
        return "Movie Updated";
    }

    public String deleteMovie(String movieId) {
        mRepo.deleteById(new ObjectId(movieId));
        return "Movie deleted";
    }

    @Transactional
    public String addNewWebSeries(WebSeriesDto webSeries) {
        WebShow series = new WebShow();
        series.setTitle(webSeries.getTitle());
        series.setDescription(webSeries.getDescription());
        series.setThumbnailUrl(webSeries.getThumbnailUrl());
        series.setReleaseYear(webSeries.getReleaseYear());
        series.setGenre(webSeries.getGenre());
        series.setUrl(webSeries.getUrl());
        for(String episodes : webSeries.getEpisodes()) {
            series.getEpisodes().add(mRepo.findById(new ObjectId(episodes)).orElse(null));
        }
        seriesRepo.save(series);
        return "Series added";
    }

    @Transactional
    public String updateWebSeries(String webSeriesId, WebSeriesDto updatedWebSeries) {
        WebShow old = seriesRepo.findById(new ObjectId(webSeriesId)).orElse(null);

        if(old!=null) {
            old.setTitle(updatedWebSeries.getTitle());
            old.setDescription(updatedWebSeries.getDescription());
            old.setThumbnailUrl(updatedWebSeries.getThumbnailUrl());
            old.setReleaseYear(updatedWebSeries.getReleaseYear());
            old.setGenre(updatedWebSeries.getGenre());
            old.setUrl(updatedWebSeries.getUrl());
            for(String episodes : updatedWebSeries.getEpisodes()) {
                old.getEpisodes().clear();
                old.getEpisodes().add(mRepo.findById(new ObjectId(episodes)).orElse(null));
            }
            mRepo.save(old);
        }
        return "Series Updated";

    }

    public String deleteWebSeries(String webSeriesId) {
        seriesRepo.deleteById(new ObjectId(webSeriesId));
        return "Series deleted";
    }
}
