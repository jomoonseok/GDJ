package ex07_override;

public class Americano extends Espresso {
	
	private int extraWater;
	
	@Override
	public void taste() {
		// TODO Auto-generated method stub 
		// TODO -> 해야 할 일을 적어 둠
		// super.taste(); // 에스프레소인데 필요없으면 지운다.
		System.out.println("덜 쓰다");
	}

}
