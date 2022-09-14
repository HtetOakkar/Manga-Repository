package com.example.demo.dto;

import org.springframework.stereotype.Component;

import com.example.demo.model.Manga;
import com.example.demo.model.request.MangaRequest;
import com.example.demo.model.response.MangaResponse;

@Component
public class MangaMapperImpl implements MangaMapper {

	@Override
	public MangaDto toDto(MangaRequest request) {
		MangaDto mangaDto = new MangaDto();
		mangaDto.setTitle(request.getTitle());
		mangaDto.setDescription(request.getDescription());
		mangaDto.setImageUrl(request.getImageUrl());
		mangaDto.setRating(request.getRating());
		return mangaDto;
	}

	@Override
	public Manga toEntity(MangaDto mangaDto) {
		Manga manga = new Manga();
		manga.setId(mangaDto.getId());
		manga.setTitle(mangaDto.getTitle());
		manga.setDescription(mangaDto.getDescription());
		manga.setImageUrl(mangaDto.getImageUrl());
		manga.setRating(mangaDto.getRating());
		manga.setCreatedAt(mangaDto.getCreatedAt());
		return manga;
	}

	@Override
	public MangaDto toDto(Manga manga) {
		if (manga == null) {
			return null;
		}
		MangaDto mangaDto = new MangaDto();
		mangaDto.setId(manga.getId());
		mangaDto.setTitle(manga.getTitle());
		mangaDto.setDescription(manga.getDescription());
		mangaDto.setImageUrl(manga.getImageUrl());
		mangaDto.setRating(manga.getRating());
		mangaDto.setCreatedAt(manga.getCreatedAt());
		return mangaDto;
	}

	@Override
	public MangaResponse toMangaResponse(MangaDto manga) {
		MangaResponse response = new MangaResponse();
		response.setId(manga.getId());
		response.setTitle(manga.getTitle());
		response.setDescription(manga.getDescription());
		response.setImageUrl(manga.getImageUrl());
		response.setRating(manga.getRating());
		response.setCreatedAt(manga.getCreatedAt());
		return response;
	}

}
