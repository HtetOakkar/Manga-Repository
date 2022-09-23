package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ChapterDto;
import com.example.demo.model.request.UpdateChapterRequest;

public interface ChapterService {

	ChapterDto create(ChapterDto chapterDto);

	List<ChapterDto> getChapters();

	ChapterDto getChapterDetail(Long id);

	ChapterDto updateChapters(Long id, UpdateChapterRequest request);

	void deleteChapters(Long id);

	

}
