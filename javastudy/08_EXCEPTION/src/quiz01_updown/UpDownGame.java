package quiz01_updown;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpDownGame {
	
	// 필드
	private int rand; // 1 ~ 100 사이 난수
	private int count; // 시도 횟수
	private Scanner sc;
	
	// 생성자
	public UpDownGame() {
		// rand, sc 만들기
		rand = (int)(Math.random() * 100) + 1;
		sc = new Scanner(System.in);
		
	}
	
	// 입력
	public int input() {
		try {
			count++;
			System.out.print("입력 >>> ");
			int num = sc.nextInt();
			if(num < 1 || num > 100) {
				throw new RuntimeException("1 ~ 100 사이 정수만 입력할 수 있습니다.");
			}
			return num;
		} catch (InputMismatchException e) {
			System.out.println("정수만 입력할 수 있습니다.");
			sc.nextLine(); // 잘못 입력된 문자열 먹어 치우기
			input(); // 자기 자신을 부르는 것 / 재귀호출
		} catch (Exception e) {
			System.out.println(e.getMessage());
			input();
		}
		return 0; //실행될 일은 없지만 이클립스 안심시키는 용도
	}
	
	// 실행
	public void play() {
		
		// 맞힐때까지 무한루프
		while(true) {
			int n = input();
			if(rand == n) {
				System.out.println(count + "번만에 정답!");
				return;
			} else {
				if(rand > n) {
					System.out.println("Up!");
				} else {
					System.out.println("Down!");
				}
			}
			
		} // while
		
	}

}
