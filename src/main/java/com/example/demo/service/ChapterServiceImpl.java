package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ChapterDto;
import com.example.demo.dto.ChapterMapper;
import com.example.demo.model.Chapters;
import com.example.demo.model.request.UpdateChapterRequest;
import com.example.demo.repository.ChapterRepository;

@Service
public class ChapterServiceImpl implements ChapterService{
	
	@Autowired
	private ChapterRepository chapterRepository;
	
	@Autowired
	private ChapterMapper chapterMapper;

	@Override
	public ChapterDto create(ChapterDto chapterDto) {
		Chapters chapter = chapterMapper.toEntity(chapterDto);
		Chapters savedChapter = chapterRepository.save(chapter);
		ChapterDto chaptDto = chapterMapper.toDto(savedChapter);
		return chaptDto;
	}

	@Override
	public List<ChapterDto> getChapters() {
		List<Chapters> chapters = chapterRepository.findAll();
		List<ChapterDto> chapterDtos = new ArrayList<>();
		for (Chapters chapter : chapters) {
			ChapterDto chapterDto = chapterMapper.toDto(chapter);
			chapterDtos.add(chapterDto);
		}
		return chapterDtos;
	}

	@Override
	public ChapterDto getChapterDetail(Long id) {
		Chapters chpater = chapterRepository.getChapterDetail(id);
		ChapterDto chapterDto = chapterMapper.toDto(chpater);
		return chapterDto;
	}

	@Override
	public ChapterDto updateChapters(Long id, UpdateChapterRequest request) {
		Chapters chapter = chapterRepository.getChapterDetail(id);
		chapter.setChaptTitle(request.getChaptTitle());
		chapter.setChaptDescription(request.getChaptDescription());
		chapter.setChaptRating(request.getChaptRating());
		chapter.setImgUrl(request.getImgUrl());
		chapter.setMangaId(request.getMangaId());
		Chapters updateChapter = chapterRepository.save(chapter); 
		ChapterDto chapterDto = chapterMapper.toDto(updateChapter);
		return chapterDto;
	}

	@Override
	public void deleteChapters(Long id) {
		Chapters chapter = chapterRepository.getChapterDetail(id);
		chapterRepository.delete(chapter);
	}
	
	
}
