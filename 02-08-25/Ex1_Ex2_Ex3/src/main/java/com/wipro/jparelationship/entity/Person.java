package com.wipro.jparelationship.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Person {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id") 
    private List<Post> posts;

	public Person(String name, List<Post> posts) {
		super();
		this.name = name;
		this.posts = posts;
	}

	public Person() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", posts=" + posts + "]";
	}
    
    
}
