package prac1;

import java.util.Scanner;

public class prac1 {

	public static void main(String[] args) {
		/*
		1.점수와학년을입력받아60점이상이면합격,60점미만이면불합격을출력하시오.
		4학년인경우70점이상이어야합격이다.
		점수를입력하세요(0~100)>>>65
		학년을입력하세요(1~4)>>>1
		합격!
		점수를입력하세요(0~100)>>>65
		학년을입력하세요(1~4)>>>4
		불합격!
		*/
		
		Scanner sc = new Scanner(System.in);
		/*
		System.out.print("점수를 입력하세요(0~100) >>> ");
		int s = sc.nextInt();
		System.out.print("학년을 입력하세요(1~4) >>> ");
		int y = sc.nextInt();
		
		if(y == 4) {
			if(s >= 70) {
				System.out.println("합격!");
			} else {
				System.out.println("불합격!");
			} 
		} else if(s >= 60) {
			System.out.println("합격!");
		} else {
			System.out.println("불합격!");
		}
		*/
		
		/*
		2.커피메뉴를 입력받아가격을 알려주는 프로그램을 구현하시오. switch문을이용하여구현하시오.
		(에스프레소,카푸치노,카페라떼는3500원,아메리카노는2000원이다.)
		무슨커피드릴까요?>>> 에스프레소 
		에스프레소는 3500원입니다.
		무슨커피드릴까요?>>>아메리카노 
		아메리카노는 2000원입니다.
		무슨커피드릴까요?>>>밀크커피 
		밀크커피는 메뉴에없습니다.
		*/
		/*
		System.out.println("무슨 커피 드릴까요? >>> ");
		String c = sc.next();
		switch(c) {
		case "에스프레소" : 
		case "카푸치노" : 
		case "카페라떼" : System.out.println(c + "는 3500원 입니다.");  break;
		case "아메리카노" : System.out.println(c + "는 2000원 입니다."); break;
		default : System.out.println(c + "는 메뉴에 없습니다.");
		}
		*/
		
		/*
		3.돈을입력받아 오만원권,만원권,오천원권,천원권,오백원동전,백원동전,오십원동전,십원동전,오원동전,일원동전이 각각 몇 개로 변환되는지 출력하시오.
		이때 반드시 다음과 같은 배열을 사용하여 반복문으로 처리하시오.
		int[]unit={50000,10000,5000,1000,500,100,50,10,5,1};
		금액을입력하시오>>75832
		50000원짜리:1개
		10000원짜리:2개
		5000원짜리:1개
		500원짜리:1개
		100원짜리:3개
		10원짜리:3개
		1원짜리:2개
		*/
		/*
		System.out.print("금액을 입력하시오 >> ");
		int m = sc.nextInt();
		int[] unit = {50000,10000,5000,1000,500,100,50,10,5,1};
		
		for (int u : unit) {
			if(m/u != 0) {
				System.out.println(u + "원짜리 : " + (m/u) + "개");
				m -= u * (m/u);
			}
		}
		*/
		
		/*
		4.정수를 몇개 저장할지(최대100개) 입력받아서 해당길이를 가진배열을생성하고,이곳에1에서100사이범위의정수를랜덤하게삽입하시오.
		같은값은생성하지못하도록설정하고생성된배열을출력하시오.
		몇개의랜덤을생성할까요?>>>150
		다음에는1~100사이로입력하세요!
		몇개의랜덤을생성할까요?>>>25
		29 64 47 14 37 61 83 33 65 96
		48 44 92 77 70 34 23 35 13 68
		74 15 67 42 38
		*/
		/*
		System.out.print("몇개의 랜덤을 생성할까요? >>> ");
		int r = sc.nextInt();
		int[] arr;
		if(r > 100 || r < 1) {
			System.out.println("다음에는 1~100 사이로 입력하세요");
			System.out.print("몇개의 랜덤을 생성할까요? >>> ");
			r = sc.nextInt();
			arr = new int[r];
		} else {
			arr = new int[r];
			
		}
		
		for(int i=0; i<arr.length; i++) {
			int random = (int)(Math.random() * 100) + 1;
			if(exists(arr, i, random)) {
				i--;
				continue;
			}
			arr[i] = random;
			
			if(i % 9 == 0) {
				System.out.println();
			} else {
				System.out.print(arr[i] + " ");
			}
		}
		*/
		/*
		System.out.println("몇 개 생성할까요? >>> ");
		int count = sc.nextInt();
		
		if(count < 1 || count > 100) {
			System.out.println("1~100 사이만 가능합니다.");
			return;
		}
		
		int[] arr = new int[count];
		
		// 배열 arr에 난수(1~100) 저장
		// 중복 생성되면 재생성
		for(int i = 0; i < arr.length; i++) {
			int random = (int)(Math.random() * 100) + 1;
			// random 검사 메소드
			// 중복이 있으면 true 반환, 중복이 없으면 false 반환
			// exists(배열arr, 인덱스, 난수)
			if(exists(arr, i, random)) {
				i--;
				continue;
			}
			arr[i] = random;
		}
		
		// 배열 arr의 출력
		// 한 줄에 10개씩
		
		for(int i = 0; i < arr.length; i++) {
			if(i != 0 && i % 10 == 0)
				System.out.println();
			System.out.print(arr[i] + "\t");
		}
		*/
		
		/*
		5.3명의학생의점수를입력받아서평균점수와1등의이름과꼴등의이름을
		출력하시오.
		피카츄의점수입력>>>75
		뽀로로의점수입력>>>95
		브레드의점수입력>>>85
		평균:85.0점
		1등:뽀로로
		3등:피카츄
		*/
		/*
		String[] name = {"피카츄", "뽀로로", "브레드"};
		int[] score = new int[name.length];
		
		int total = 0;
		int max = 0;
		int min = 100;
		String best = "";
		String worst = "";
		
		for(int i=0; i<name.length; i++) {
			System.out.print(name[i] + "의 점수입력 >>> ");
			score[i] = sc.nextInt();
			total += score[i];
			if(max<score[i]) {
				max = score[i];
				best = name[i];
			}
			if(min > score[i]) {
				min = score[i];
				worst = name[i];
			}
		}
		double avg = (double)total / score.length;
		System.out.println("평균 : " + avg);
		System.out.println("1등 : " + best);
		System.out.println("3등 : " + worst);
		*/
		
		/*
		6.랜덤으로윷놀이를구현하시오.도개걸윷모중랜덤생성하여이동횟수와함께
		화면에출력하시오.윷이나모가나오면계속랜덤생성하여총이동횟수를
		계산하여출력하시오. 도:1칸이동
		개:2칸이동
		걸:3칸이동
		윷:4칸이동
		모:5칸이동
		예시1)
		개,2칸이동한다. 예시2)
		윷,걸,7칸이동한다.
		*/
		/*
		String[] a = {"", "도", "개", "걸", "윷", "모"};
		int b = (int)(Math.random()*5 +1);
		int sum = 0;
		int c = 0;
		
		if(b < 4) {
			System.out.println(a[b] + " : " + (b) + "칸 이동");
		} else {
			while(b >= 4) {
				System.out.print(a[b] + ",");
				c = b;
				b = (int)(Math.random()*5);
				sum += b + c;  
			}
			System.out.println(a[b] + " " + sum + "칸 이동한다.");
		}
		*/
		
		/*
		7.경과시간을맞추는게임을작성하시오.첫번째<Enter>를누르면해당시점의초
		시간을보여주고,두번째<Enter>를누르면해당시점의초시간을다시
		보여준다.여기서10초에근접하도록<Enter>를누른사람이이기는게임이다.
		<hint>
		1.<Enter>를누른다.:Scanner클래스의nextLine()메소드는<Enter>를인식함예)<Enter>를누르면1000이출력되는코드
		Scannersc=newScanner(System.in);
		sc.nextLine();
		System.out.println(1000);
		2.경과시간:System.currentTimeMillis()를이용해<Enter>를누른시간을2개
		구하고,그차이를구한뒤0.001을곱하면초단위로결과를확인할수있다. 강아지님시작하려면<Enter>를누르세요.
		===시작시간(초):10
		10초가된것같으면<Enter>를누르세요.
		===종료시간(초):17
		고양이님시작하려면<Enter>를누르세요.
		===시작시간(초):21
		10초가된것같으면<Enter>를누르세요.
		===종료시간(초):29
		강아지님결과7초,고양이님결과8초,승자는고양이님입니다.
		*/
		/*
		sc.nextLine();
		System.out.println("시작");
		long start = System.currentTimeMillis();
		sc.nextLine();
		long end = System.currentTimeMillis();
		System.out.println("정지");
		
		System.out.println("시작 시간(초) : " + (start));
		System.out.println("정지 시간(초) : " + (end));
		
		int result1 = (int)((end - start)*0.001);
		
		sc.nextLine();
		System.out.println("시작");
		start = System.currentTimeMillis();
		sc.nextLine();
		end = System.currentTimeMillis();
		System.out.println("정지");
		
		System.out.println("시작 시간(초) : " + (start));
		System.out.println("정지 시간(초) : " + (end));
		
		int result2 = (int)((end - start)*0.001);
		
		String a = (result1 > result2) ? "강아지님" : "고양이님";
		
		System.out.println("강아지님 결과 " + result1 + "초, " + "고양이님 결과 " + result2 + "초, 승자는" + a + "입니다.");
		*/
		
		/*
		8.다음main메소드를참고하여Watch클래스를구현하시오.
		public static void main(String[]args){
		Watch watch =new Watch(16,15,30);
		watch.addHour(25); //25시간후(1시간)
		watch.addMinute(61); //61분후(1시간1분)
		watch.addSecond(3661); //3661초후(1시간1분1초)
		watch.see();//19시17분31초
		}
		19시17분31초
		*/
		/*
		Watch watch =new Watch(16,15,30);
		watch.addHour(25); //25시간후(1시간)
		watch.addMinute(61); //61분후(1시간1분)
		watch.addSecond(3661); //3661초후(1시간1분1초)
		watch.see();//19시17분31초
		*/
		
		/*
		9.다음main메소드를참고하여BankAccount클래스를구현하시오.
		public static void main(String[]args){
		BankAccount me=new BankAccount("1234",10000);
		BankAccount mom =new BankAccount("4321",100000);
		me.deposit(10000);//내계좌에10000원입금
		me.deposit(-100);//내계좌에마이너스입금(불가)
		me.withdraw(5000);//내계좌에서5000원출금
		me.withdraw(100);//내계좌에서잔액보다큰금액출금(불가)
		me.inquiry();//계좌번호:1234,잔액:15000원
		mom.transfer(me,50000);//엄마가나에게50000원이체
		mom.transfer(me,-100);//실패
		mom.transfer(me,100000000);//실패
		mom.inquiry();//계좌번호:4321,잔액:50000원
		me.inquiry();//계좌번호:1234,잔액:64900원
		}
		계좌번호:1234,잔액:14900원
		계좌번호:4321,잔액:50000원
		계좌번호:1234,잔액:64900원
		*/
		/*
		BankAccount me=new BankAccount("1234",10000);
		BankAccount mom =new BankAccount("4321",100000);
		me.deposit(10000);//내계좌에10000원입금
		me.deposit(-100);//내계좌에마이너스입금(불가)
		me.withdraw(5000);//내계좌에서5000원출금
		me.withdraw(100);//내계좌에서잔액보다큰금액출금(불가)
		me.inquiry();//계좌번호:1234,잔액:15000원
		mom.transfer(me,50000);//엄마가나에게50000원이체
		mom.transfer(me,-100);//실패
		mom.transfer(me,100000000);//실패
		mom.inquiry();//계좌번호:4321,잔액:50000원
		me.inquiry();//계좌번호:1234,잔액:64900원
		*/
		
		/*
		10.다음main메소드를참고하여Gun클래스와Soldier클래스를구현하시오.
		public static void main(String[]args){
		Gun gun =new Gun("K2",2);//모델명,총알수
		Soldier soldier =new Soldier("람보",gun);//군인명,총
		soldier.shoot();//빵야!1발남았다.
		soldier.shoot();//빵야!0발남았다.
		soldier.shoot();//헛빵!
		soldier.reload(3);//3발이장전되었다.현재3발.
		soldier.reload(6);//3발이장전되었다.현재6발.
		soldier.reload(6);//0발이장전되었다.현재6발.
		soldier.info();
		}
		빵야!1발남았다. 빵야!0발남았다. 헛빵!
		3발장전되었다.현재3발
		3발장전되었다.현재6발
		0발장전되었다.현재6발
		람보:K2(6)
		*/
		Gun gun =new Gun("K2",2);//모델명,총알수
		Soldier soldier =new Soldier("람보",gun);//군인명,총
		soldier.shoot();//빵야!1발남았다.
		soldier.shoot();//빵야!0발남았다.
		soldier.shoot();//헛빵!
		soldier.reload(3);//3발이장전되었다.현재3발.
		soldier.reload(6);//3발이장전되었다.현재6발.
		soldier.reload(6);//0발이장전되었다.현재6발.
		soldier.info();
		
	}

}
