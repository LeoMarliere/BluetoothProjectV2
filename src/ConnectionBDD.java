import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionBDD {
	public static void main(String[] args) {
		Connection con;
		ResultSet rs;
		String url="jdbc:mysql://mysql-capontheo.alwaysdata.net:3306/capontheo_bluetoothproject";
		String login="capontheo";
		String password="root";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,login,password);
			PreparedStatement pstmt =con.prepareStatement("SELECT * FROM peripherique;");
			//   pstmt.setString(1, "test");
			rs=pstmt.executeQuery();
			while(rs.next()){ 
				System.out.println("test="+rs.getString(2));
			}
			pstmt.close();
			con.close();
			rs.close();
		} catch (Exception e) {
			System.err.println("Unable to find and load driver");
			e.printStackTrace();
			System.exit(1);	      
		}

	}
}
