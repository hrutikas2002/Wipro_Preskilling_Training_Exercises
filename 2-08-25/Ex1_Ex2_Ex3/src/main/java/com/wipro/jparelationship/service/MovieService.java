package com.wipro.jparelationship.service;

import java.util.List;

import com.wipro.jparelationship.entity.Movie;

public interface MovieService {
	Movie saveMovie(Movie movie);
    List<Movie> getAllMovies();
}
