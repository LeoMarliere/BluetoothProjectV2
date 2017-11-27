package object;

import java.awt.Color; 
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	
	
	
	 public Fenetre(){             
		    this.setTitle("Liste des Appareils Bluetooth");
		    this.setSize(400, 500);
		    this.setLocationRelativeTo(null); 
		    this.setResizable(false);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		    
		 
		    //Instanciation d'un objet JPanel
		    JPanel pan = new JPanel();
		    //Définition de sa couleur de fond
		    pan.setBackground(Color.ORANGE);        
		    //On prévient notre JFrame que notre JPanel sera son content pane
		    this.setContentPane(pan);               
		    this.setVisible(true);
		    
		  }       

}
