package com.wipro.jparelationship.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name="Movie_title")
	String Title;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "movie_genre",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String title, List<Genre> genres) {
		super();
		Title = title;
		this.genres = genres;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", Title=" + Title + ", genres=" + genres + "]";
	}
	
	
	
}
