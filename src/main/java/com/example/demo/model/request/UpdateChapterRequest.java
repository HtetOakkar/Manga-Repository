package com.example.demo.model.request;

public class UpdateChapterRequest {

	private String chaptTitle;
	private String chaptDescription;
	private double chaptRating;
	private String imgUrl;
	private Long mangaId;

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
}
