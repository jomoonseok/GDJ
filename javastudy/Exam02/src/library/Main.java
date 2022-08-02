package library;

public class Main {

	public static void main(String[] args) {
		/*
		Book, Library, Main
		책(번호, 제목)
		도서관(책배열)
		 -책추가
		 -책제거 / 배열의 중간 제거하고 순서를 땡겨줘야 한다.
		 -책검색
		 -전체조회
		Scanner 클래스
		*/
		
		Library library = new Library(); 
		library.manage();
		
		// new Library().manage();  객체이름을 안 주고 바로 사용

	}

}
