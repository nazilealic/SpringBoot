package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Movie;
import com.example.repository.MovieRepository;

@RestController
@RequestMapping("/movies")
public class MovieController {

	private final MovieRepository movieRepository;

	public MovieController(MovieRepository movieRepository) {
	    this.movieRepository = movieRepository;
	}
	
	@GetMapping("/")
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Movie> getAllMovieById(@PathVariable Long id){
		return movieRepository.findById(id);
	}
	@PostMapping
	public Movie addMovie(@RequestBody Movie movie) {
		return movieRepository.save(movie);
	}
	
	@PutMapping("/{id}")
	public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
		movie.setId(id);
		return movieRepository.save(movie);
	}
	
	@DeleteMapping("/{id}")
	private void deleteMovie(@PathVariable Long id) {
		movieRepository.deleteById(id);
	}
	
}
