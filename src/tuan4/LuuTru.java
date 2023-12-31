package tuan4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LuuTru {
	public static boolean save(Object obj,String path) throws Exception {
		ObjectOutputStream oos=null;
		oos=new ObjectOutputStream(new FileOutputStream(path));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
		return true;
	}
	public static Object read(String path) throws Exception {
		ObjectInputStream ois=null;
		ois=new ObjectInputStream(new FileInputStream(path));
		Object o=ois.readObject();
		ois.close();
		return o;
	}
}
