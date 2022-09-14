package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Manga;

@Repository
public interface MangaRepository extends JpaRepository<Manga, Long> {

	@Query(value = "SELECT m FROM Manga m WHERE m.id=:id")
	Manga getMangaDetail(Long id);

}
