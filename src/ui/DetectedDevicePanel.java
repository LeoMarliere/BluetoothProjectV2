package ui;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.bluetooth.RemoteDevice;
import javax.swing.table.AbstractTableModel;

import object.BluetoothDevice;

public class DetectedDevicePanel extends AbstractTableModel {
	// La c'est l'entetes du tableau (j'ai mis que ca pour l'instant mais c'est a changer)
	String[] entetes ={"Device","Name"};
    // A voir laquel des liste ci dessous à utiliser :
    
    // Ici,  c'est la liste des Devices que on va récupe grace a RemoteDeviceDiscoverer
    //private final RemoteDevice[] remoteDevicesList;
    
    RemoteDeviceDiscoverer remoteDeviceDiscoverer;
   
    
    // La, justilise pour le test la liste des BluetoothDevice
    private static List <RemoteDevice> bluetoothDeviceList;
    

   
    public DetectedDevicePanel() throws IOException, InterruptedException {
    		super();
    		entetes =new String[]{"Device","Name"};
    		remoteDeviceDiscoverer = new RemoteDeviceDiscoverer();
    		remoteDeviceDiscoverer.searchDevices();
    		bluetoothDeviceList = new ArrayList<RemoteDevice>();
    		bluetoothDeviceList = remoteDeviceDiscoverer.getTest();
//    		for(int i=0;i<bluetoothDeviceList.size();i++) {
//		    	JLabel label = new JLabel("\n " + deviceList.get(i).getFriendlyName(false) + "    " + deviceList.get(i).getBluetoothAddress() + "\n");
//		    	pan.add(label);		    	
//		    }
    		// La je mets des valeurs test pour l'instant
    		// APres on ajoutera dynamiquement les lignes grace a la liste que l'on recuperera
//    		bluetoothDeviceList.add(	new BluetoothDevice("device1", "01/12/2017"));
//    		bluetoothDeviceList.add(new BluetoothDevice("device2", "02/12/2017"));
//    		bluetoothDeviceList.add(	new BluetoothDevice("device3", "03/12/2017"));
//    		bluetoothDeviceList.add(	new BluetoothDevice("device4", "04/12/2017"));
    	
    
    }
    
    /**
     * Retourne le nombre de ligne
     */
    public int getRowCount() {
        return bluetoothDeviceList.size();
    }
 
    /**
     * Retourne le nombre de colonne
     */
    public int getColumnCount() {
        return entetes.length;
    }
 
    /**
     * Retourne le nom du numéro de la colonne
     */
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
 
    /**
     * Affecte les valeurs des object aux colonnes du tableau
     */
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return bluetoothDeviceList.get(rowIndex).getBluetoothAddress();
            case 1:
			try {
				return bluetoothDeviceList.get(rowIndex).getFriendlyName(false);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            default:
                return null; //Ne devrait jamais arriver
        }
    }
    
    /**
     * Cette méthode ajoute au tableau le device passé en paramtre
     * @param device
     */
    //public void addDevice(BluetoothDevice device) {
//    		bluetoothDeviceList.add(device);
//        fireTableRowsInserted(bluetoothDeviceList.size() -1, bluetoothDeviceList.size() -1);
        
        /*
         * En gros c'est avec cette méthode que on récupèrera ta liste et on aura un truc du genre :
         * for (int i .......){
         * BluetoothDevice device = new BluetoothDevice(avec les trucs que tu recup);
         * tableau.addDevice(device);
         * }
         * ca sera dans la classe main{}
         * 
         * (en gros ^^)
         */
 //   }
    
    
    
    
 
    public void removeDevice(int rowIndex) {
    		bluetoothDeviceList.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }


}
