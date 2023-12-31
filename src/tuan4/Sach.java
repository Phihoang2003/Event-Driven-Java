package tuan4;

import java.io.Serializable;
import java.util.Objects;

public class Sach implements Serializable {
	private int ma;
	private String ten;
	private int soLuong;
	private String nxb;
	private String loai;
	public Sach(int ma, String ten, int soLuong, String nxb, String loai) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.soLuong = soLuong;
		this.nxb = nxb;
		this.loai = loai;
	}
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getNxb() {
		return nxb;
	}
	public void setNxb(String nxb) {
		this.nxb = nxb;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	
	public String toString() {
		return "Sach [ma=" + ma + ", ten=" + ten + ", soLuong=" + soLuong + ", nxb=" + nxb + ", loai=" + loai + "]";
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
		Sach other = (Sach) obj;
		return ma == other.ma;
	}
}
