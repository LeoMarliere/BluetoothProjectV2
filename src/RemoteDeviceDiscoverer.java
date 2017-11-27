

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.bluetooth.*;


/**
 * Minimal Device Discovery example.
 */
public class RemoteDeviceDiscoverer{

//	private final Vector devicesDiscovered = new Vector();
	List <RemoteDevice> test = new ArrayList();
	public void searchDevices() throws IOException, InterruptedException {

		final Object inquiryCompletedEvent = new Object();

//		devicesDiscovered.clear();

		DiscoveryListener listener = new DiscoveryListener() {

			public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
				try {
				System.out.println("Device " + btDevice.getBluetoothAddress() + " found"+"     name " + btDevice.getFriendlyName(false));
//				devicesDiscovered.addElement(btDevice);
				test.add(btDevice);
				} catch (IOException cantGetDeviceName) {
				}
			}

			public void inquiryCompleted(int discType) {
				System.out.println("Device Inquiry completed!");
				synchronized(inquiryCompletedEvent){
					inquiryCompletedEvent.notifyAll();
				}
			}

			public void serviceSearchCompleted(int transID, int respCode) {
			}

			public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
			}
		};

		synchronized(inquiryCompletedEvent) {
			boolean started = LocalDevice.getLocalDevice().getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC, listener);
			if (started) {
				//wait for device inquiry to complete
				inquiryCompletedEvent.wait();
				System.out.println(test.size() +  " device(s) found");
			}
		}
	}



}
