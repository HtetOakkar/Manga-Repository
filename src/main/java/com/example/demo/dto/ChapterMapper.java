package com.example.demo.dto;

import com.example.demo.model.Chapter;
import com.example.demo.model.request.ChapterRequest;
import com.example.demo.model.response.ChapterResponse;

public interface ChapterMapper {

	ChapterDto toDto(ChapterRequest request);

	ChapterResponse toChapterResponse(ChapterDto savedChapterDto);

	Chapter toEntity(ChapterDto chapterDto);

	ChapterDto toDto(Chapter savedChapter);
	
}
