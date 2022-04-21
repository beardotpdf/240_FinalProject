import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


// account dashboard
public class AccountDashboard extends JFrame{

	
	// fields
	private JTextField txtAccountNum;
	private JTextField txtBalance;
	private JTextField txtAmount;
	private JTextField txtTargetAccount;
	private JButton btnWithdraw, btnDeposit, btnTransfer, btnLogout;
	
	
	private Bank bank;
	private Account account;
	
	public AccountDashboard(Bank bank, Account account) {
		super("Account Dashboard"); // set title
		this.bank = bank;
		this.account = account;
		
		JPanel pnlMain = new JPanel(new GridLayout(0,2,10,10));
		pnlMain.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// add fields
		pnlMain.add(new JLabel("Account Number"));
		pnlMain.add(txtAccountNum = new JTextField(account.getAccountNum()));
		pnlMain.add(new JLabel("Balance"));
		pnlMain.add(txtBalance = new JTextField());
		txtAccountNum.setEditable(false);
		txtBalance.setEditable(false);
		
		
		// add empty row
		pnlMain.add(new JLabel());
		pnlMain.add(new JLabel());
		
		
		// add other fields
		pnlMain.add(new JLabel("Amount"));
		pnlMain.add(txtAmount = new JTextField());
		pnlMain.add(new JLabel("Target Account Number\n(only in case of transfer)"));
		pnlMain.add(txtTargetAccount = new JTextField());
		
		// add buttons
		pnlMain.add(btnWithdraw = new JButton("Withdraw"));
		pnlMain.add(btnDeposit = new JButton("Deposit"));
		pnlMain.add(btnTransfer = new JButton("Transfer"));
		pnlMain.add(btnLogout = new JButton("Logout"));
		
		addListeners();
		
		updateBalance();
		
		add(pnlMain);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	// listners for buttons
	public void addListeners() {
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// read amount
					double amount = Double.parseDouble(txtAmount.getText());
					
					if(bank.withdraw(account.getAccountNum(), amount)) { // withdraw
						showMessage("Withdraw successful");
						txtAmount.setText("");
						updateBalance();
					} else {
						showMessage("Plese enter valid amount to withdraw.");
					}
						
					
 				} catch(Exception ex) {
 					showMessage("Plese enter valid amount to withdraw.");
 				}
			}
		});
		
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					// read amount
					double amount = Double.parseDouble(txtAmount.getText());
					
					if(bank.deposit(account.getAccountNum(), amount)) { // deposit
						showMessage("Deposit successful");
						txtAmount.setText("");
						updateBalance();
					} else {
						showMessage("Plese enter valid amount to deposit.");
					}
						
					
 				} catch(Exception ex) {
 					showMessage("Plese enter valid amount to deposit.");
 				}
			}
		});
		
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					// read amount and target account
					double amount = Double.parseDouble(txtAmount.getText());
					String target = txtTargetAccount.getText();
					//TODO TESTING
					System.out.println(account.getAccountNum() + " " + target);
					System.out.println(amount);
					if(bank.transfer(account.getAccountNum(), target, amount)) { // transfer
						showMessage("Transfer successful");
						txtAmount.setText("");
						txtTargetAccount.setText("");
						updateBalance();
					} else {
						showMessage("Plese enter valid amount and account to transfer.");
					}
						
					
 				} catch(Exception ex) {
 					showMessage("Plese enter valid amount to transfer.");
 				}
			}
		});
		
		
		// logout
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BankGUI();
			}
		});
		
		
		
		
	}
	
	// show message
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	
	// show balance as formatted string
	public void updateBalance() {
		txtBalance.setText(String.format("$%.2f", account.getBalance()));
	}
	
	
}
