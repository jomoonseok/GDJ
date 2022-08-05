package quiz04_employee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Company {

	private Employee[] employees;
	private int idx;
	private Scanner sc;

	public Company() {
		employees = new Employee[5];
		sc = new Scanner(System.in);
	}

	public void addEmployee() throws EmployeeException {
		if (idx == employees.length) {
			throw new EmployeeException("Full", 1);
		}
		System.out.print("Regular/Temporary >>> ");
		String a = sc.next().replace(" ", "");
		if (a.equalsIgnoreCase("Regular")) {

			System.out.print("사원번호 입력 >>> ");
			int empNo = sc.nextInt();

			System.out.print("이름 입력 >>> ");
			String name = sc.next();

			System.out.print("월급 입력 >>> ");
			int salary = sc.nextInt();

			Regular regular = new Regular(empNo, name, salary);
			employees[idx++] = regular;
			
			return;

		} else if (a.equalsIgnoreCase("Temporary")) {

			System.out.print("사원번호 입력 >>> ");
			int empNo = sc.nextInt();

			System.out.print("이름 입력 >>> ");
			String name = sc.next();

			Temporary temporary = new Temporary(empNo, name);
			employees[idx++] = temporary;

			System.out.print("시급 입력 >>> ");
			temporary.setPay(sc.nextInt());

			System.out.print("시간 입력 >>> ");
			temporary.setWorkTimes(sc.nextInt());
			
			return;

		}
		System.out.println("잘못 입력하셨습니다.");

	}

	public void dropEmployee() throws EmployeeException { // 사원번호가 일치하면 삭제
		if (idx == 0) {
			throw new EmployeeException("EMPTY", 2);
		}
		System.out.print("사원번호 입력 >>> ");
		int empNo = sc.nextInt();
		for(int i=0; i<idx; i++) {
			if(empNo == employees[i].getEmpNo()) {
				System.arraycopy(employees, i+1, employees, i, idx-i-1);
				employees[idx--] = null;
				return;
			}
		}
		System.out.println("맞는 사원번호가 없습니다.");
	}

	public void findEmployee() throws EmployeeException { // 사원번호를 입력 받아 검색
		if (idx == 0) {
			throw new EmployeeException("EMPTY", 2);
		}
		System.out.print("사원번호 입력 >>> ");
		int empNo = sc.nextInt();
		for(int i=0; i<idx; i++) {
			if(empNo == employees[i].getEmpNo()) {
				System.out.println(employees[i].toString());
				return;
			}
		}
		System.out.println("맞는 사원번호가 없습니다.");
	}

	public void printAllEmployees() throws EmployeeException {
		if (idx == 0) {
			throw new EmployeeException("EMPTY", 2);
		}
		for(int i=0; i<idx; i++) {
			System.out.println(employees[i].toString());
		}
	}

	public void manage() {
		while (true) {
			try {
				System.out.print("1.등록 2.삭제 3.조회 4.전체목록 0.프로그램종료 >>> ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					addEmployee();
					break;
				case 2:
					dropEmployee();
					break;
				case 3:
					findEmployee();
					break;
				case 4:
					printAllEmployees();
					break;
				case 0:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					throw new RuntimeException("잘못된 명령입니다.");
				}
			} catch (InputMismatchException e) {
				sc.next();
				System.out.println("명령은 정수로 입력");
			} catch (EmployeeException e) {
				System.out.println(e.getMessage() + " " + e.getErrorCode());
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		} // while

	}

}
