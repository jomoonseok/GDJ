package ex02_lambda.sec04;

public class Main {

	public static void main(String[] args) {
		
		// LAMBDA는 functional interface라고 한다.
		// functional interface에는 4개의 추상 메소드가 있다.
		
		// interface에 추상 메소드가 한 개 있을 때 functional interface라고 할 수 있고 functional interface들은 LAMBDA로 만들어 낼 수 있다.
		
		Soil soil = new Soil();
		
		soil.sellOil(() -> {
			int oil = 30;
			soil.setTotalOil(soil.getTotalOil() - oil);
			soil.setEarning(soil.getEarning() + oil * soil.getPayPerLiter());
			System.out.println("감사합니다. BMW");
		});

		
		soil.sellOil(() -> {
				int oil = 50;
				soil.setTotalOil(soil.getTotalOil() - oil);
				soil.setEarning(soil.getEarning() + oil * soil.getPayPerLiter());
				System.out.println("감사합니다. 소나타");
			});
		
		System.out.println(soil.getTotalOil());
		System.out.println(soil.getEarning());

	}

}
