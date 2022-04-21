import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


// Login frame
public class BankGUI extends JFrame{

	
	private JTextField txtAccountNum;
	private JPasswordField txtPin;
	
	private Bank bank;

	public BankGUI() {
		super("Bank");
		
		bank = new Bank();
		
		
		// create fields
		JPanel pnlMain = new JPanel(new GridLayout(0,2,10,10));
		pnlMain.setBorder(new EmptyBorder(10, 10, 10, 10));
		pnlMain.add(new JLabel("Account Number"));
		pnlMain.add(txtAccountNum = new JTextField());
		pnlMain.add(new JLabel("Pin"));
		pnlMain.add(txtPin = new JPasswordField());
		
		
		// buttons
		JButton btnLogin = new JButton("Login");
		JButton btnCreateAccount = new JButton("Create Account");
		
		pnlMain.add(btnLogin);
		pnlMain.add(btnCreateAccount);
		
		// login
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account account = bank.login(txtAccountNum.getText(), new String(txtPin.getPassword()));
				if(account == null) // not logged in
					showMessage("Invalid details, unable to login");
				else {
					
					dispose(); // close this
					
					// create dashboard
					new AccountDashboard(bank, account);
					
				}
				
			}
		});
		
		
		// create account
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean created = bank.addAccount(new Account(txtAccountNum.getText(), new String(txtPin.getPassword())));
				if(created)
					showMessage("Account created.");
				else {
					showMessage("Unable to create account, please enter unique account number");
				}
				
			}
		});
		
		
		
		
		add(pnlMain);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	// show message in pop up
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	
	public static void main(String[] args) {
		new BankGUI();
	}
	
	
	
	
	
	
	
}
