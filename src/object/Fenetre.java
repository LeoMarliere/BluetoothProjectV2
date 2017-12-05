package object;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ui.DetectedDevicePanel;

public class Fenetre extends JFrame {
	private JTable tableau;
	private JScrollPane scrollPane;
	 public Fenetre() throws IOException, InterruptedException{

		 	// On crée la fenêtre
		    this.setTitle("Liste des Appareils Bluetooth");
		    this.setSize(400, 500);
		    this.setLocationRelativeTo(null); 
		    this.setResizable(false);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		    
		    tableau = new JTable(new DetectedDevicePanel());
		    scrollPane =new JScrollPane(tableau);
		    
		    getContentPane().add(scrollPane, BorderLayout.CENTER);
		    
		    JPanel boutons = new JPanel();
		    
	        boutons.add(new JButton(new RefreshAction()));
	        boutons.add(new JButton(new ShowFCAction()));
	 
	        getContentPane().add(boutons, BorderLayout.SOUTH);
		    
	        pack();

		  }    
	 
	  public static void main(String[] args) throws IOException, InterruptedException {
	        new Fenetre().setVisible(true);
	    }
	  
	  
	  private class RefreshAction extends AbstractAction {
	        private RefreshAction() {
	            super("Actualiser");
	        }
	 
	        public void actionPerformed(ActionEvent e) {
	        	try {
	        		tableau.setModel(new DetectedDevicePanel());
	    		    scrollPane.setViewportView(tableau);
				} catch (IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	 System.out.println("okok");
	        }
	    }
	  
	  private class ShowFCAction extends AbstractAction {
	        private ShowFCAction() {
	            super("Ouvrir Fiche Client");
	        }
	 
	        public void actionPerformed(ActionEvent e) {
	        	int selection = tableau.getSelectedRow();
	        	String addresseMac = (String) tableau.getValueAt(selection, 0);
	        	
	        }
	    }

}
