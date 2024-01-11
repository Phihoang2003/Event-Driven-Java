package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhongBan;

public class PhongBan_Dao {
	public ArrayList<PhongBan> getAllPhongBan(){
		ArrayList<PhongBan> dsPhongBan=new ArrayList<PhongBan>();
		try {
			ConnectDB.getInstance();
			Connection con=ConnectDB.getConnection();
			String sql="Select * from PhongBan";
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				String maPhong=rs.getString("maPhong");
				String tenPhong=rs.getString("tenPhong");
				PhongBan pb=new PhongBan(maPhong,tenPhong);
				dsPhongBan.add(pb);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsPhongBan;
	}
}
