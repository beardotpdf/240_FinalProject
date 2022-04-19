import java.io.BufferedReader;
import java.io.FileWriter;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

/** TODO javadoc
 *
 *
 *
 * */

public class Bank {
	
	public static void main(String[] args) {

		JFrame frame = new JFrame(); // create frame
		frame.setTitle("Bank of UMW"); // title
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit on x
		frame.setResizable(false); // can't resize
		frame.setSize(500,500); // size
		frame.setVisible(true); // display it

		ImageIcon image = new ImageIcon("logoBankOfUMW.png"); // create image icon
		frame.setIconImage(image.getImage()); // assign image icon
	} // close main method


} // close Bank class
