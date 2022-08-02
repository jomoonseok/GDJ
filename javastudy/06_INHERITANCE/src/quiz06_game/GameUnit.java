package quiz06_game;

public abstract class GameUnit {
	private String name;
	private int energy;
	private int power;
	private boolean isAlive;
	
	public GameUnit(String name, int energy, int power) {
		this.name = name;
		this.energy = energy > 0 ? energy : 0;
		this.power = power;
		this.isAlive = energy > 0;
	}
	
	public void info() {
		System.out.println(name + "에너지 : " + energy + " 공력력 " + power);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public boolean isAlive() { // boolean 데이터는 get 대신 is가 들어감
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	public abstract void attack(GameUnit unit);
	
	

}
