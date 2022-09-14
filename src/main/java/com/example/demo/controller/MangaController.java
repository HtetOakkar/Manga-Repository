package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MangaDto;
import com.example.demo.dto.MangaMapper;
import com.example.demo.model.request.MangaRequest;
import com.example.demo.model.request.UpdateMangaRequest;
import com.example.demo.model.response.MangaResponse;
import com.example.demo.service.MangaService;

@RestController
@RequestMapping("/api")
public class MangaController {

	@Autowired
	private MangaService mangaService;

	@Autowired
	private MangaMapper mangaMapper;

	@PostMapping
	public MangaResponse addManga(@RequestBody MangaRequest request) {
		MangaDto mangaDto = mangaMapper.toDto(request);
		MangaDto saveMangaDto = mangaService.create(mangaDto);
		MangaResponse response = mangaMapper.toMangaResponse(saveMangaDto);
		return response;
	}

	@GetMapping
	public List<MangaResponse> getMangas() {
		List<MangaResponse> responses = new ArrayList<>();
		List<MangaDto> mangaDtos = mangaService.getMangas();
		for (MangaDto mangaDto : mangaDtos) {
			MangaResponse response = mangaMapper.toMangaResponse(mangaDto);
			responses.add(response);
		}
		return responses;
	}

	@GetMapping("/{id}")
	public MangaResponse getMangaDetail(@PathVariable Long id) {
		MangaDto mangaDto = mangaService.getMangaDetail(id);
		MangaResponse response = mangaMapper.toMangaResponse(mangaDto);
		return response;
	}

	@PutMapping("/{id}")
	public MangaResponse updateResponse(@PathVariable Long id, @RequestBody UpdateMangaRequest request) {
		MangaDto updateMangaDto = mangaService.updateManga(id, request);
		MangaResponse response = mangaMapper.toMangaResponse(updateMangaDto);
		return response;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteManga(@PathVariable Long id) {
		mangaService.deleteManga(id);
		return new ResponseEntity<>("SuccessFully Deleted", HttpStatus.OK);
	}
}
