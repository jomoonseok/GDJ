package ex01_file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Main {

	public static void m1() {
		// File 클래스
		// 1. 패키지 : java.io
		// 2. 파일 및 디렉토리 관리
		// 3. 생성 방법
		// 1) new File(경로, 파일)
		// 2) new File(파일)
		// 4. 윈도우의 경로 구분 방법 : 백슬래시(\)
		// 5. 리눅스의 경로 구분 방법 : 슬래시(/)

		// 폴더(디렉터리) 만들기
		File dir = new File("C:\\storage");

		// 존재하지 않으면 만들겠다.
		if (dir.exists() == false) { // if(!dir.exists())
			dir.mkdirs();
		}

		// 존재하면 삭제하겠다.
		else {
			// dir.delete(); // 지금 지운다.
			dir.deleteOnExit(); // JVM이 종료되면 지운다.
		}

	}

	public static void m2() {

		File file = new File("C:\\storage", "my.txt");

		try {
			if (file.exists() == false) {
				file.createNewFile();
			} else {
				file.delete();
			}
		} catch (IOException e) {
			// 개발할 때 넣는 catch 블록 코드
			e.printStackTrace(); // 에러를 콘솔에 찍어라.
		}

	}

	public static void m3() {

		File file = new File("C:\\storage", "my.txt");

		System.out.println("파일명: " + file.getName());
		System.out.println("경로: " + file.getParent());
		System.out.println("전체경로(경로 + 파일명) : " + file.getPath());

		System.out.println("디렉터리인가? " + file.isDirectory());
		System.out.println("파일인가? " + file.isFile());

		long lastModifiedDate = file.lastModified(); // long 타입인 이유 타임스탬프값을 반환해주기 때문에
		System.out.println("수정한날짜 : " + lastModifiedDate);

		String lastModified = new SimpleDateFormat("a hh:mm yyyy-MM-dd ").format(lastModifiedDate);
		System.out.println("수정한날짜 : " + lastModified);
		// 수정한날짜 : 오전 09:50 2022-08-10

		long size = file.length(); // 바이트 단위
		System.out.println("파일크기 : " + size + "byte"); // 영문은 1byte 한글은 2byte 이상 한글은 인코딩에 따라 다르다.

	}

	public static void m4() {
		File dir = new File("C:\\GDJ");

		File[] list = dir.listFiles(); // 디렉터리 내부의 모든 파일/ 디렉터리를 File 객체로 가져옴
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i].getName());
		}
	}

	public static void m5() {

		// 플랫폼마다 다른 경로 구분자 지원
		File file = new File("C:" + File.separator + "storage" + File.separator + "my.txt");
		System.out.println(file.getName());
	}

	public static void q1() {
		File dir = new File("C:\\GDJ");

		File[] list = dir.listFiles();

		int dirCnt = 0;
		int fileCnt = 0;
		long size = 0L;
		for (int i = 0; i < list.length; i++) {
			String lastModified = new SimpleDateFormat("yyyy-MM-dd a hh:mm ").format(list[i].lastModified());
			if (list[i].isHidden() == false) {

				if (list[i].isDirectory()) {
					System.out.println(lastModified + " <DIR> " + list[i].getName());
					dirCnt++;
				} else {
					System.out.println(lastModified + "       " + list[i].getName());
					size += list[i].length();
					fileCnt++;
				}

			}
		} // for
		System.out.println("            " + fileCnt + "개 파일 " + size + "byte");
		System.out.println("            " + dirCnt + "개 디렉터리");
	}

	public static void q2() {
		// C:storage 디렉터리 삭제하기
		// 디렉터리가 비어 있어야 삭제할 수 있으므로 내부 파일을 먼저 삭제
		// 파일이 여러개면 배열 활용
		
		String sep = File.separator;

		File file = new File("C:" + sep + "storage", "my.txt");
		if (file.exists()) {
			file.delete();
		}

		File dir = new File("C:" + sep + "storage");
		if (dir.exists()) {
			dir.delete();
		}
	}

	public static void main(String[] args) {
		q2();
	}
}
