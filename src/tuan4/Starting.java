package tuan4;

import javax.swing.SwingUtilities;

public class Starting {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Sach_UI sach = new Sach_UI();
				sach.setVisible(true);
			}
		});
	}
}
