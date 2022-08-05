package quiz03_bank;

public class Bank {

	// 필드
	String accNo;
	long balance;

	// 생성자
	public Bank(String accNo, long balance) {
		this.accNo = accNo;
		this.balance = balance;
	}

	public void deposit(long money) throws BankException {
		if (money <= 0) {
			throw new BankException("마이너스 입금 불가", 1);
		}
		balance += money;
	}

	public Long withdrawal(long money) throws BankException {
		if (money <= 0) {
			throw new BankException("마이너스 출금 불가", 2);
		} else if(balance < money) {
			throw new BankException("잔액부족", 3);
		}
		balance -= money;
		return money;
	}

	public void transfer(Bank other, long money) throws BankException {
		other.deposit(withdrawal(money)); 
	}

	public void inquiry() {
		System.out.println(this);

	}

	@Override
	public String toString() {
		return "Bank [accNo=" + accNo + ", balance=" + balance + "]";
	}


}
