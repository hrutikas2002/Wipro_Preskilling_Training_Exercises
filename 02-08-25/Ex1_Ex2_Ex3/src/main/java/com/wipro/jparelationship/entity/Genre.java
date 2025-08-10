package com.wipro.jparelationship.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Genre {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Description")
	private String description;
	@ManyToMany(mappedBy="genres")
	List<Movie> movies;
	
	public Genre(String description, List<Movie> movies) {
		super();
		this.description = description;
		this.movies = movies;
	}

	public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", movies=" + movies + ", description=" + description + "]";
	}
}
