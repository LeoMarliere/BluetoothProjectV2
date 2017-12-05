import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.bluetooth.RemoteDevice;

import ui.RemoteDeviceDiscoverer;

public class ConnexionBDD {
	private static Connection con;
	private static ResultSet rs;
	private String url="jdbc:mysql://mysql-capontheo.alwaysdata.net:3306/capontheo_bluetoothproject";
	private String login="capontheo";
	private String password="root";
	private static PreparedStatement pstmt;
	private PreparedStatement pstmt2;
	static String tempDeviceName;
	private static RemoteDeviceDiscoverer remoteDeviceDiscoverer;
	private static List <RemoteDevice> deviceList;
	
	public ConnexionBDD() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(url,login,password);
	}
	
	public void connecionClose() throws SQLException {
		pstmt.close();
		con.close();
		rs.close();
	}
	
	public String selectedPeriph(String what, String adresseMac) throws SQLException {
		pstmt =con.prepareStatement("SELECT "+what+" FROM peripherique where adresseMac = ? ;");
		pstmt.setString(1, adresseMac);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			return rs.getString(1);
		}else {
		return null;
		}
	}
	
	public String selectedFiche(String what, String adresseMac) throws SQLException {
		pstmt =con.prepareStatement("SELECT "+what+" FROM ficheClient where adresseMac = ? ;");
		pstmt.setString(1, adresseMac);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			return rs.getString(1);
		}else {
		return null;
		}
	}
	
	public void insertFiche(String adresseMac, String nom, String prenom, String adresse, String eMail, String telephone, String genre, String dateNaissance) throws SQLException {
		pstmt =con.prepareStatement("INSERT into ficheClient (adresseMac, nom, prenom, adresse, adresseMail, telephone, genre, dateNaissance) "
			+"values ('?','?','?','?','?','?','?','?');");	
		pstmt.setString(1, adresseMac);
		pstmt.setString(2, nom);
		pstmt.setString(3, prenom);
		pstmt.setString(4, adresse);
		pstmt.setString(5, eMail);
		pstmt.setString(6, telephone);
		pstmt.setString(7, genre);
		pstmt.setString(8, dateNaissance);
		pstmt.executeUpdate();
	}
	
	public String UpdateFiche(String what, String adresseMac) throws SQLException {
		pstmt =con.prepareStatement("SELECT "+what+" FROM ficheClient where adresseMac = ? ;");
		pstmt.setString(1, adresseMac);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			return rs.getString(1);
		}else {
		return null;
		}
	}
	
	
	public static void main(String[] args) {
	
		try {
			ConnexionBDD test = new ConnexionBDD();
		System.out.println(test.selectedPeriph("adresseMac", "B886879386AE"));
			
			test.connecionClose();
			

//			while(rs.next()) {
//				for(int i=0;i<deviceList.size();i++) {
//					System.out.println("ADD :: "+ deviceList.get(i));
//					if(rs.getString(2).equals(deviceList.get(i))) {
//						pstmt2 =con.prepareStatement("Update peripherique set nombreVisite = ? where adresseMac = ?;");
//						pstmt2.setInt(1, rs.getInt(3)+1);
//						pstmt2.setString(2, deviceList.get(i));
//						pstmt2.executeUpdate();
//						pstmt2.close();
//					}
				
			
//						pstmt2 =con.prepareStatement("INSERT into peripherique (adresseMac, derniereVisite) values (?,?);");
//						pstmt2.setString(1, deviceList.get(i));
//						pstmt2.setString(2, "date1");
//						pstmt2.executeUpdate();
//						pstmt2.close();
//					}
//		}
//
//					if(!rs.next()) {
//						pstmt2 =con.prepareStatement("INSERT into peripherique (adresseMac, derniereVisite) values (?,?);");
//						pstmt2.setString(1, deviceList.get(i));
//						pstmt2.setString(2, "date1");
//						pstmt2.executeUpdate();
//						pstmt2.close();
//					}
				


			

//			pstmt =con.prepareStatement("SELECT * FROM peripherique;");
//			//   pstmt.setString(1, "test");
//			rs=pstmt.executeQuery();
////
//			while(rs.next()){ 
//				for(int i=1;i<=5;i++)
//					System.out.print(rs.getString(i) + " ");
//				System.out.println();
//			}
//			pstmt.close();
//			con.close();
//			rs.close();
		} catch (Exception e) {
			System.err.println("Unable to find and load driver");
			e.printStackTrace();
			System.exit(1);	      
		}

	}
}
