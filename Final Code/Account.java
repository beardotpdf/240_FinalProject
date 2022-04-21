import java.io.PrintWriter;


// Account class
public class Account {

	// Account details
	private String accountNum;
	private String pin;
	private double balance;

	
	// create a zero balance account
	public Account(String accountNum, String pin) {
		this(accountNum, pin, 0);
	}

	
	// account ith given balance
	public Account(String accountNum, String pin, double balance) {
		this.accountNum = accountNum;
		this.pin = pin;
		this.balance = balance;
	}

	// check if account can be logged in
	public boolean login(String pin) {
		return this.pin.equals(pin);
	}
	
	// Getters

	public String getAccountNum() {
		return accountNum;
	}

	public double getBalance() {
		return balance;
	}

	
	// withdraw
	public boolean withdraw(double amount) {
		if (balance < amount || amount < 0)
			return false;

		balance -= amount;
		return true;
	}

	
	// deposit
	public void deposit(double amount) {
		balance += amount;
	}
	
	
	// save account to file
	public void save(PrintWriter pw) {
		pw.println(accountNum + "\t" + pin + "\t" + balance);
	}
}
