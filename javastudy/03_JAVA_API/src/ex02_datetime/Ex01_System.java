package ex02_datetime;

public class Ex01_System {

	public static void main(String[] args) {
		// 1. 타임스탬프(time stamp)
		// 1970-01-01 0:00부터 1/1000초마다 증가하는 long 타입의 정수값
		// 파일이름으로 사용하기도 한다. 또는 경과 시간 측정할 때
		// 계산하면 현재 시간이 나온다.
		
		long timestamp = System.currentTimeMillis(); // 계속 달라지기 때문에 파일명으로 사용하기도 한다. 
		System.out.println(timestamp);
		
		// 2. 나노타임(nanoTime)
		// s > ㎳(천분의 1초) > ㎲(백만분의 1초) > ㎱(십억분의 1초) > ㎰
		// 나노초(㎱) 값을 가지는 long 타입의 정수값
		// 어떤 기준일자는 없어서 두 개의 나노초(㎱) 사이의 경과시간 계산용
		
		long beginTime = System.nanoTime();
		int total = 1 + 2 + 3 + 4 + 5;
		long endTime = System.nanoTime();
		System.out.println(total + " 계산에 걸린 시간 : " + (endTime - beginTime) + "㎱");
		System.out.println(beginTime +"\n"+ endTime);
		
		
		// System.currentTimeMillis(); 얘가 중요

	}

}
