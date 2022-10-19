package domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Board {
	private int boardNo; // 프레임워크가 도와줘서 DB와 이름을 맞출 필요없음
	private String title;
	private String content;
	private Date createDate;
}
