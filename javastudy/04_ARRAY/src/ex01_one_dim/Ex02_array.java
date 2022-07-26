package ex01_one_dim;

public class Ex02_array {

	public static void main(String[] args) {
		// 배열의 초기화
		// int[] arr = new int[] {10, 20, 30, 40, 50}; 가능하다는 것만 알아두자
		int[] arr = {10, 20, 30, 40, 50}; // 보통은 이렇게 한다.
		
		// 최대/최소 
		int max = arr[0];
		int min = arr[0]; // min은 제일 큰 범위의 값을 줘야한다. 범위가 없다면 배열의 첫 번째 요소를 초기값으로 사용한다.
		
		for(int i=1; i<arr.length; i++) {
			if(max<arr[i]) {  // arr[0]과 arr[0]을 비교하는 것은 불필요하니까 int i의 값을 1로 바꿔줬다.
				max = arr[i];
			}
			if(min>arr[i]) {
				min = arr[i];
			}
		}
		
		System.out.println("최대 : " + max);
		System.out.println("최소 : " + min);

	}

}
