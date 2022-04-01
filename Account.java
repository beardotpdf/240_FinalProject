

/** TODO javadoc
 *
 * */

public class Account {

	private int pin;
	private int accountNum;
	private int routingNum;
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

	public Account(int pin, int accountNum, int routingNum, float balance) {
		this.pin = pin;
		this.accountNum = accountNum;
		this.routingNum = routingNum;
		this.balance = balance;
	} // close non-default constructor


	// Getters and Setters for accountNum, routingNum, and balance
	public int getAccountNum() {
		return accountNum;
	} // close getAccountNum

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	} // close setAccountNum


	public int getRoutingNum() {
		return routingNum;
	} // close getRoutingNum

	public void setRoutingNum(int routingNum) {
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
		//TODO Generation
	} // close generateNums method

} // close Account class

