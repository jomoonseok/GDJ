package quiz02_updown;

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
		rand = (int) (Math.random() * 100) + 1;
		sc = new Scanner(System.in);

	}

	// 예외처리
	// 입력
	public int input() { // throws RuntimeException, InputMismatchException 생략 가능
		count++;
		System.out.print("입력 >>> ");
		int num = sc.nextInt();
		if (num < 1 || num > 100) {
			throw new RuntimeException("1 ~ 100 사이 정수만 입력할 수 있습니다.");
		}
		return num;
	}

	// 실행
	public void play() {

		// 맞힐때까지 무한루프
		while (true) {
			try {
				int n = input(); // num, RuntimeException, InputMismatchException 셋 중에 하나가 올 수 있다.
				if (rand == n) {
					System.out.println(count + "번만에 정답!");
					return;
				} else {
					if (rand > n) {
						System.out.println("Up!");
					} else {
						System.out.println("Down!");
					}
				}
			} catch (InputMismatchException e) {
				sc.next();
				System.out.println("정수만 입력할 수 있습니다.");
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		} // while
	}
}
