package com.gdu.movie.batch;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gdu.movie.domain.MovieDTO;
import com.gdu.movie.mapper.MovieMapper;

@EnableScheduling
@Component
public class MovieJob {

	@Autowired
	private MovieMapper movieMapper;
	
	@Scheduled(cron = "0 0/1 * * * *")
	public void execute() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", "GENRE");
		map.put("searchText", "코미디");
		List<MovieDTO> list = movieMapper.selectMoviesByQuery(map);
		
		File file = new File("코미디.txt");
		
		PrintWriter out = null;
		out = new PrintWriter(file);
		try {
			if(list.size() == 0) {
				throw new RuntimeException();
			}
			for(int i=0; i<list.size(); i++) {
				out.println("제목 : " + list.get(i).getTitle());
				out.println("장르 : " + list.get(i).getGenre());
				out.println("개요 : " + list.get(i).getDescription());
				out.println("평점 : " + list.get(i).getStar());
			}
		} catch(Exception e) {
			out.println("코미디 검색 결과가 없습니다.");
		} finally {
			try {
				if(out != null) {
					out.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		/*
		
		File file = new File("C:\\GDJ\\jspstudy\\BoardProject","top.txt");
		
		PrintWriter out = null;
		
		try {
			
			out = new PrintWriter(file);
			
			out.println("게시글번호 " + free.getFreeNo());
			out.println("작성자 " + free.getWriter());
			out.println("제목 " + free.getTitle());
			out.println("작성IP " + free.getIp());
			out.println("조회수 " + free.getHit());
			out.println("내용");
			out.println(free.getContent());
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(out != null) {
					out.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		*/
	}

}
