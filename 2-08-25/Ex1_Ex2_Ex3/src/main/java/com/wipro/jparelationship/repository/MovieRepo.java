package com.wipro.jparelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.jparelationship.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie, Long>{

}
