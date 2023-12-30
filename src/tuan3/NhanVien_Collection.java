package tuan3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NhanVien_Collection implements Serializable{
	private List<NhanVien> dsNV;
	
	public NhanVien_Collection() {
		// TODO Auto-generated constructor stub
		dsNV = new ArrayList<NhanVien>();
	}

	public List<NhanVien> getDsNV() {
		return dsNV;
	}

	public void setDsNV(List<NhanVien> dsNV) {
		this.dsNV = dsNV;
	}
	public boolean them(NhanVien nv) {
		if (dsNV.contains(nv)) {
			return false;
		}else {
			dsNV.add(nv);
			return true;
		}
	}
	public boolean xoaTheoMa(String ma) {
		return dsNV.removeIf(x->x.getMa().equalsIgnoreCase(ma));
	}

	public NhanVien getElement(int selectedRow) {
		// TODO Auto-generated method stub
		for (int i = 0; i < dsNV.size(); i++) {
			if (i == selectedRow) {
				return dsNV.get(i);
			}
		}
		return null;
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return dsNV.size();
	}
	public NhanVien sua(int selectedRow, NhanVien nv) {
		return dsNV.set(selectedRow, nv);
	}
	
}

