package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MangaDto;
import com.example.demo.model.request.UpdateMangaRequest;

public interface MangaService {

	MangaDto create(MangaDto mangaDto);

	List<MangaDto> getMangas();

	MangaDto getMangaDetail(Long id);

	MangaDto updateManga(Long id, UpdateMangaRequest request);

	void deleteManga(Long id);

}
