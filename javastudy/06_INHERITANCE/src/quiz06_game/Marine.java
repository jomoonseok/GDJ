package quiz06_game;

public class Marine extends GameUnit {

	public Marine(String name) {
		super(name, 50, 5);
		// TODO Auto-generated constructor stub
	}
	
	// 내 에너지 : getEnergy(); this.getEnergy();
	// 내 공격력 : getPower();  this.getPower();
	// 내 이름   : getName();   this.getName();
	
	// 상대 에너지 : unit.getEnergy(); 
	// 상대 공력력 : unit.getPower();
	// 상대 이름   : unit.getName();
	
	@Override
	public void attack(GameUnit unit) {
		if(Math.random() < 0.2) {
			unit.setEnergy(0);
			unit.setAlive(unit.getEnergy() > 0); // false를 넣어도 된다.
			System.out.println(unit.getName() + "를 한 방에 죽였다.");
		} else {
			int unitEnergy = unit.getEnergy() - this.getPower() < 0 ? 0 : unit.getEnergy() - this.getPower();
			unit.setEnergy(unitEnergy);
			unit.setAlive(unit.getEnergy() > 0);
			System.out.println(unit.getName() + "의 남은 에너지 " + unit.getEnergy());
		}
		
		
	}

}
