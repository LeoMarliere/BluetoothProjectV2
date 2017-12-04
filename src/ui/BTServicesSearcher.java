package ui;


import java.io.IOException;


public class BTServicesSearcher {

	static String tempDeviceName;
	private static RemoteDeviceDiscoverer remoteDeviceDiscoverer;

	public static void main(String[] args) throws IOException, InterruptedException {

		remoteDeviceDiscoverer = new RemoteDeviceDiscoverer();  	
		remoteDeviceDiscoverer.searchDevices(); 
		System.out.println(remoteDeviceDiscoverer.test.get(1));

	}

}
