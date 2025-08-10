package com.wipro.jparelationship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.jparelationship.entity.Movie;
import com.wipro.jparelationship.repository.MovieRepo;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepo movieRepo;

	@Override
	public Movie saveMovie(Movie movie) {
		return movieRepo.save(movie);
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepo.findAll();
	}
	
	
}
