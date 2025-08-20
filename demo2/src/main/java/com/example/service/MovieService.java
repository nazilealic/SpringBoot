package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.Movie;

public interface MovieService {

	List<Movie> getAllMovies();
	Optional<Movie> getMovieById(Long id);
	Movie addMovie(Movie movie);
	Movie upDateMovie(Long id, Movie movie);
	void deleteMovie(Long id);
}
