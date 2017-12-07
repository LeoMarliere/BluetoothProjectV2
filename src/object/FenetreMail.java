package object;

import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FenetreMail {
	private JFrame fenetreMail;
	private JPanel pan1;
	private JPanel pan2;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JTextArea textArea1;
	private Font font1;
	private JPanel boutons;
	private String email;

	public FenetreMail(String email) throws ClassNotFoundException, SQLException {
		this.email=email;
		fenetreMail = new JFrame("Mail");
		pan1 = new JPanel();
		pan2 = new JPanel();
		fenetreMail.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetreMail.setLocation(700, 200); 
		fenetreMail.setSize(600,700);
		fenetreMail.setVisible(true);
		
		

		label1= new JLabel("Pour : ");
		label2= new JLabel(email);
		label3= new JLabel("Message : ");
		textArea1= new JTextArea();
		
		
		font1 = new Font("Arial", Font.PLAIN, 26);
		label1.setFont(font1);
		label2.setFont(font1);
		label3.setFont(font1);

		textArea1.setFont(font1);

		pan1.add(label1);
		pan1.add(label2);

		pan2.add(label3);
		pan2.add(textArea1);
		
		boutons = new JPanel();


		fenetreMail.getContentPane().add(pan1,BorderLayout.NORTH);
		
		}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new FenetreMail("test");
		
	}
}
