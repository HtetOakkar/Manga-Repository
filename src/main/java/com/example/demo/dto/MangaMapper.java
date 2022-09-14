package com.example.demo.dto;

import com.example.demo.model.Manga;
import com.example.demo.model.request.MangaRequest;
import com.example.demo.model.response.MangaResponse;

public interface MangaMapper {

	MangaDto toDto(MangaRequest request);

	Manga toEntity(MangaDto mangaDto);

	MangaDto toDto(Manga savedManga);

	MangaResponse toMangaResponse(MangaDto saveMangaDto);

}
