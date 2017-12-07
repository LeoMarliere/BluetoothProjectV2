package object;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Fenetre4 {
	private JFrame fenetre4;
	private JPanel pan1;
	private JLabel label1;
	private JLabel label11;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JTextArea textArea3;
	private JTextArea textArea4;
	private JTextArea textArea5;
	private JTextArea textArea6;
	private JTextArea textArea7;
	private JTextArea textArea8;
	private JTextArea textArea9;
	private Font font1;
	private GridLayout grid;
	private JPanel boutons;
	private String adresseMac;
	
	
	public Fenetre4(String adresseMac) throws ClassNotFoundException, SQLException {
		this.adresseMac=adresseMac;
		
		fenetre4 = new JFrame("Création d'une fiche client");
		pan1 = new JPanel();

		grid= new GridLayout(8,2);
		grid.setHgap(10);
		grid.setVgap(10);
		pan1.setLayout(grid);

		fenetre4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetre4.setLocation(700, 200); 
		fenetre4.setSize(600,700);
		fenetre4.setVisible(true);
		ConnexionBDD con = new ConnexionBDD();

		label1= new JLabel("     Adresse MAC : ");
		label11= new JLabel(adresseMac);
		label2= new JLabel("     Nom  : ");
		label3= new JLabel("     Prenom : ");
		label4= new JLabel("     Adresse : ");
		label5= new JLabel("     Mail : ");
		label6= new JLabel("     Numero de telephone : ");
		label7= new JLabel("     Genre : ");
		label8= new JLabel("     Date de naissance : ");



		//if(ficheCree) {
		textArea1= new JTextArea();
		textArea2= new JTextArea();
		textArea3= new JTextArea();
		textArea4= new JTextArea();
		textArea5= new JTextArea();
		textArea6= new JTextArea();
		textArea7= new JTextArea();


		//}
		font1 = new Font("Serif", Font.PLAIN, 26);
		label1.setFont(font1);
		label11.setFont(font1);
		label2.setFont(font1);
		label3.setFont(font1);
		label4.setFont(font1);
		label5.setFont(font1);
		label6.setFont(font1);
		label7.setFont(font1);
		label8.setFont(font1);
		textArea1.setFont(font1);
		textArea2.setFont(font1);
		textArea3.setFont(font1);
		textArea4.setFont(font1);
		textArea5.setFont(font1);
		textArea6.setFont(font1);
		textArea7.setFont(font1);
	

		pan1.add(label1);
		pan1.add(label11);
		pan1.add(label2);
		pan1.add(textArea1);
		pan1.add(label3);
		pan1.add(textArea2);
		pan1.add(label4);
		pan1.add(textArea3);
		pan1.add(label5);
		pan1.add(textArea4);
		pan1.add(label6);
		pan1.add(textArea5);
		pan1.add(label7);
		pan1.add(textArea6);
		pan1.add(label8);
		pan1.add(textArea7);
		

		boutons = new JPanel();
		boutons.add(new JButton(new Valider()));
		

		con.connexionClose();

		fenetre4.getContentPane().add(pan1,BorderLayout.CENTER);
		fenetre4.getContentPane().add(boutons, BorderLayout.SOUTH);
	}
	
	public String getAdresseMac() {
		return adresseMac;
	}
	
	private class Valider extends AbstractAction {
		private Valider() {
			super("Valider");
		}

		public void actionPerformed(ActionEvent e) {
			
			try {
				Date ajd = new Date();
				SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");
				
				ConnexionBDD con= new ConnexionBDD();
			
				con.insertFiche(getAdresseMac(), textArea1.getText(), textArea2.getText(), textArea3.getText(), textArea4.getText(), textArea5.getText(), textArea6.getText(), textArea7.getText());
				con.insertPeriph(getAdresseMac(), 1, formater.format(ajd).toString(), true);

				con.connexionClose();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				
			}
			
			
		}
	}
}
