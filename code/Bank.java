import java.io.BufferedReader;
import java.io.FileWriter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
/**
* 
* @param args
 */

public class Bank {
	
	public static void main(String[] args) {

		ImageIcon logo = new ImageIcon("logoBankOfUMW.png");

		JLabel welcome = new JLabel("Welcome to Bank of UMW");
		JLabel instructions = new JLabel("Please Select an Option Below");
		
		JFrame frame = new JFrame();
		frame.setIconImage(logo.getImage());
		frame.add(welcome);
		frame.add(instructions);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,650);
		frame.setResizable(false);
		frame.setVisible(true);

	} // close main method


} // close Bank class
