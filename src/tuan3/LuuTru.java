package tuan3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class LuuTru implements Serializable {
	public boolean luuFile(Object obj, String path) throws Exception {
		ObjectOutputStream out = null;
		out = new ObjectOutputStream(new FileOutputStream(path));
		out.writeObject(obj);
		out.flush();
		out.close();
		return true;
	}
	public Object docFile(String path) throws Exception {
		ObjectInputStream inp = null;
		inp = new ObjectInputStream(new FileInputStream(path));
		Object o = inp.readObject();
		inp.close();
		return o;
	}
}