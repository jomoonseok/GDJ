package com.gdu.movie.service;

import org.springframework.http.ResponseEntity;

public interface MovieService {
	public ResponseEntity<Object> getMovieList();
	public ResponseEntity<Object> getMovie(String column, String searchText);
}
