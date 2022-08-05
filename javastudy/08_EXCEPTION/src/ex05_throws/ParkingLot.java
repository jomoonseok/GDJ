package ex05_throws;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ParkingLot {
	
	private Car[] cars;
	private int idx;
	private Scanner sc;
	
	public ParkingLot() {
		cars = new Car[10];
		sc = new Scanner(System.in);
	}
	
	public void addCar() throws RuntimeException { // manage로 예외를 보낸다.
		
		if(idx == cars.length) {
		throw new RuntimeException("Full");
		}
		
	}
	
	public void deleteCar() throws RuntimeException { // manage로 예외를 보낸다.
		
		if(idx == 0) {
			throw new RuntimeException("Empty");
		}
		
	}
	
	public void findCar() throws RuntimeException { // manage로 예외를 보낸다.
		
		if(idx == 0) {
			throw new RuntimeException("Empty");
		}
		
	}
	
	public void printAllCars() throws RuntimeException { // manage로 예외를 보낸다.
		
		if(idx == 0) {
			throw new RuntimeException("Empty");
		}
		
	}
	
	public void manage() {
		while(true) {
			try {
				System.out.print("1.추가 2.삭제 3.조회 4.전체목록 0.종료 >>> ");
				int choice = sc.nextInt();
				switch(choice) {
				case 1 : addCar(); break;
				case 2 : deleteCar(); break;
				case 3 : findCar(); break;
				case 4 : printAllCars(); break;
				case 0 : return;
				default: throw new RuntimeException("Bad Request");
				}
			} catch(InputMismatchException e) {
				sc.next(); // int choice = sc.nextInt();에서 잘못 입력된 걸 처리해주는 코드 
				           // 처리해주지 않으면 계속 남아있어서 무한루프 된다. / 
				           // 일번이라고 입력시 sc.next()로 처리해주지 않으면 무한루프 된다.
				System.out.println("처리 명령은 정수(1~4,0)입니다.");
			} catch(RuntimeException e) {
				System.out.println(e.getMessage());
				// manage();
			}
		}
	}
	
	public static void main(String[] args) {
		new ParkingLot().manage();
	}

}
