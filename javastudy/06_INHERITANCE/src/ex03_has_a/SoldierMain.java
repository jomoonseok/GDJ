package ex03_has_a;

public class SoldierMain {

	public static void main(String[] args) {
		
		Gun gun = new Gun();
		gun.setModel("K2");
		gun.setBullet(9);
		
		Soldier soldier = new Soldier();
		soldier.setGun(gun);
		
		// soldier가 총을 쏜다.
		//soldier.getGun().shoot(); // soldier.shoot() 이렇게 해야되는데 Soldier에는 shoot 메소드가 없어서 안 된다.
		soldier.shoot();
		
		System.out.println(soldier.getGun().getBullet());  // 군인의 총의 총알
		
		// soldier 총을 장전한다.
		//soldier.getGun().reload(1); // soldier.reload() 이렇게 해야되는데 Soldier에는 reload 메소드가 없어서 안 된다.
		soldier.reload(1);
		
		// soldier가 가지고 있는 gun의 model/bullet
		System.out.println(soldier.getGun().getModel());  // 군인의 총의 모델명
		System.out.println(soldier.getGun().getBullet());  // 군인의 총의 총알

	}

}
