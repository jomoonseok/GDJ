package ex02_try_catch;

import java.io.File;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static void m1() {
		try {
			String[] hobbies = new String[3];
			hobbies[1] = "swimming";
			hobbies[2] = "running";
			for(String hobby : hobbies) { // Null이 있다고 무조건  NullPointerException이 발생하는 것은 아니다.
			 // System.out.println(hobby); 잘 동작함
				System.out.println(hobby.substring(0,2)); //null 값이 메소드를 부를 때 NullPointerException 발생
			}
		} catch(Exception e) { // Exception대신 RuntimeException, NullPointerException 가능
			System.out.println("NullPointerException 발생");
		}
	}
	
	public static void m2() {
		try {
			String input = "20,21,,22,23,24,25";
			String[] inputs = input.split(",");
			int[] numbers = new int[inputs.length];
			for(int i=0; i<inputs.length; i++) {
				numbers[i] = Integer.parseInt(inputs[i]);
				System.out.println(numbers[i]);
			}
	    // catch가 여러개 나오면 순서대로 처리한다.
		// 다중 catch 블록 사용할 때는 자식을 먼저 배치하고 부모를 나중에 배치해야 한다.
		} catch(NumberFormatException e) { // NumberFormatException대신 RuntimeException, Exception 가능
			System.out.println("NumberFormatException 발생");
		} catch(Exception e) {
			System.out.println("Exception 발생");
		}
		
		// int[] ages = {20, 21, 22, 23, 24, 25};
	}
	
	public static void m3() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("정수1 >>> ");
			int a = sc.nextInt();
			System.out.print("정수2 >>> ");
			int b = sc.nextInt();
			System.out.println(a + " + " + b + " = " + (a + b) );
			System.out.println(a + " - " + b + " = " + (a - b) );
			System.out.println(a + " * " + b + " = " + (a * b) );
			System.out.println(a + " / " + b + " = " + (a / b) );
			System.out.println(a + " % " + b + " = " + (a % b) );
			sc.close();
		} catch(ArithmeticException e) {
			System.out.println("ArithmeticException 발생");
		} catch(InputMismatchException e) {
			System.out.println("InputMismatchException 발생");
		}
	}
	
	public static void m4() {
		
		try {
			File file = new File("C:\\sample.txt");
			FileReader fe = new FileReader(file); // try-catch문이 없으면 실행이 불가능한 Checked Exception
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		
		m4();

	}

}
