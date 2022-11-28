package com.gdu.movie.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gdu.movie.domain.EntityDTO;
import com.gdu.movie.mapper.MovieMapper;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper movieMapper;
	
	@Override
	public ResponseEntity<Object> getMovieList() {
		try {
			EntityDTO entity = new EntityDTO();
			entity.setMovies(movieMapper.selectAllMovies());
			int movieCnt = movieMapper.selectAllMoviesCount();
			entity.setMessage("전체 " + movieCnt + "개의 목록을 가져왔습니다.");
					
			return new ResponseEntity<Object>(entity, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Object>("목록 가져오기에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@Override
	public ResponseEntity<Object> getMovie(String column, String searchText) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("column", column);
			map.put("searchText", searchText);
			EntityDTO entity = new EntityDTO();
			entity.setMovies(movieMapper.selectMoviesByQuery(map));
			if(entity.getMovies().size() == 0) {
				throw new RuntimeException();
			}
			entity.setMessage(entity.getMovies().size() + "개의 검색결과가 있습니다.");
			return new ResponseEntity<Object>(entity, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Object>(searchText + " 검색결과가 없습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
