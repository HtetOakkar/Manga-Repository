package com.example.demo.dto;

import org.springframework.stereotype.Component;

import com.example.demo.model.Chapters;
import com.example.demo.model.request.ChapterRequest;
import com.example.demo.model.response.ChapterResponse;

@Component
public class ChapterMapperImpl implements ChapterMapper {

	@Override
	public ChapterDto toDto(ChapterRequest request) {
		ChapterDto chapterDto = new ChapterDto();
		chapterDto.setChaptTitle(request.getChaptTitle());
		chapterDto.setChaptDescription(request.getChaptDescription());
		chapterDto.setChaptRating(request.getChaptRating());
		chapterDto.setImageUrl(request.getImgUrl());
		chapterDto.setMangaId(request.getMangaId());
		return chapterDto;
	}

	@Override
	public ChapterResponse toChapterResponse(ChapterDto chapterDto) {
		ChapterResponse response = new ChapterResponse();
		response.setChaptId(chapterDto.getChaptId());
		response.setChaptTitle(chapterDto.getChaptTitle());
		response.setMangaId(chapterDto.getMangaId());
		response.setChaptDescription(chapterDto.getChaptDescription());
		response.setChaptRating(chapterDto.getChaptRating());
		response.setImgUrl(chapterDto.getImageUrl());
		response.setCreatedAt(chapterDto.getCreatedAt());
		return response;
	}

	@Override
	public Chapters toEntity(ChapterDto chapterDto) {
		Chapters chapter = new Chapters();
		chapter.setChaptId(chapterDto.getChaptId());
		chapter.setMangaId(chapterDto.getMangaId());
		chapter.setChaptTitle(chapterDto.getChaptTitle());
		chapter.setChaptDescription(chapterDto.getChaptDescription());
		chapter.setChaptRating(chapterDto.getChaptRating());
		chapter.setImgUrl(chapterDto.getImageUrl());
		chapter.setCreatedAt(chapterDto.getCreatedAt());
		return chapter;
	}

	@Override
	public ChapterDto toDto(Chapters chapter) {
		if (chapter == null) {
			return null;
		}
		ChapterDto chapterDto = new ChapterDto();
		chapterDto.setChaptId(chapterDto.getChaptId());
		chapterDto.setMangaId(chapterDto.getMangaId());
		chapterDto.setChaptTitle(chapterDto.getChaptTitle());
		chapterDto.setChaptDescription(chapterDto.getChaptDescription());
		chapterDto.setChaptRating(chapterDto.getChaptRating());
		chapterDto.setImageUrl(chapterDto.getImageUrl());
		chapterDto.setCreatedAt(chapterDto.getCreatedAt());
		return chapterDto;
	}

}
