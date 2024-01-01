package tuan4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sach_Collection implements Serializable {
	
	private static final long serialVersionUID = 1L;
	List<Sach> ds;
	public Sach_Collection() {
		ds=new ArrayList<Sach>();
	}
	public boolean them(Sach s) {
		if(ds.contains(s)) {
			return false;
		}
		ds.add(s);
		return true;
	}
	public boolean xoa(int i) {
		if(ds.remove(i)!=null) {
			return true;
		}
		return false;
	}
	
	public Sach tim(int ma) {
		for(Sach s:ds) {
			if(s.getMa()==ma) {
				return s;
			}
		}
		return null;
	}
	
	public Sach sua(int i,Sach sach) {
		return ds.set(i, sach);
	}
	public int getSize() {
		return ds.size();
	}
	public Sach getSach(int i) {
		return ds.get(i);
	}
}
