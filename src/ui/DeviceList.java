package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.bluetooth.RemoteDevice;

import object.Fenetre;

public class DeviceList {
	
	static String tempDeviceName;
	private static RemoteDeviceDiscoverer remoteDeviceDiscoverer;
	private static List <RemoteDevice> deviceList;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		Fenetre fen = new Fenetre();
		
		//remoteDeviceDiscoverer = new RemoteDeviceDiscoverer();  	
		//remoteDeviceDiscoverer.searchDevices(); 
		//deviceList = remoteDeviceDiscoverer.getTest();
		
		//System.out.println(deviceList.get(1).getFriendlyName(false));

	}

}
