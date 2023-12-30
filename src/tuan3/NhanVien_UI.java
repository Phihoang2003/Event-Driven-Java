package tuan3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class NhanVien_UI extends JFrame implements ActionListener, MouseListener, Serializable{
	private JTextField jtf_ma;
	private JCheckBox ck_phai;
	private JTextField jtf_hoTen;
	private JTextField jtf_tuoi;
	private JTextField jtf_luong;
	private JTable nhanVien_table;
	private DefaultTableModel nhanVien_model;
	private JButton btn_them;
	private JButton btn_xoaRong;
	private JButton btn_sua;
	private JButton btn_xoa;
	private JButton btn_luu;
	private NhanVien_Collection dsNV;
	public NhanVien_UI() {
		// TODO Auto-generated constructor stub
		dsNV = new NhanVien_Collection();
		this.setTitle("Nhan vien");
		this.setSize(700,700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
		Font font = new Font("Arial", Font.BOLD, 20);
		//panel header
		JPanel jp_header = new JPanel();
		
		JPanel jp_title = new JPanel();
		JLabel jl_title = new JLabel("THONG TIN NHAN VIEN");
		jl_title.setFont(font);
		jl_title.setForeground(Color.BLUE);
		
		
		JLabel jl_ma = new JLabel("Ma nhan vien: ");
		JLabel jl_hoTen = new JLabel("Ho ten: ");
		JLabel jl_tuoi = new JLabel("Tuoi: ");
		JLabel jl_phai = new JLabel("Phai: ");
		JLabel jl_luong = new JLabel("Tien luong: ");
		
		jtf_ma = new JTextField();
		jtf_hoTen = new JTextField();
		jtf_tuoi = new JTextField();
		ck_phai = new JCheckBox("Nam");
		jtf_luong = new JTextField();
		
		jl_hoTen.setPreferredSize(jl_ma.getPreferredSize());
		jl_tuoi.setPreferredSize(jl_ma.getPreferredSize());
		jl_phai.setPreferredSize(jl_ma.getPreferredSize());
		jl_luong.setPreferredSize(jl_ma.getPreferredSize());
		
		Box b, b1, b2, b3, b4;
		b = Box.createVerticalBox();
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox();
		b4 = Box.createHorizontalBox();
		
		b1.add(jl_ma);
		b1.add(jtf_ma);
		
		b2.add(jl_hoTen);
		b2.add(jtf_hoTen);
		
		b3.add(jl_tuoi);
		b3.add(jtf_tuoi);
		b3.add(jl_phai);
		b3.add(ck_phai);
		
		b4.add(jl_luong);
		b4.add(jtf_luong);
		
		
		b.add(b1);
		b.add(b2);
		b.add(b3);
		b.add(b4);
		
		
		jp_title.add(jl_title, CENTER_ALIGNMENT);
		jp_header.setLayout(new BorderLayout());
		jp_header.add(jp_title, BorderLayout.NORTH);
		jp_header.add(b, BorderLayout.CENTER);
		
		//panel body
		JPanel jp_body = new JPanel();
		
		String[] name_cols = {"Ma NV", "Ho ten", "Tuoi", "Phai", "Luong"};
		nhanVien_model = new DefaultTableModel(name_cols, 0);
		nhanVien_table = new JTable(nhanVien_model);
		JScrollPane js_table = new JScrollPane(nhanVien_table);
		
		jp_body.setLayout(new BorderLayout());
		jp_body.add(js_table, BorderLayout.CENTER);
		
		//panel footer
		JPanel jp_footer = new JPanel();
		btn_them = new JButton("Them");
		btn_xoaRong =new JButton("Xoa rong");
		btn_xoa = new JButton("Xoa");
		btn_sua = new JButton("Sua");
		btn_luu = new JButton("Luu");
		
		jp_footer.add(btn_them);
		jp_footer.add(btn_xoaRong);
		jp_footer.add(btn_xoa);
		jp_footer.add(btn_sua);
		jp_footer.add(btn_luu);
		
		//add event
		btn_them.addActionListener(this);
		btn_xoaRong.addActionListener(this);
		btn_xoa.addActionListener(this);
		btn_luu.addActionListener(this);
		btn_sua.addActionListener(this);
		nhanVien_table.addMouseListener(this);
		
		//doc file
		LuuTru l = new LuuTru();
		try {
			dsNV = (NhanVien_Collection) l.docFile("data/nhanvien.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			showMessage("Khong tim thay file");
			e.printStackTrace();
		}
		readDataFromCollToTable();
		//add to screen
		this.setLayout(new BorderLayout());
		this.add(jp_header, BorderLayout.NORTH);
		this.add(jp_body, BorderLayout.CENTER);
		this.add(jp_footer, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	private void readDataFromCollToTable() {
		// TODO Auto-generated method stub
		for (int i = 0; i < dsNV.getSize(); i++) {
			NhanVien nv = dsNV.getElement(i);
			nhanVien_model.addRow(new Object[] {nv.getMa(), nv.getHoTen(), nv.getTuoi(), nv.isPhai()==true?"nam":"nu", nv.getLuong()});
		}
		
	}
	public static void main(String[] args) {
		new NhanVien_UI();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = nhanVien_table.getSelectedRow();
		
		jtf_ma.setEditable(false);
		jtf_ma.setText(nhanVien_model.getValueAt(row, 0).toString());
		jtf_hoTen.setText(nhanVien_model.getValueAt(row, 1).toString());
		jtf_tuoi.setText(nhanVien_model.getValueAt(row, 2).toString());
		ck_phai.setSelected(nhanVien_model.getValueAt(row, 3)=="nam"?true:false);
		jtf_luong.setText(nhanVien_model.getValueAt(row, 4).toString());
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		if (src.equals(btn_xoaRong)) {
			clearData();
		}else if (src.equals(btn_them)) {
			if (validData()) {
				updateTable();
			}
		}else if (src.equals(btn_xoa)) {
			deleteRow();
		}else if (src.equals(btn_luu)) {
			luuFile();
		}else if (src.equals(btn_sua)) {
			if (validData()) {
				suaThongTin();
			}
		}
	}
	private void suaThongTin() {
		// TODO Auto-generated method stub
		int selectedRow = nhanVien_table.getSelectedRow();
		
		try {
			String ma = jtf_ma.getText().trim();
			String hoTen = jtf_hoTen.getText().trim();
			int tuoi = Integer.parseInt(jtf_tuoi.getText());
			boolean phai = ck_phai.isSelected();
			double luong =Double.parseDouble( jtf_luong.getText());
			
			NhanVien nv = new NhanVien(ma, hoTen, tuoi, phai, luong);
			
			dsNV.sua(selectedRow, nv);
			
			nhanVien_model.setValueAt(nv.getHoTen(), selectedRow, 1);
			nhanVien_model.setValueAt(nv.getTuoi(), selectedRow, 2);
			nhanVien_model.setValueAt(nv.isPhai()==true?"nam":"nu", selectedRow, 3);
			nhanVien_model.setValueAt(nv.getLuong(), selectedRow, 4);
			
			showMessage("Sua thanh cong");
		} catch (Exception e) {
			// TODO: handle exception
			showMessage("Sua khong thanh cong");
			e.printStackTrace();
		}
	}
	private void luuFile() {
		// TODO Auto-generated method stub
		LuuTru l = new LuuTru();
		try {
			l.luuFile(dsNV, "data/nhanvien.txt");
			showMessage("Luu thanh cong");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private void deleteRow() {
		// TODO Auto-generated method stub
		if (nhanVien_table.getSelectedRow() == -1) {
			showMessage("Phai chon dong xoa");
		}else {
			if (JOptionPane.showConfirmDialog(this, "Co chac xoa dong nay khong", "Canh bao", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				NhanVien nv = dsNV.getElement(nhanVien_table.getSelectedRow());
				dsNV.xoaTheoMa(nv.getMa());
				nhanVien_model.removeRow(nhanVien_table.getSelectedRow());
			}
		}
		
	}
	private void updateTable() {
		// TODO Auto-generated method stub
		String ma = jtf_ma.getText();
		String hoTen = jtf_hoTen.getText();
		int tuoi = Integer.parseInt(jtf_tuoi.getText());
		boolean phai = ck_phai.isSelected();
		double luong = Double.parseDouble(jtf_luong.getText());
		
		NhanVien nv = new NhanVien(ma, hoTen, tuoi, phai, luong);
		if (!dsNV.them(nv)) {
			showMessage("Ma khong trung");
		}else {
			showMessage("Them thanh cong");
			nhanVien_model.addRow(new Object[] {nv.getMa(), nv.getHoTen(), nv.getTuoi(),nv.isPhai()==true?"nam":"nu",
					nv.getLuong()});
		}
		
	}
	private void showMessage(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, string);
	}
	private boolean validData() {
		// TODO Auto-generated method stub
		String ma = jtf_ma.getText().trim();
		String hoTen = jtf_hoTen.getText().trim();
		String tuoi = jtf_tuoi.getText().trim();
		String luong = jtf_luong.getText().trim();
		
		//check ma
		if (ma.length() > 0) {
			if (!(ma.matches("[A-Z][0-9]{6}"))) {
				showMessage("Ma sai dinh dang!");
				return false;
			}
		}else {
			showMessage("Ma khong duoc de trong");
			return false;
		}
		//check ho ten
		if (hoTen.length() > 0) {
			if (!(hoTen.matches("[a-zA-Z ]+"))) {
				showMessage("Ho ten khong dung dinh dang");
				return false;
			}
		}else {
			showMessage("Ho ten khong duoc de trong");
			return false;
		}
		//check tuoi
		if (tuoi.length() > 0) {
			try {
				int sTuoi = Integer.parseInt(tuoi);
				if (!(sTuoi > 16)) {
					showMessage("Phai tu 16 tuoi tro len");
					return false;
				}
			} catch (Exception e) {
				// TODO: handle exception
				showMessage("Phai nhap so");
				return false;
			}
		}else {
			showMessage("Tuoi kh de trong");
			return false;
		}
		//check luong
		if (luong.length() > 0) {
			try {
				double sLuong = Double.parseDouble(luong);
				if (!(sLuong > 0)) {
					showMessage("Luong phai lon hon 0");
					return false;
				}
			} catch (Exception e) {
				// TODO: handle exception
				showMessage("Luong nhap so");
				return false;
			}
		}else {
			showMessage("Luong kh de trong");
			return false;
		}
			
		return true;
	}
	private void clearData() {
		// TODO Auto-generated method stub
		jtf_ma.setText("");
		jtf_hoTen.setText("");
		jtf_tuoi.setText("");
		ck_phai.setSelected(false);
		jtf_luong.setText("");
		
		jtf_ma.requestFocus();
	}
}

