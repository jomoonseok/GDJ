package domain;

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
public class Student {
	private int stuNo; // 프레임워크가 도와줘서 DB와 이름을 맞출 필요없음
	private String name;
	private int kor, eng, math;
	private double ave;
	private String grade;
}
