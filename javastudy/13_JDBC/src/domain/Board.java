package domain;

import oracle.sql.DATE;

// 게시판 1개의 정보를 담을 수 있는 객체를 생성하는 클래스
// Bean, VO, DTO 등으로 불림
// 테이블의 칼럼을 1:1로 변수로 매칭(가급적 칼럼이름 = 변수이름)
// 생성자, Getter/Setter

public class Board {
	
	private int board_no; // 밑줄(_)은 원래 java 이름규칙에서 쓰이지 않지만 DB와 맞추기위해 사용
	private String title;
	private String content;
	private int hit;
	private DATE create_date;
	
	public Board() {
		
	}

	public Board(int board_no, String title, String content, int hit, DATE create_date) {
		super();
		this.board_no = board_no;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.create_date = create_date;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public DATE getCreate_date() {
		return create_date;
	}

	public void setCreate_date(DATE create_date) {
		this.create_date = create_date;
	}
	
}
