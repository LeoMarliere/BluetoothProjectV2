package object;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import outils.DetectedDevicePanel;

public class Fenetre{
	private JTable tableau;
	private JScrollPane scrollPane;
	private JFrame frame1;
	private Font font;
	private Font font2;
	 public Fenetre() throws IOException, InterruptedException{
		 	frame1 = new JFrame("Liste des Appareils Bluetooth");
		   
		 	frame1.setSize(600, 700);
		 	frame1.setLocation(500, 200);
		 	frame1.setVisible(true);
		 	frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		    
		    tableau = new JTable(new DetectedDevicePanel());
		    font = new Font("Serial", Font.PLAIN, 26);
		    font2 = new Font("Serial", Font.BOLD, 30);
		    tableau.setFont(font);
		    tableau.setRowHeight(30);
		    tableau.getTableHeader().setFont(font2);
		    tableau.getTableHeader().setPreferredSize(new Dimension( tableau.getTableHeader().getWidth(),35));
		    scrollPane =new JScrollPane(tableau);
		    
		    frame1.getContentPane().add(scrollPane, BorderLayout.CENTER);
		    
		    JPanel boutons = new JPanel();
		    
	        boutons.add(new JButton(new RefreshAction()));
	        boutons.add(new JButton(new ShowFCAction()));
	 
	        frame1.getContentPane().add(boutons, BorderLayout.SOUTH);
		    
	       

		  }    
	 
	 public Component getFrame() {
		 return frame1;
	 }
	 
	  public static void main(String[] args) throws IOException, InterruptedException {
	        new Fenetre().frame1.setVisible(true);
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
	        	if(tableau.getSelectedColumnCount() != 0) {
	        		int selection = tableau.getSelectedRow();
	        		String adresseMac = (String) tableau.getValueAt(selection, 0);
	        		String deviceName = (String) tableau.getValueAt(selection, 1);
	        		try {
	        			
						Fenetre2 frame2 = new Fenetre2(adresseMac, deviceName);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        	}else {
	        		JOptionPane jop = new JOptionPane();
	        		jop.showMessageDialog(null,"Sélectioner un client","Attention",JOptionPane.WARNING_MESSAGE);
	        	}
	        }
	    }

}
