package ex11_downcasting;

public class Main {

	public static void main(String[] args) {
		
		Car[] carArr = new Car[10];
		
		for(int i=0; i<carArr.length; i++) {
			double r = Math.random();
			if(r < 0.33) {
				carArr[i] = new Car();
				carArr[i].drive();
			} else if(r < 0.66) {
				carArr[i] = new Ev();
				((Ev) carArr[i]).charge();
			} else if(r < 0.99) {
				carArr[i] = new Hybrid();
				((Hybrid) carArr[i]).addOil();
			}
		}
		
		System.out.println();
	
		for(int i=0; i<carArr.length; i++) {
			if(carArr[i] instanceof Hybrid) { // 후손부터 먼저 체크함
				((Hybrid) carArr[i]).addOil();
			} else if(carArr[i] instanceof Ev) {
				((Ev) carArr[i]).charge();
			} else if(carArr[i] instanceof Car) {
				carArr[i].drive();
			}
		}

	}

}
