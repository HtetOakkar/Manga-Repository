package com.example.demo.dto;

import com.example.demo.model.Chapters;
import com.example.demo.model.request.ChapterRequest;
import com.example.demo.model.response.ChapterResponse;

public interface ChapterMapper {

	ChapterDto toDto(ChapterRequest request);

	ChapterResponse toChapterResponse(ChapterDto savedChapterDto);

	Chapters toEntity(ChapterDto chapterDto);

	ChapterDto toDto(Chapters savedChapter);
	
}
