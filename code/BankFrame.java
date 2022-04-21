import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BankFrame extends JFrame implements ActionListener {
		private JButton loginBtn, logoutBtn, withdrawBtn, depositBtn, createBtn;	
	BankFrame() {
		
		ImageIcon logo = new ImageIcon("logoBankOfUMW");
		this.setIconImage(logo.getImage());
		
		this.setLayout(new CardLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(800,650);
		this.setVisible(true);
		this.setTitle("Bank of UMW");

		/*create cards*/

		// Home Screen Card
		JPanel homeScreen = new JPanel();
		homeScreen.setBounds(0,0,WIDTH,HEIGHT);
		JLabel welcome = new JLabel("Welcome to Bank of UMW");
		homeScreen.add(welcome);
		homeScreen.add(loginBtn = new JButton("Login"));
		homeScreen.add(createBtn = new JButton("Create Account"));

		// Login Card
		JPanel loginScreen = new JPanel();
		loginScreen.setBounds(0,0,WIDTH,HEIGHT);
		loginScreen.add(new JTextField("Account Number"));
		loginScreen.add(new JTextField("PIN"));
		loginScreen.add(new JButton("Enter"));
		loginScreen.add(new JButton("Cancel"));

		// Create Account Card
		JPanel createScreen = new JPanel();
		createScreen.setBounds(0,0,WIDTH,HEIGHT);
		
		// Deposit Card
		JPanel depositScreen = new JPanel();
		depositScreen.setBounds(0,0,WIDTH,HEIGHT);
		depositScreen.add(new JLabel("Enter the amount to withdraw below"));
		depositScreen.add(new JTextField("Amount to deposit"));
		depositScreen.add(new JButton("Enter"));
		depositScreen.add(new JButton("Cancel"));

		// Withdraw Card
		JPanel withdrawScreen = new JPanel();
		withdrawScreen.setBounds(0,0,WIDTH,HEIGHT);
		withdrawScreen.add(new JLabel("Enter the amount to withdraw below"));
		withdrawScreen.add(new JTextField("Amount to withdraw"));
		withdrawScreen.add(new JButton("Enter"));
		withdrawScreen.add(new JButton("Cancel"));

		this.add(homeScreen);
		this.add(loginScreen);
		this.add(depositScreen);
		this.add(withdrawScreen);
	} // close default constructor

	@Override
	public void actionPerformed(ActionEvent e) {

	} // close actionPerformed

} // close BankFrame class
