package com.example.demo.model;

import java.time.Instant;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Manga")
public class Manga {
	
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "manga_id", updatable = false, insertable = false)
	private Set<Chapters> chapter;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="manga_id")
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "description")
	private String description;

	@Column(name = "rating")
	private double rating;

	@Column(updatable = false)
	@CreationTimestamp
	private Instant createdAt;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

}
