package com.example.mapping.example.onetoone;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibraryRepository extends JpaRepository<Library, Long> {
    List<LibraryRepository> findTop10ByOrderByIdDesc();
}

