package quiz03_bank;

public class Main {

	public static void main(String[] args) { // throws BankException { 아무도 try-catch를 안 할 수도 있다. 최종적으로 JVM이 받아서 처리한다.

		Bank me = new Bank("1111", 10_000);
		Bank mom = new Bank("2222", 100_000);

		try {
			mom.transfer(me, 200_000);
		} catch (BankException e) {
			System.out.println(e.getMessage() + ", " + e.getErrorCode());
		}

		me.inquiry();
		mom.inquiry();
	}

}
