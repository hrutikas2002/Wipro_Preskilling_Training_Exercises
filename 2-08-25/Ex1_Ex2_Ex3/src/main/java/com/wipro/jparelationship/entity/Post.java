package com.wipro.jparelationship.entity;

import jakarta.persistence.*;

@Entity
public class Post {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

	public Post(String message) {
		super();
		this.message = message;
	}

	public Post() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", message=" + message + "]";
	}
    
    
}
