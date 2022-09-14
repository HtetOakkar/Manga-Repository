package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MangaDto;
import com.example.demo.dto.MangaMapper;
import com.example.demo.model.Manga;
import com.example.demo.model.request.UpdateMangaRequest;
import com.example.demo.repository.MangaRepository;

@Service
public class MangaServiceImpl implements MangaService {

	@Autowired
	private MangaRepository mangaRepositoy;

	@Autowired
	private MangaMapper mangaMapper;

	@Override
	public MangaDto create(MangaDto mangaDto) {
		Manga manga = mangaMapper.toEntity(mangaDto);
		Manga savedManga = mangaRepositoy.save(manga);
		MangaDto mgaDto = mangaMapper.toDto(savedManga);
		return mgaDto;
	}

	@Override
	public List<MangaDto> getMangas() {
		List<Manga> mangas = mangaRepositoy.findAll();
		List<MangaDto> mangaDtos = new ArrayList<>();
		for (Manga manga : mangas) {
			MangaDto mangaDto = mangaMapper.toDto(manga);
			mangaDtos.add(mangaDto);
		}
		return mangaDtos;
	}

	@Override
	public MangaDto getMangaDetail(Long id) {
		Manga manga = mangaRepositoy.getMangaDetail(id);
		MangaDto mangaDto = mangaMapper.toDto(manga);
		return mangaDto;
	}

	@Override
	public MangaDto updateManga(Long id, UpdateMangaRequest request) {
		Manga manga = mangaRepositoy.getMangaDetail(id);
		manga.setDescription(request.getDescription());
		manga.setImageUrl(request.getImageUrl());
		manga.setTitle(request.getTitle());
		manga.setRating(request.getRating());
		Manga updateManga = mangaRepositoy.save(manga);
		MangaDto mangaDto = mangaMapper.toDto(updateManga);
		return mangaDto;
	}

	@Override
	public void deleteManga(Long id) {
		Manga manga = mangaRepositoy.getMangaDetail(id);
		mangaRepositoy.delete(manga);
	}
}
