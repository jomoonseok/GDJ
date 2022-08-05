package quiz04_employee;

public class Regular extends Employee {

	private int salary;

	public Regular(int empNo, String name, int salary) {
		super(empNo, name);
		this.salary = salary;
	}

	@Override
	public String toString() {
		return super.toString() + ", salary=" + salary + "]";
	}
	/*
	Object toString() 참조
	
	Employee toString() empNo, name
	
	Regular toString() salary
	
	Regular toString() super.toString() + salary
	*/
}
