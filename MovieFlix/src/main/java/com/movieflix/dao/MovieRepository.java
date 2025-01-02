package com.movieflix.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieflix.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
