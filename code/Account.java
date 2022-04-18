import java.util.Random;

/** TODO javadoc
 *
 * */

public class Account {

	private int pin;
	private double accountNum;
	private double routingNum;
	private float balance;

	public Account() {
		//TODO is this method needed?
		//TODO if it is, generate pin, nums, initialize balance	
		generateNums();
	} // close default constructor

	public Account(int pin) { // new acco
		this.pin = pin;
		generateNums();
		balance = 0;
	} // close non-defualt constructor

	public Account(int pin, double accountNum, double routingNum, float balance) {
		this.pin = pin;
		this.accountNum = accountNum;
		this.routingNum = routingNum;
		this.balance = balance;
	} // close non-default constructor


	// Getters and Setters for accountNum, routingNum, and balance
	public double getAccountNum() {
		return accountNum;
	} // close getAccountNum

	public void setAccountNum(double accountNum) {
		this.accountNum = accountNum;
	} // close setAccountNum


	public double getRoutingNum() {
		return routingNum;
	} // close getRoutingNum

	public void setRoutingNum(double routingNum) {
		this.routingNum = routingNum;
	} // close setRoutingNum


	public float getBalance() {
		return balance;
	} // close getBalance

	public void setBalance(float balance) {
		this.balance = balance;
	} // close setBalance



	// generates and sets a 16 digit int for both accountNum and routingNum
	public void generateNums() {
		Random rnd = new Random();
		accountNum = 1000000000000000.0 + rnd.nextDouble(9000000000000000.0);
		routingNum = 1000000000000000.0 + rnd.nextDouble(9000000000000000.0);
		//TODO truncate routingNum and accountNum when displaying to screen
	} // close generateNums method

} // close Account class

