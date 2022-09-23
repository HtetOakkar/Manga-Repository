package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ChapterDto;
import com.example.demo.dto.ChapterMapper;
import com.example.demo.model.Chapter;
import com.example.demo.model.Manga;
import com.example.demo.repository.ChapterRepository;
import com.example.demo.repository.MangaRepository;

@Service
public class ChapterServiceImpl implements ChapterService {

	@Autowired
	private ChapterRepository chapterRepository;

	@Autowired
	private ChapterMapper chapterMapper;

	@Autowired
	private MangaRepository mangaRepository;

	@Override
	public ChapterDto create(ChapterDto chapterDto, Long mangaId) {
		Chapter chapter = chapterMapper.toEntity(chapterDto);
		Manga manga = mangaRepository.getMangaDetail(mangaId);
		System.out.println(manga);
		chapter.setManga(manga);
		Chapter savedChapter = chapterRepository.save(chapter);
		ChapterDto chaptDto = chapterMapper.toDto(savedChapter);
		return chaptDto;
	}

//	@Override
//	public List<ChapterDto> getChapters() {
//		List<Chapter> chapters = chapterRepository.findAll();
//		List<ChapterDto> chapterDtos = new ArrayList<>();
//		for (Chapter chapter : chapters) {
//			ChapterDto chapterDto = chapterMapper.toDto(chapter);
//			chapterDtos.add(chapterDto);
//		}
//		return chapterDtos;
//	}

//	@Override
//	public ChapterDto getChapterDetail(Long id) {
//		Chapter chpater = chapterRepository.getChapterDetail(id);
//		ChapterDto chapterDto = chapterMapper.toDto(chpater);
//		return chapterDto;
//	}

//	@Override
//	public ChapterDto updateChapters(Long id, UpdateChapterRequest request) {
//		Chapter chapter = chapterRepository.getChapterDetail(id);
//		chapter.setImgUrl(request.getImgUrl());
//		Chapter updateChapter = chapterRepository.save(chapter);
//		ChapterDto chapterDto = chapterMapper.toDto(updateChapter);
//		return chapterDto;
//	}

//	@Override
//	public void deleteChapters(Long id) {
//		Chapter chapter = chapterRepository.getChapterDetail(id);
//		chapterRepository.delete(chapter);
//	}

}
