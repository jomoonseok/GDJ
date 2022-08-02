package quiz05_exam;

public class Exam {
	
	private String examName;
	private int k;
	private int e;
	private int m;
	
	public Exam(String examName) {
		super();
		this.examName = examName;
	}
	
	public void setScore() {
		k = (int)(Math.random() * 101);
		e = (int)(Math.random() * 101);
		m = (int)(Math.random() * 101);
	}
	
	public void examInfo() {
		System.out.println(examName + " 성적");
		System.out.println("국어 : " + k + " 영어 : " + e + " 수학 : " + m);
		int total = k + e + m;
		System.out.println("총점 : " + total + " 평균 : " + ((double) total / 3));
	}
	

}
