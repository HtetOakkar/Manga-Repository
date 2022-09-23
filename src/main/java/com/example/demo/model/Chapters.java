package com.example.demo.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Chapters")
public class Chapters {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="manga_id", insertable = false, updatable = false)
	private Manga manga;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chapter_id")
	private Long chaptId;

	@Column(name = "manga_id")
	private Long mangaId;
	@Column(name = "title")
	private String chaptTitle;
	
	public Manga getManga() {
		return manga;
	}

	public void setManga(Manga manga) {
		this.manga = manga;
	}

	@Column(name = "description")
	private String chaptDescription;
	@Column(name = "rating")
	private double chaptRating;
	@Column(name = "image_url")
	private String imgUrl;
	@Column(updatable = false)
	@CreationTimestamp
	private Instant createdAt;

	public Long getChaptId() {
		return chaptId;
	}

	public void setChaptId(Long chaptId) {
		this.chaptId = chaptId;
	}

	public Long getMangaId() {
		return mangaId;
	}

	public void setMangaId(Long mangaId) {
		this.mangaId = mangaId;
	}

	public String getChaptTitle() {
		return chaptTitle;
	}

	public void setChaptTitle(String chaptTitle) {
		this.chaptTitle = chaptTitle;
	}

	public String getChaptDescription() {
		return chaptDescription;
	}

	public void setChaptDescription(String chaptDescription) {
		this.chaptDescription = chaptDescription;
	}

	public double getChaptRating() {
		return chaptRating;
	}

	public void setChaptRating(double chaptRating) {
		this.chaptRating = chaptRating;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

}
