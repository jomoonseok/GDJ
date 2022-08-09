package ex09_upcasting;

public class Main {

	public static void main(String[] args) {

		// UpCasting
		// 슈퍼클래스 객체 = new 서브클래스();

		Person alba = new Alba();
		alba.eat();
		alba.study();
		alba.work();

		// 문제는 업캐스팅하면 슈퍼클래스의 메소드만 사용할 수 있다.
		// 해결하기 위해서는 오버라이드를 이용하거나 다운캐스팅해야 한다.
		// 오버라이드 - 슈퍼클래스에 서브클래스가 가지고 있는
		// 메소드를 입력해주는데 내용은 없어도 상관없다.
		// 서브클래스에 애너테이션 입력해준다.

		// 업캐스팅이 필요한 이유 서로 다른 객체를 부모 객체로 묶을 수 있다.
		// new Student()와 new Alba()를 Person 타입으로 처리할 수 있다.
		// 한 교실에 Student와 Alba가 섞여 있을 때 어떻게 처리할 것인가?
		// Person 타입의 배열을 이용해서 모두 처리할 수 있다.

		Person[] people = new Person[10];

		people[0] = new Alba();
		people[1] = new Alba();
		people[2] = new Student();

		for (int i = 0; i < people.length; i++) {
			if (people[i] != null) {
				people[i].eat();
				people[i].study();
				people[i].work();
			}
		}

		for (Person person : people) {
			if (person != null) {
				person.eat();
				person.study();
				person.work();
			}
		}
	}

}
