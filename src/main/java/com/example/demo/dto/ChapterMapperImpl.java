package com.example.demo.dto;

import org.springframework.stereotype.Component;

import com.example.demo.model.Chapter;
import com.example.demo.model.request.ChapterRequest;
import com.example.demo.model.response.ChapterResponse;

@Component
public class ChapterMapperImpl implements ChapterMapper {

	@Override
	public ChapterDto toDto(ChapterRequest request) {
		ChapterDto chapterDto = new ChapterDto();
		chapterDto.setImageUrl(request.getImgUrl());
		return chapterDto;
	}

	@Override
	public ChapterResponse toChapterResponse(ChapterDto chapterDto) {
		ChapterResponse response = new ChapterResponse();
		response.setImgUrl(chapterDto.getImageUrl());
		response.setCreatedAt(chapterDto.getCreatedAt());
		return response;
	}

	@Override
	public Chapter toEntity(ChapterDto chapterDto) {
		Chapter chapter = new Chapter();
		chapter.setImgUrl(chapterDto.getImageUrl());
		chapter.setCreatedAt(chapterDto.getCreatedAt());
		return chapter;
	}

	@Override
	public ChapterDto toDto(Chapter chapter) {
		if (chapter == null) {
			return null;
		}
		ChapterDto chapterDto = new ChapterDto();
		chapterDto.setImageUrl(chapterDto.getImageUrl());
		chapterDto.setCreatedAt(chapterDto.getCreatedAt());
		return chapterDto;
	}

}
