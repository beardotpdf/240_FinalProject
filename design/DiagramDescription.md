#Bank
##Variables
		
		- String path
			String storing the relative path to the account files directories

		- BufferedReader br
			Read account files

		- FileWriter fr
			Writes updated info to files (will write over files with same name)
	##Methods

		+ main(String args[])
			Menu for navigating other methods.

		+ login(int accountNum)
			Takes accountNum, attempts to open account file with name. If account file is found, account info is read out of file and passed into Account(int pin, int accountNum, int routingNum, float balance)

		+ generate(int pin)
			Makes new account, takes PIN from user and passes into Account(int pin) constructor.

		+ withdraw(int amount)
			Subtracts from account balance using get and set balance. Only allows withdrawls in $10 increments, prevent user from overdrawing.

		+ deposit(float amount)
			Adds to account balance using get and set balance.

		+ transfer(int accountNum)
			Try open Account file with accountNum exists, prompts user if doesn't exist. Create account object from file. Take routingNum from user, reject if incorrect. Take amount to transfer from user. use get and set balance with both account objects to move balance from one to the other, prevent overdraft. Write second account back to file with updated info.

		+ logout()
			Write updated info into file. Exit program.
#Account

##Variables

		- int pin
			4 digit int.

		- int accountNum
			16 digit int

		-int routingNum
			16 digit int

		- float balance
			float storing balance of money in account

	##Methods

		+ Account()
			Default constructor. 

		+ Account(int pin)
			Non-Default contructor, takes PIN when generating new account. Calls generateNums. Sets balance to 0.

		+ Account(int pin, int accountNum, int routingNum, float balance)
			Non-Default constructor, takes: PIN, accountNum, routingNum, and balance. Sets all to instance var with setters. 

		+ getAccountNum()
			return accountNum

		+ setAccountNum(int accountNum)
			sets accountNum

		+ getRoutingNum()
			return routingNum

		+ setRoutingNum(int routingNum)
			sets routingNum

		+ generateNums()
			Using Math.Random, generates 16 digit int for routingNum and accountNum. Uses set routingNum and accountNum to update the instance var.


#/Accounts

	Directory to hold account files, name formatting (accountNum)1234567890123456.account

	Account number is pulled from file name, doesn't need to be stored in file.
	file formatted internally as: PIN, routingNum, balance, no spaces, not extranious White Space

		1234
		1234567890123456
		12345.67

