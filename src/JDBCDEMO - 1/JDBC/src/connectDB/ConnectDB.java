package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	public static Connection con=null;
	public static ConnectDB instance =new ConnectDB();
	public static ConnectDB getInstance() {
		return instance;
	}
	public void connect() throws SQLException {
		String url="jdbc:mysql://localhost:3306/QLNVIEN";
		String user="root";
		String password="phi1232003";
		con=DriverManager.getConnection(url, user, password);
		
	}
	public void disconnect() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				
				e.printStackTrace();
			}
		}
	}
	public static Connection getConnection() {
		return con;
	}
}
