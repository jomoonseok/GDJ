package ex03_string;

public class Ex01_String {

	public static void main(String[] args) {
		
		String str1 = "hello";
		String str2 = "hello";
		
		System.out.println(str1 == str2);
		
		String str3 = new String("hi");
		String str4 = new String("hi");
		
		System.out.println(str3 == str4); // 문자열 비교는 ==로 하지 않는다.
		
		// 1. 문자열 동등 비교 equals 메소드를 사용해야 한다.
		boolean result1 = str1.equals(str2);
		boolean result2 = str3.equals(str4);
		
		System.out.println(result1);
		System.out.println(result2);
		
		if(str1.equals(str2)) {
			System.out.println("str1, str2는 같다");
		} else {
			System.out.println("str1, str2는 다르다");
		}
		
		if(!str3.equals(str4)) { // ! 연산은 가급 적 사용하지 않는다. 1. 잘 보이지 않음 2. 흐름이 어색함
			System.out.println("str3, str4는 다르다");
		} else {
			System.out.println("str3, str4는 같다");
		}
		
		// 2. 대소문자를 무시한 문자열 동등 비교
		String str5 = "Hello World";
		String str6 = "hELLO wORLD";
		
		boolean result3 = str5.equalsIgnoreCase(str6); // Case는 대소문자를 의미하는 경우가 있다.
		
		System.out.println(str5.equals(str6));  // 대소문자까지 비교
		System.out.println(result3);            // 대소문자 무시하고 비교
		
		// 3. 문자열의 길이 반환 
		String name = "우영우";
		int length = name.length();
		System.out.println("글자수 : " + length);
		
		// 4. 특정 위치의 문자(char)만 반환
		// 특정 위치 
		// index라고 한다.          ┐
		// 글자마다 부여된 정수값   │ 중요한 부분
		// 0으로 시작               ┘
		System.out.println(name.charAt(0)); // 반환하는 건 char 타입 문자
		System.out.println(name.charAt(1));
		System.out.println(name.charAt(2));
		
		// 5. 문자열의 일부 문자열(String)을 반환
		//    1) substring(begin) : 인덱스 begin(포함)부터 끝까지 반환
		//    2) substring(begin, end) : 인덱스 begin(포함)부터 인덱스 end(불포함)까지 반환
		//       substring(0,1) 0번 인덱스 포함 1번 인덱스 불포함 0번째 인덱스만 출력
		System.out.println(name.substring(0, 1));
		System.out.println(name.substring(1));
		
		// 6. 특정 문자열을 찾아서 해당 인덱스(int)를 반환
		//    1) indexOf
		//       (1) 발견된 첫 번째 문자열의 인덱스를 반환
		//       (1) 발견된 문자열이 없는 경우 -1을 반환
		//    2) lastIndexOf
		//       (1) 발견된 마지막 문자열의 인덱스를 반환
        //       (1) 발견된 문자열이 없는 경우 -1을 반환
		int idx1 = name.indexOf("우");      // 변수 이름이 i, idx는 인덱스를 뜻한다.
		int idx2 = name.indexOf("문석");
		int idx3 = name.lastIndexOf("우");
		int idx4 = name.lastIndexOf("문석");
		System.out.println(idx1);
		System.out.println(idx2);
		System.out.println(idx3);
		System.out.println(idx4);
		
		// 7. 문자열이 특정 패턴으로 시작하는지 boolean(true, false) 반환
		//    startWith(문자열)
		
		if(name.startsWith("민")) {
			System.out.println("민씨입니다.");
		} else {
			System.out.println("민씨가 아닙니다.");
		}
		
		// 8. 문자열이 특정 패턴으로 끝나는지 여부를 boolean(true, false) 반환
		//    endWith(문자열)
		String filename = "image.jpg";  // jpg, png로 끝나면 이미지로 가정
		if(filename.endsWith("jpg") || filename.endsWith("png")) {
			System.out.println("이미지입니다.");
		} else {
			System.out.println("이미지가 아닙니다.");
		}
		
		// 9. 문자열이 특정 패턴을 포함하는지 여부를 boolean(true, false) 반환
		String email = "moon97102002@gmail.com";
		if(email.contains("@") && email.contains(".")) {
			System.out.println("이메일입니다.");
		} else {
			System.out.println("이메일이 아닙니다.");
		}
		
		// 10. 불필요한 공백 제거(좌우 공백)
		String message = "  안녕  하세요  "; // 맨 앞에 공백과 맨 뒤에 공백이 대상
		System.out.println(message.trim());
		System.out.println(message.trim().length());
		
		// 11. 대소문자 변환하기
		// toUpperCase() : 대문자로 변환하기
		// toLowerCase() : 소문자로 변환하기
		String source = "best of best";
		System.out.println(source.toUpperCase());
		System.out.println(source.toLowerCase());
		// 메소드를 사용해도 source는 바뀌지 않는다.
		
		// 12. 찾아 바꾸기 
		// replace(old, new) : old를 new로 변환하기
		String replaced = source.replace("best", "worst");
		System.out.println(source);
		System.out.println(replaced);
		
		// 주의 replaceAll() 메소드는 특정 문자열을 찾아서 변환하는 것이 아님.
		String ip = "192.168.101.91";
		String replacedIp = ip.replaceAll(".", "_"); // 원하는 결과 192_168_101_91
		System.out.println(replacedIp);  
		// 점(.)은 모든 문자를 뜻하는 키워드이다. 그래서 모든 문자를 _로 바꾸라는 명령이 됐다.
		// 해결방법은 있는데 왜 이렇게 되는지 중요한 것이 아니다. 
		// "."이 문자열을 의미하는 것이 아니라는 게 중요하다.
		
		// 13. 빈 문자열인지 여부를 검사한 뒤 boolean(true, false) 반환
		String id = " "; // 공백은 비어있다고 생각하지 않음
		if(id.trim().isEmpty()) {
			System.out.println("빈 문자열");
		} else {
			System.out.println("빈 문자열 아님");
		}
		
		if(id.isBlank()) { //blank는 11버전에 나왔는데 대중화된 건 1.8버전이라 사용해도 돌아가지 않을 수 있으니 사용권장하지 않음
			System.out.println("빈 문자열");
		} else {
			System.out.println("빈 문자열 아님");
		}
		System.out.println();
		
		
		
		
		// 연습. 파일이름을 파일명과 확장자로 분리
		// 단, jpg, git, png 이미지인 경우에만 작업을 진행한다.
		String fullName = "apple.jpg";
		String fileName = ""; // apple
		String extName = ""; // jpg
		/*if(fullName.contains("jpg") || fullName.contains("git") || fullName.contains("png")) {
			fileName = fullName.substring(0, 5);
			extName = fullName.substring(6);
		}
		System.out.println(fileName + ", " + extName);
		*/
		
		// 풀이
		int idxOfDot = fullName.lastIndexOf("."); // 파일 이름을 모를 수도 있어서(인덱스가 달라진다.) 점의 위치를 기준으로 잡아준다.
		fileName = fullName.substring(0, idxOfDot);
		extName = fullName.substring(idxOfDot + 1);
		System.out.println(fileName);
		System.out.println(extName);
		
		// 연습. 문자열 "abc12345def67890ghijk"에서
		// 아라비아 숫자 1234567890을 제외하고 한 글자씩 화면에 출력하시오.
		String str = "abc12345def67890ghijk";
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i); // 메소드를 여러번 호출할 때는 메소드를 변수에 저장하고 사용하자
			if(ch >= 'a' && ch <= 'z') {
				System.out.println(ch);
			}
		}
		
		
	}

}
