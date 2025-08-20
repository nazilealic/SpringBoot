package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.entity.Movie;
import com.example.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{
//dependency of injection
    private final MovieRepository movieRepository;

    MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Optional<Movie> getMovieById(Long id) {
		return movieRepository.findById(id);
	}

	@Override
	public Movie addMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public Movie upDateMovie(Long id, Movie movie) {
		movie.setId(id);
		return movieRepository.save(movie);
	}

	@Override
	public void deleteMovie(Long id) {
		movieRepository.deleteById(id);
		
	}

}
