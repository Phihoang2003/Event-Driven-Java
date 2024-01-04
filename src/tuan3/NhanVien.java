package tuan3;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien implements Serializable {
	private String ma;
	private String hoTen;
	private int tuoi;
	private boolean phai;
	private double luong;
	public NhanVien() {
		super();
	}
	public NhanVien(String ma, String hoTen, int tuoi, boolean phai, double luong) {
		super();
		this.ma = ma;
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.phai = phai;
		this.luong = luong;

	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public boolean isPhai() {
		return phai;
	}
	public void setPhai(boolean phai) {
		this.phai = phai;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ma);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(ma, other.ma);
	}
	
	
}
