package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Chapter;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Long> {

//	@Query(value = "SELECT c FROM Chapters c WHERE c.id=:id")
//	Chapter getChapterDetail(Long id);
}
