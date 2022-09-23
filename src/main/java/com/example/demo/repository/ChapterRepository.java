package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Chapters;

@Repository
public interface ChapterRepository extends JpaRepository<Chapters, Long>{
	
	@Query(value = "SELECT c FROM Chapters c WHERE c.id=:id")
	Chapters getChapterDetail(Long id);
}
