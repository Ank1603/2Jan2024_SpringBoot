package com.movieflix.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieflix.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

}
