package quiz06_game;

public class Tank extends GameUnit {

	public Tank(String name) {
		super(name, 100, 10);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void attack(GameUnit unit) {
		if(Math.random() < 0.1) {
			unit.setEnergy(0);
			unit.setAlive(unit.getEnergy() > 0);
			System.out.println(unit.getName() + "을 한 방에 죽였다.");
		} else {
			int unitEnergy = unit.getEnergy() - this.getPower() < 0 ? 0 : unit.getEnergy() - this.getPower();
			unit.setEnergy(unitEnergy);
			unit.setAlive(unit.getEnergy() > 0);
			System.out.println(unit.getName() + "의 남은 에너지 " + unit.getEnergy());
		}
		
	}

}
