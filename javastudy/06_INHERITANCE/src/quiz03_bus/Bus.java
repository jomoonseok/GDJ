package quiz03_bus;

public class Bus {
	
	private Seat[] seats;  // 배열 선언
	private int limit;     // 버스 정원
	
	// Bus 생성자에서 배열 생성을 진행함
	public Bus(int cnt) {
		seats = new Seat[cnt]; // 배열 생성, new Bus(25)인 경우 Seat가 25개 생성됨 / null만 25개
		limit = cnt;
		for(int i=0; i<limit; i++) { // 배열에 null 값 대신 채워줌
			seats[i] = new Seat();
		}
	}
	
	// ride() 메소드
	public void ride(int seatNo, Person person) {
		// 존재하지 않는 시트번호
		if(seatNo <= 0 || seatNo > limit) {
			return; // ride() 메소드 종료
		} 
		// 시트에 사람이 없으면, 시트번호에 Person 저장하기
		Seat seat = seats[seatNo-1];
		Person p = seat.getPerson();
		if(p == null) {
			seat.setPerson(person);
		}
	}
	
	// info() 메소드
	public void info() {
		for(int i=0; i<limit; i++) { // limit는 seats 배열의 length와 같다.
			Seat seat = seats[i];
			Person person = seat.getPerson(); // Person person = seats[i].getPerson();
			if(person != null) { // if(seat.getPerson() != null), if(seats[i].getPerson())
				System.out.println((i+1) + "," + person.getName());
				// System.out.println( (i+1) + "," + seat.getPerson().getName() );
				// System.out.println( (i+1) + "," + seats[i].getPerson().hetName());
			} else {
				System.out.println((i+1) + ", 비어 있음");
			}
		}
	}
	

}
