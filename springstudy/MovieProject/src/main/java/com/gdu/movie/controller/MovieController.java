package com.gdu.movie.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.movie.service.MovieService;
import com.gdu.movie.util.SecurityUtil;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private SecurityUtil securityUtil;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@ResponseBody
	@GetMapping(value="/movie/searchAllMovies", produces="application/json; charset=UTF-8")
	public ResponseEntity<Object> searchAllMovies() {
		return movieService.getMovieList();
	}

	
	
	

	@ResponseBody
	@GetMapping(value="/movie/searchMovie", produces="application/json; charset=UTF-8")
	public ResponseEntity<Object> searchMovie(HttpServletRequest request) {
			String column = securityUtil.preventXSS(request.getParameter("column"));
			String searchText = securityUtil.preventXSS(request.getParameter("searchText"));
			return movieService.getMovie(column, searchText);
		}
	
	

}
