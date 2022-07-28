package ex04_has_a_inherit;

public class SoldierMain {

	public static void main(String[] args) {
		
		// 생성에 관한 얘기는 나중에
		
		Soldier soldier = new Soldier();
		soldier.reload(10);
		soldier.shoot();
		
		System.out.println(soldier.getBullet());

	}

}
