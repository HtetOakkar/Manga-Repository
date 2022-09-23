package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ChapterDto;
import com.example.demo.dto.ChapterMapper;
import com.example.demo.model.request.ChapterRequest;
import com.example.demo.model.response.ChapterResponse;
import com.example.demo.service.ChapterService;

@RestController
@RequestMapping("/api/chapters")
public class ChapterController {

	private ChapterService chapterService;

	private ChapterMapper chapterMapper;

	public ChapterController(ChapterService chapterService, ChapterMapper chapterMapper) {
		this.chapterService = chapterService;
		this.chapterMapper = chapterMapper;
	}

	@PostMapping
	public ChapterResponse addChapter(@RequestBody ChapterRequest request) {
		Long mangaId = request.getMangaId();
		ChapterDto chapterDto = chapterMapper.toDto(request);
		ChapterDto savedChapterDto = chapterService.create(chapterDto,mangaId);
		ChapterResponse response = chapterMapper.toChapterResponse(savedChapterDto);
		return response;
	}

//	@GetMapping
//	public List<ChapterResponse> getChapters() {
//		List<ChapterResponse> responses = new ArrayList<>();
//		List<ChapterDto> chapterDtos = chapterService.getChapters();
//		for (ChapterDto chapterDto : chapterDtos) {
//			ChapterResponse respone = chapterMapper.toChapterResponse(chapterDto);
//			responses.add(respone);
//		}
//		return responses;
//	}
//
//	@GetMapping("/{id}")
//	public ChapterResponse getChapterDetail(@PathVariable Long id) {
//		ChapterDto chapterDto = chapterService.getChapterDetail(id);
//		ChapterResponse response = chapterMapper.toChapterResponse(chapterDto);
//		return response;
//	}
//
//	@PutMapping("/{id}")
//	public ChapterResponse updateChpaters(@PathVariable Long id, @RequestBody UpdateChapterRequest request) {
//		ChapterDto chapterDto = chapterService.updateChapters(id, request);
//		ChapterResponse response = chapterMapper.toChapterResponse(chapterDto);
//		return response;
//	}
//
//	@DeleteMapping("/{id}")
//	public ResponseEntity<?> deleteChapters(@PathVariable Long id) {
//		chapterService.deleteChapters(id);
//		return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
//	}

}
