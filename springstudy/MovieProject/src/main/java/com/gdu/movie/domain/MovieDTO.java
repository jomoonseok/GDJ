package com.gdu.movie.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieDTO {
	private int no;
	private String title;
	private String genre;
	private String description;
	private double star;
}
