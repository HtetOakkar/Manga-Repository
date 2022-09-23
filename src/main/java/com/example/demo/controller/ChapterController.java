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

import com.example.demo.dto.ChapterDto;
import com.example.demo.dto.ChapterMapper;
import com.example.demo.model.request.ChapterRequest;
import com.example.demo.model.request.UpdateChapterRequest;
import com.example.demo.model.response.ChapterResponse;
import com.example.demo.service.ChapterService;

@RestController
@RequestMapping("/apiChapters")
public class ChapterController {

	@Autowired
	private ChapterService chapterService;

	@Autowired
	private ChapterMapper chapterMapper;
	
	@PostMapping
	public ChapterResponse addChapter(@RequestBody ChapterRequest request) {
		ChapterDto chapterDto = chapterMapper.toDto(request);
		ChapterDto savedChapterDto = chapterService.create(chapterDto);
		ChapterResponse response = chapterMapper.toChapterResponse(savedChapterDto);	
		return response;
	}
	
	@GetMapping
	public List<ChapterResponse> getChapters() {
		List<ChapterResponse> responses = new ArrayList<>();
		List<ChapterDto> chapterDtos = chapterService.getChapters();
		for (ChapterDto chapterDto: chapterDtos) {
			ChapterResponse respone = chapterMapper.toChapterResponse(chapterDto);
			responses.add(respone);
		}
		return responses;
	}
	
	
	@GetMapping("/{id}")
	public ChapterResponse getChapterDetail(@PathVariable Long id) {
		ChapterDto chapterDto = chapterService.getChapterDetail(id);
		ChapterResponse response = chapterMapper.toChapterResponse(chapterDto);
		return response;
	}
	
	@PutMapping("/{id}")
	public ChapterResponse updateChpaters(@PathVariable Long id, @RequestBody UpdateChapterRequest request) {
		ChapterDto chapterDto = chapterService.updateChapters(id, request);
		ChapterResponse response = chapterMapper.toChapterResponse(chapterDto);
		return response;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteChapters(@PathVariable Long id) {
		chapterService.deleteChapters(id);
		return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
	}
	
}
