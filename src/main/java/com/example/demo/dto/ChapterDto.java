package com.example.demo.dto;

import java.time.Instant;

public class ChapterDto {
	private Long chaptId;
	private String chaptTitle;
	private String chaptDescription;
	private String imageUrl;
	private double chaptRating;
	private Instant createdAt;
	private Long mangaId;
	public Long getMangaId() {
		return mangaId;
	}

	public void setMangaId(Long mangaId) {
		this.mangaId = mangaId;
	}

	public Long getChaptId() {
		return chaptId;
	}

	public void setChaptId(Long chaptId) {
		this.chaptId = chaptId;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getChaptRating() {
		return chaptRating;
	}

	public void setChaptRating(double chaptRating) {
		this.chaptRating = chaptRating;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
}
