package ex02_loop;

public class Ex04_continue {

	public static void main(String[] args) {
		// continue문
		// 반복문의 시작 지점으로 이동한다.
		// if문과 같이 사용
		// 실행에서 제외할 코드가 있는 경우에 사용한다.
		// 대체품이 있어서 많이 사용하지 않는다.
		// 없어도 된다.
		
		
		
		// 1 ~ 100사이 중에서 3의배수를 제외하고 모두 더하기
		
		int i = 0;
		int sum = 0;
		while(i < 100) {
			
			i++;
			
			if(i % 3 == 0) {
				continue;
			}
			
			sum += i;
		}
		System.out.println(sum);
		
		// 연습
		// 1 ~ 100사이 중에서 3의배수를 제외하고 모두 더하기 continue 없이 만들어보기
		
	}

}
