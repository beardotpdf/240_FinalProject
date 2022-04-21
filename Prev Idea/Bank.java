import java.io.FileWriter;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.HashMap;

/* GUI imports */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;



public class Bank {
	
	private static HashMap<String, Account> accounts;
	private static String currentAccount;

	public static void main(String[] args) {

		new BankFrame();

		bank();

		Scanner stdin = new Scanner(System.in);
		System.out.print("What is your account number: ");
		String accountAttempt = stdin.nextLine();
		System.out.println("");
		System.out.print("What is your pin: ");
		String pinAttempt = stdin.nextLine();
		System.out.println("");

		login(accountAttempt, pinAttempt);
		


		//TODO querey what do next
		//Deposit/withdraw - Login first
		
		stdin.close();
	} // close main method


	public static void bank() {
		
		accounts = new HashMap<String, Account>();

		try {
			File folder = new File("accounts/");
			File[] accountFiles = folder.listFiles(); // stores account file names into array

			for (File file : accountFiles) {
				Scanner fileRead = new Scanner(file);
				while (fileRead.hasNextLine()) {
					String accountN = fileRead.nextLine(); // get accountNum, set as key and pass into constructor, store account in hashmap
					accounts.put( accountN, new Account(accountN,fileRead.nextLine(),fileRead.nextLine(),fileRead.nextLine(),fileRead.nextLine(),fileRead.nextLine()));
				}
				fileRead.close();
			}
		} catch(Exception ex) {

		}
	} // close bank method


	public static boolean login(String accountNum, String pin) {
		if (accounts.containsKey(accountNum)) {
			if (accounts.get(accountNum).login(pin)) {
				currentAccount = accountNum;
				System.out.println("Success");
				System.out.println("Hello " + accounts.get(accountNum).getFname() + " " + accounts.get(accountNum).getLname() + "!");
				return true;
			}
			System.out.println("incorrect pin");
			return false;
		}
		System.out.println("Account not found");
		return false;
	} // close login method


	public static void withdraw(double amount) {
		//TODO withdraw
	} // close withdraw method

} // close Bank class
