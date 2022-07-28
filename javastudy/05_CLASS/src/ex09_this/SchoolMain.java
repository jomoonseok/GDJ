package ex09_this;

public class SchoolMain {

	public static void main(String[] args) {
		
		Student student1 = new Student();
		// student와 this는 같다.  student.stuNo == this.stuNo
		
		student1.setStuNo("11025");
		student1.setName("전지현");
		
		Student student2 = new Student("11026", "정우성");
		
		School school = new School(2); // 재학생 수를 넣어준다.
		school.printStudents();
		school.addStudent(student1);
		school.addStudent(student2);
		school.addStudent(student1);
				
	}

}