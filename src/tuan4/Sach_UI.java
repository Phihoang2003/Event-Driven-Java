package tuan4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventObject;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Sach_UI extends JFrame implements ActionListener,MouseListener  {
	private static final long serialVersionUID = 1L;
	private Sach_Collection dsSach;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtNXB;
	private JTextField txtSoLuong;
	private JTextField txtTim;
	private JComboBox<String> comboBox;
	private DefaultTableModel dfTB;
	private JTable tbl;
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnXoaRong;
	private JButton btnLuu;
	private JButton btnSua;
	public Sach_UI() {
		dsSach=new Sach_Collection();
		setTitle("Quan Li Sach");
		setSize(800,500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		buildUI();
	}
	private void buildUI() {
		JPanel top=new JPanel();
		top.setPreferredSize(new Dimension(0,150));
		top.setLayout(null);
		add(top,BorderLayout.NORTH);
		Font font=new Font("Arial",Font.BOLD,20);
		JLabel lblTitle,lblMa,lblTen,lblLoai,lblNXB,lblSoLuong,lblTim;
		top.add(lblTitle=new JLabel("Thong Tin Sach"));
		lblTitle.setFont(font);
		top.add(lblMa=new JLabel("Ma Sach: "));
		top.add(lblTen=new JLabel("Ten Sach: "));
		top.add(lblLoai = new JLabel("Loai Sach:"));
		top.add(lblNXB=new JLabel("Nha Xuat Ban: "));
		top.add(lblSoLuong=new JLabel("So Luong: "));
		top.add(txtMa=new JTextField());
		top.add(txtTen=new JTextField());
		top.add(txtSoLuong=new JTextField());
		top.add(txtNXB=new JTextField());
		String loai[]="Tin Hoc;Toan".split(";");
		comboBox=new JComboBox<String>(loai);
		top.add(comboBox);
		int y=10,w1=100,h=20;
		lblTitle.setBounds(320,y,400,h);
		lblMa.setBounds(20,y+=30,w1,h);
		txtMa.setBounds(120,y,w1,h);
		lblTen.setBounds(20,y+=25,w1,h);
		txtTen.setBounds(120,y,300,h);
		lblSoLuong.setBounds(450,y,w1,h);
		txtSoLuong.setBounds(550,y,170,h);
		lblLoai.setBounds(20,y+=25,w1,h);
		comboBox.setBounds(120,y,100,h);
		lblNXB.setBounds(250,y,w1,h);
		txtNXB.setBounds(350,y,370,h);
		
		//table
		String header[]="Ma Sach;Ten Sach;So Luong;Loai Sach;Nha Xuat Ban".split(";");
		dfTB=new DefaultTableModel(header,0);
		tbl=new JTable(dfTB);
		JScrollPane croll=new JScrollPane(tbl);
		add(croll);
		//bot
		JPanel bot=new JPanel();
		add(bot,BorderLayout.SOUTH);
		bot.add(lblTim=new JLabel("Tim Kiem Theo Ma"));
		bot.add(txtTim=new JTextField(20));
		bot.add(btnTim=new JButton("Tim"));
		bot.add(btnThem = new JButton("Them"));
		bot.add(btnXoa = new JButton("Xoa"));
		bot.add(btnXoaRong = new JButton("Xoa rong"));
		bot.add(btnSua=new JButton("Sua"));
		bot.add(btnLuu = new JButton("Luu"));
		btnTim.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		tbl.addMouseListener(this);
		try {
			dsSach=(Sach_Collection)LuuTru.read("data/DanhSachSach.txt");
			updateTable();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Khong tim thay file");
			e.getStackTrace();
		}
		setCellEditTable();
	}
//	public void setCellEditTable() {
//		for(int i=0;i<tbl.getColumnCount();i++) {
//			tbl.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(new JTextField()) {
//				public boolean isCellEditable(EventObject e) {
//					return false;
//				}
//			});
//		}
//	}
	
	public void setCellEditTable() {
	    // Áp dụng NonEditableCellEditor cho cột "Mã Sach"
	    tbl.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JTextField()) {
	    	public boolean isCellEditable(EventObject e) {
				return false;
			}
	    });

	    // Các dòng khác giữ nguyên CellEditor mặc định
	    for(int i=1; i<tbl.getColumnCount(); i++) {
	        tbl.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(new JTextField()));
	    }
	}
	//write data to table


	private void updateTable() {
		for(int i=0;i<dfTB.getRowCount();i++) {
			dfTB.removeRow(i);
		}
		for(int i=0;i<dsSach.getSize();i++) {
			Sach s=dsSach.getSach(i);
			dfTB.addRow(new Object[] {s.getMa(),s.getTen(),s.getSoLuong(),s.getLoai(),s.getNxb()});
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o==btnTim) {
			if(txtTim.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Hay nhap ma muon tim.!!");
			}
			tim();
		}
		if(o==btnThem) {
			if(validDate()) {
				them();
			}
		}
		if(o==btnXoa) {
			if(tbl.getSelectedRow()==-1) {
				JOptionPane.showMessageDialog(this, "Hay chon dong muon xoa!!");
			}
			else {
				if(xoa()) {
					JOptionPane.showMessageDialog(this, "Xoa thanh cong");
				}
			}
		}
		if(o==btnXoaRong) {
			xoaRong();
		}
		if(o==btnLuu) {
			try {
				if(LuuTru.save(dsSach, "data/DanhSachSach.txt")) {
					JOptionPane.showMessageDialog(this, "Luu thanh cong!!");
				}
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Luu that bai!!");
				e2.printStackTrace();
			}
		}
		if(o==btnSua) {
			sua();
		}
	}
	private void xoaRong() {
		txtMa.setText("");
		txtTen.setText("");
		txtSoLuong.setText("");
		txtNXB.setText("");
		txtMa.requestFocus();
	}

	private void sua() {
		int i = tbl.getSelectedRow();
		try {
			int ma = Integer.parseInt(txtMa.getText().trim());
			String ten = txtTen.getText().trim();
			int soLuong = Integer.parseInt(txtSoLuong.getText().trim());
			String loai = comboBox.getSelectedItem().toString();
			System.out.println(loai);
			String nhaXB = txtNXB.getText().trim();
			Sach sach = new Sach(ma,ten,soLuong,loai,nhaXB);

			
//			if (!validDate())
//				return;
			dsSach.sua(i, sach);
			dfTB.setValueAt(sach.getMa(), i, 0);
			dfTB.setValueAt(sach.getTen(), i, 1);
			dfTB.setValueAt(sach.getSoLuong(), i, 2);
			dfTB.setValueAt(sach.getLoai(), i, 3);
			dfTB.setValueAt(sach.getNxb(), i, 4);
			 LuuTru.save(dsSach, "data/DanhSachSach.txt");
//			tbl.setRowSelectionInterval(i, i);
			JOptionPane.showMessageDialog(this, "Sửa thành công");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(this, "Sửa không thành công");
		}
	}
	private boolean xoa() {
		int i=tbl.getSelectedRow();
		if(dsSach.xoa(i)) {
			dfTB.removeRow(i);
			return true;
		}
		JOptionPane.showMessageDialog(this, "Xoa khong thanh cong !!");
		
		return false;
	}
	private void them() {
		try {
			int ma=Integer.parseInt(txtMa.getText().trim());
			String ten=txtTen.getText();
			int soLuong=Integer.parseInt(txtSoLuong.getText().trim());
			String loai=comboBox.getSelectedItem().toString();
			String nxb=txtNXB.getText().trim();
			Sach s=new Sach(ma,ten,soLuong,loai,nxb);
			if(dsSach.them(s)) {
				dfTB.addRow(new Object[] {ma,ten,soLuong,loai,nxb});
			}else {
				JOptionPane.showMessageDialog(this,"Trung ma!!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private boolean validDate() {
		String ma = txtMa.getText().trim();
		String ten = txtTen.getText().trim();
		String soLuong = txtSoLuong.getText().trim();
		String nxb = txtNXB.getText().trim();
		if(ma.length()==0) {
			JOptionPane.showMessageDialog(this, "Ma khong duoc rong");
			return false;
		}
		if(ten.length()==0) {
			JOptionPane.showMessageDialog(this, "Ten khong duoc rong");
			return false;
		}
		if(soLuong.length()==0) {
			JOptionPane.showMessageDialog(this, "So luong khong duoc rong");
			return false;
		}
		if(nxb.length()==0) {
			JOptionPane.showMessageDialog(this, "Nha xuat ban khong duoc rong");
			return false;
		}
		if(!ma.matches("\\d+")) {
			JOptionPane.showMessageDialog(this, "Ma phai la so");
			return false;
		}
		if(!soLuong.matches("(0?[1-9])|([1-9]\\d*)")) {
			JOptionPane.showMessageDialog(this, "Soluong phai la so");
			return false;
		}
		return true;
	}
	private void tim() {
		try {
			int ma=Integer.parseInt(txtTim.getText().trim());
			Sach s=dsSach.tim(ma);
			
			if(s==null) {
				JOptionPane.showMessageDialog(this, "Khong tim thay sach");
				return;
			}
			else {
				for(int i=0;i<dsSach.getSize();i++) {
					if(dsSach.getSach(i).getMa()==s.getMa()) {
						tbl.setRowSelectionInterval(i, i);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Khong tim thay");
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		fillForm();
	}
	private void fillForm() {
		int i = tbl.getSelectedRow();
		txtMa.setEditable(false);
		txtMa.setText(dfTB.getValueAt(i, 0).toString());
		txtTen.setText(dfTB.getValueAt(i, 1).toString());
		txtSoLuong.setText(dfTB.getValueAt(i, 2).toString());
		comboBox.setSelectedItem(dfTB.getValueAt(i, 3));
		txtNXB.setText(dfTB.getValueAt(i, 4).toString());
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
	
}
