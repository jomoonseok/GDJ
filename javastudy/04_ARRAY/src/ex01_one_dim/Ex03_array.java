package ex01_one_dim;

import java.util.Arrays;

public class Ex03_array {

	public static void main(String[] args) {
		// 배열의 데이터타입
		// int[] : 참조 타입(Reference Type)
		
		// 배열의 길이 늘리기
		// 1. 배열의 길이는 변경할 수 없다.
		// 2. 늘어난 길이의 새로운 배열을 만들고, 
		//    기존 배열의 값을 모두 새로운 배열로 옮기고,
		//    기존 배열의 참조값을 새로운 배열의 참조값으로 수정한다.
		//    기존에 참조 하던 배열은 더이상 찾지 않아서 메모리 누수가 생기는데 java는 스스로 해결한다.
		
		// 길이가 5인 배열을 사용하다가
		// 길이가 1000인 배열로 바꾸기
		
		int[] arr = {1, 2, 3, 4, 5};
		
		int[] temp = new int[1000]; // 늘어난 길이의 새로운 배열을 만들고,
		//     기존 배열 <┐     ┌> 새 배열  ┌> 횟수
		System.arraycopy(arr, 0, temp, 0, arr.length); // 기존 배열의 값을 모두 새로운 배열로 옮기고,
		//기존 배열의 인덱스 <┘       └> 새 배열의 인덱스
		// for문을 이용할 수도 있다.
		
		arr = temp; // 기존 배열의 참조값을 새로운 배열의 참조값으로 수정한다.
		
		// 이제 arr 배열의 길이가 1000이다.
		System.out.println(arr.length);
		System.out.println(Arrays.toString(arr)); // Arrays.toString(); 배열의 요소를 보여주는 API
		
		

	}

}
