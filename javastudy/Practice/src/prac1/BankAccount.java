package prac1;

public class BankAccount {

	// 필드
	String accNo;
	long balance;
	
	// 생성자
	public BankAccount(String accNo, long balance){
		this.accNo = accNo;
		this.balance = balance;
	}
	
	// 메소드
	
	// 1. 입금(마이너스 입금 불가)
	public void deposit(long money) {
		if(money <= 0) {
			return;
		}
		balance += money;
	}
	
	// 2. 출금(마이너스 출금 + 잔액보다 큰 출금 불가)
	// 실제로 출금된 금액을 반환
	public Long withdraw(long money) {
		if(money <= 0 || money > balance) {
			return 0L;
		}
		balance -= money;
		return money;
	}
	
	// 3. 이체(출금 -> 입금)
	public void transfer(BankAccount other, long money) {
		// 내 통장에서 출금된 금액만큼 상대 계좌에 입금한다.
		long withdrawalMoney = withdraw(money);
		other.deposit(withdrawalMoney);
		
		// 한 줄에 적으면
		//other.deposit(withdraw(money));
	}
	
	// 4. 계좌 정보 확인
	public void inquiry() {
		System.out.println("계좌번호 : " + accNo + ", 잔액 : " + balance + "원");
	}
	
	// 5. 메인 - 메인을 위해 새로운 클래스를 만들필요 없다. 
	//           어디든 만들어도 된다. 하지만 좋은 코딩 스타일은 아니다.
	public static void main(String[] args) {
		BankAccount me = new BankAccount("1234",50000);
		BankAccount mom = new BankAccount("4321",100000);
		
		mom.transfer(me, 50000);
		
		me.inquiry();
		mom.inquiry();
	}
	
	
}
