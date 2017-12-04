//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.List;
//
//import javax.bluetooth.RemoteDevice;
//
//import ui.RemoteDeviceDiscoverer;
//
//public class ConnectionBDD {
//	static String tempDeviceName;
//	private static RemoteDeviceDiscoverer remoteDeviceDiscoverer;
//	private static List <RemoteDevice> deviceList;
//	public static void main(String[] args) {
//		Connection con;
//		ResultSet rs;
//		String url="jdbc:mysql://mysql-capontheo.alwaysdata.net:3306/capontheo_bluetoothproject";
//		String login="capontheo";
//		String password="root";
//		PreparedStatement pstmt;
//		PreparedStatement pstmt2;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			con=DriverManager.getConnection(url,login,password);
//
//			remoteDeviceDiscoverer = new RemoteDeviceDiscoverer();  	
//			remoteDeviceDiscoverer.searchDevices(); 
//			deviceList = remoteDeviceDiscoverer.getTest();
//			pstmt =con.prepareStatement("SELECT * FROM peripherique;");
//			rs=pstmt.executeQuery();
//			System.out.println("size"+deviceList.size());
//
//
////			while(rs.next()) {
////				for(int i=0;i<deviceList.size();i++) {
////					System.out.println("ADD :: "+ deviceList.get(i));
////					if(rs.getString(2).equals(deviceList.get(i))) {
////						pstmt2 =con.prepareStatement("Update peripherique set nombreVisite = ? where adresseMac = ?;");
////						pstmt2.setInt(1, rs.getInt(3)+1);
////						pstmt2.setString(2, deviceList.get(i));
////						pstmt2.executeUpdate();
////						pstmt2.close();
////					}
//				
//			
////						pstmt2 =con.prepareStatement("INSERT into peripherique (adresseMac, derniereVisite) values (?,?);");
////						pstmt2.setString(1, deviceList.get(i));
////						pstmt2.setString(2, "date1");
////						pstmt2.executeUpdate();
////						pstmt2.close();
//					}
//		}
////
////					if(!rs.next()) {
////						pstmt2 =con.prepareStatement("INSERT into peripherique (adresseMac, derniereVisite) values (?,?);");
////						pstmt2.setString(1, deviceList.get(i));
////						pstmt2.setString(2, "date1");
////						pstmt2.executeUpdate();
////						pstmt2.close();
////					}
//				
//
//
//			
//
//			pstmt =con.prepareStatement("SELECT * FROM peripherique;");
//			//   pstmt.setString(1, "test");
//			rs=pstmt.executeQuery();
////
////			while(rs.next()){ 
////				for(int i=1;i<=5;i++)
////					System.out.print(rs.getString(i) + " ");
////				System.out.println();
////			}
//			pstmt.close();
//			con.close();
//			rs.close();
//		} catch (Exception e) {
//			System.err.println("Unable to find and load driver");
//			e.printStackTrace();
//			System.exit(1);	      
//		}
//
//	}
//}
