package object;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.bluetooth.RemoteDevice;

import ui.RemoteDeviceDiscoverer;

public class ConnexionBDD {
	private static Connection con;
	private static ResultSet rs;
	private static ResultSet rs2;
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
	
	public void connexionClose() throws SQLException {
		pstmt.close();
	
		con.close();
		
	}
	
	public String selectedPeriph(String what, String adresseMac) throws SQLException {
		String res="";
		pstmt =con.prepareStatement("SELECT "+what+" FROM peripherique where adresseMac = ? ;");
		pstmt.setString(1, adresseMac);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			res= rs.getString(1);
		}else {
			res = null;
		}
		System.out.println(res);
		rs.close();
		return res;
	}
	
	public String selectedFiche(String what, String adresseMac) throws SQLException {
		String res="";
		pstmt =con.prepareStatement("SELECT "+what+" FROM ficheClient where adresseMac = ? ;");
		pstmt.setString(1, adresseMac);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			res= rs.getString(1);
		}else {
			res = null;
		}
		rs.close();
		return res;
	}
	
	public void insertFiche(String adresseMac, String nom, String prenom, String adresse, String eMail, String telephone, String genre, String dateNaissance) throws SQLException {
		pstmt =con.prepareStatement("INSERT INTO ficheClient (adresseMac, nom, prenom, adresse, adresseMail, telephone, genre, dateNaissance) VALUES (?,?,?,?,?,?,?,?);");	
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
	
	public void insertPeriph(String adresseMac, int nombreVisite, String derniereVisite, boolean ficheCree) throws SQLException {
		pstmt =con.prepareStatement("INSERT INTO peripherique (adresseMac, nombreVisite, derniereVisite, ficheCree) VALUES (?,?,?,?);");	
		pstmt.setString(1, adresseMac);
		pstmt.setInt(2, nombreVisite);
		pstmt.setString(3, derniereVisite);
		pstmt.setBoolean(4, ficheCree);
		pstmt.executeUpdate();
	}
	
	public void UpdatePeriphVisiteDate(String adresseMac) throws SQLException {
		Date ajd = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");
		pstmt2 =con.prepareStatement("SELECT nombreVisite FROM peripherique where adresseMac = ? ;");
		pstmt2.setString(1, adresseMac);
		rs2=pstmt2.executeQuery();
		if(rs2.next()) {
			pstmt =con.prepareStatement("UPDATE peripherique SET nombreVisite = ? where adresseMac = ? ;");
			pstmt.setInt(1, rs2.getInt(1)+1);
			pstmt.setString(2, adresseMac);
			pstmt.executeUpdate();
			
			pstmt =con.prepareStatement("UPDATE peripherique SET derniereVisite = ? where adresseMac = ? ;");
			pstmt.setString(1, formater.format(ajd).toString());
			pstmt.setString(2, adresseMac);
			pstmt.executeUpdate();
		}
		pstmt2.close();
		rs2.close();
	}
	
	
//	public static void main(String[] args) {
//	
//		try {
////			ConnexionBDD test = new ConnexionBDD();
////			test.insertFiche("test", "test", "test", "test", "test", "test", "test", "test");
////			
////			test.connexionClose();
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
////					}
////		}
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
////			pstmt =con.prepareStatement("SELECT * FROM peripherique;");
////			//   pstmt.setString(1, "test");
////			rs=pstmt.executeQuery();
//////
////			while(rs.next()){ 
////				for(int i=1;i<=5;i++)
////					System.out.print(rs.getString(i) + " ");
////				System.out.println();
////			}
////			pstmt.close();
////			con.close();
////			rs.close();
//		} catch (Exception e) {
//			System.err.println("Unable to find and load driver");
//			e.printStackTrace();
//			System.exit(1);	      
//		}
//
//	}
}
