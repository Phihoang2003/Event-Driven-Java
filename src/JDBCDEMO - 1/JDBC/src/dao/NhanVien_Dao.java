package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import connectDB.ConnectDB;
import entity.NhanVien;
import entity.PhongBan;

public class NhanVien_Dao {
	public NhanVien_Dao() {
		
	}
	public ArrayList<NhanVien> getAllNhanVien(){
		ArrayList<NhanVien> dsNV=new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con=ConnectDB.getConnection();
			String sql="Select * from NhanVien";
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString("maNV");
				String ho=rs.getString("ho");
				String ten=rs.getString("ten");
				int tuoi=rs.getInt("tuoi");
				boolean phai =rs.getBoolean("phai");
				PhongBan phong = new PhongBan(rs.getString("maPhong"));
				double luong=rs.getDouble("tienLuong");
				NhanVien nv=new NhanVien(ma,ho,ten,tuoi,phai,phong,luong);
				dsNV.add(nv);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsNV;
	}
	public boolean them(NhanVien nv) throws Exception {
		int n=0;
		PreparedStatement statement=null;
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		String sql="Insert into NhanVien values(?,?,?,?,?,?,?)";
		statement=con.prepareStatement(sql);
		statement.setString(1, nv.getMaNV());
		statement.setString(2,nv.getHo());
		statement.setString(3, nv.getTen());
		statement.setInt(4, nv.getTuoi());
		statement.setBoolean(5, nv.isPhai());
		statement.setString(6,nv.getPhong().getMaPhong());
		statement.setDouble(7, nv.getLuong());
		n=statement.executeUpdate();
		return n>0;
	}
}
