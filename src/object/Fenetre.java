package object;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.bluetooth.RemoteDevice;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import ui.RemoteDeviceDiscoverer;

public class Fenetre extends JFrame {
	 private JPanel pan = new JPanel();
	 private JButton bouton = new JButton("Ajouter");

//	static String tempDeviceName;
//	private static RemoteDeviceDiscoverer remoteDeviceDiscoverer;
//	private static List <RemoteDevice> deviceList;
	
	
	 public Fenetre() throws IOException, InterruptedException{ 
		 
		 
		    this.setTitle("Liste des Appareils Bluetooth");
		    this.setSize(600,800);
		    this.setLocationRelativeTo(null); 
		    this.setResizable(false);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		    
		    
//		    remoteDeviceDiscoverer = new RemoteDeviceDiscoverer();  	
//			remoteDeviceDiscoverer.searchDevices(); 
//			deviceList = remoteDeviceDiscoverer.getTest();
//			System.out.println(remoteDeviceDiscoverer.getTest());
		 
		    //Instanciation d'un objet JPanel
		   
		    
		    //Définition de sa couleur de fond
		    pan.setBackground(Color.ORANGE);  
		    
//		    for(int i=0;i<deviceList.size();i++) {
//		    	JLabel label = new JLabel("\n " + deviceList.get(i).getFriendlyName(false) + "    " + deviceList.get(i).getBluetoothAddress() + "\n");
//		    	pan.add(label);
//		    	
//		    	
//		    }
		    
		      
		       
		    
		        pan.add(bouton);
		 
		        
		        
		        
		    
		    
		    //On prévient notre JFrame que notre JPanel sera son content pane
		    this.setContentPane(pan);               
		    this.setVisible(true);
		    
		  }       

}
