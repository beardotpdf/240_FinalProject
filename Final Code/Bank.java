import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

// Stores list of accounts
public class Bank {

	private static final String INPUT_FILE = "bank.dat";

	private ArrayList<Account> accounts;

	// constructor
	public Bank() {
		accounts = new ArrayList<>();

		try {
			Scanner scanner = new Scanner(new File(INPUT_FILE));
			while (scanner.hasNext()) {
				accounts.add(new Account(scanner.next(), scanner.next(), scanner.nextDouble()));
			}
			scanner.close();

		} catch (Exception ex) {

		}

	}

	// get total account
	public int numberOfAccounts() {
		return accounts.size();
	}

	// add account
	public boolean addAccount(Account a) {
		Account account = searchAccount(a.getAccountNum());

		if (account != null) { // if already found
			return false;
		}

		accounts.add(a);
		save();
		return true;
	}

	// search account in list
	private Account searchAccount(String accountID) {
		for (Account account : accounts) {
			if (account.getAccountNum().equals(accountID))
				return account;
		}

		return null;

	}

	// deposit
	public boolean deposit(String accountID, double amount) {
		Account account = searchAccount(accountID);
		if (account == null) { // not found
			return false;
		}

		// deposit
		account.deposit(amount);

		save();

		return true;
	}

	// withdraw
	public boolean withdraw(String accountID, double amount) {
		if (amount < 0) { // negative account
			return false;
		}

		// account not found
		Account account = searchAccount(accountID);
		if (account == null) {
			return false;
		}

		// withdraw
		boolean result = account.withdraw(amount);
		save();
		return result;

	}

	
	// trasnfer from one account to other
	public boolean transfer(String fromAccountID, String toAccountID, double amount) {
		Account from = searchAccount(fromAccountID), to = searchAccount(toAccountID);
		//TODO TEST PRINT
		System.out.println(from + " " + to);
		if (from == null || to == null)
			return false;

		if (!from.withdraw(amount))
			return false;

		to.deposit(amount);

		return true;

	}

	
	// login, return th account if login successful
	public Account login(String accountID, String pin) {
		Account account = searchAccount(accountID);
		if (account != null && account.login(pin))
			return account;

		return null;
	}

	
	// save all account to file
	public void save() {
		try {
			PrintWriter pw = new PrintWriter(INPUT_FILE);
			for (Account account : accounts) {
				account.save(pw);
			}

			pw.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

}
