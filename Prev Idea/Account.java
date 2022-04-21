import java.util.Random;

/** TODO javadoc
 *
 * */

public class Account {

	private String pin;
	private String accountNum;
	private String routingNum;
	private double balance;
	private String fname;
	private String lname;

	public Account(String pin) { // new acco
		this.pin = pin;
		generateNums();
		balance = 0;
	} // close non-defualt constructor

	public Account(String accountNum, String pin, String routingNum, String balance, String fname, String lname) {
		this.pin = pin;
		this.accountNum = accountNum;
		this.routingNum = routingNum; 
		this.balance = Double.valueOf(balance);
		this.fname = fname;
		this.lname = lname;
	} // close non-default constructor


	// Getters and Setters for accountNum, routingNum, and balance
	public String getAccountNum() {
		return accountNum;
	} // close getAccountNum

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	} // close setAccountNum


	public String getRoutingNum() {
		return routingNum;
	} // close getRoutingNum

	public void setRoutingNum(String routingNum) {
		this.routingNum = routingNum;
	} // close setRoutingNum


	public double getBalance() {
		return balance;
	} // close getBalance

	public void setBalance(double balance) {
		this.balance = balance;
	} // close setBalance

	public void setName(String fname, String lname){
		this.fname = fname;
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	} // close getFname

	public String getLname() {
		return lname;
	} // close getLname

	public String getFileName(){
		return (getAccountNum() + ".account");
	} // close getFileName

	public boolean login(String pin){
		return this.pin.equals(pin);
	} // close login

	// generates and sets a 16 digit int for both accountNum and routingNum
	public void generateNums() {
		Random rnd = new Random();
		accountNum = String.valueOf(1000000000000000.0 + rnd.nextDouble(9000000000000000.0));
		routingNum = String.valueOf(1000000000000000.0 + rnd.nextDouble(9000000000000000.0));
		//TODO truncate routingNum and accountNum when displaying to screen
	} // close generateNums method

} // close Account class

