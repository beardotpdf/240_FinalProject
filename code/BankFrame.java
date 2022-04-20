import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;

public class BankFrame extends JFrame {

	BankFrame() {
		this.setTitle("Bank of UMW");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(550,550);
		this.setVisible(true);

		ImageIcon image = new ImageIcon("logoBankOfUMW.png");
		this.setIconImage(image.getImage());
		this.getContentPane().setBackground(Color.GRAY);

	} // close default constructor


} // close BankFrame class
