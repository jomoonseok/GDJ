package quiz05_exam;

public class Student {
	
	private String name;
	private Exam exam;
	
	public Student(String name) {
		super();
		this.name = name;
	}
	
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	public void info() {
		System.out.println("학생 이름 : " + name);
		exam.examInfo();
	}

}
