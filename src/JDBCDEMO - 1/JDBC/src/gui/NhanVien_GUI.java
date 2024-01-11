package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.NhanVien_Dao;
import dao.PhongBan_Dao;
import entity.NhanVien;
import entity.PhongBan;

public class NhanVien_GUI extends JFrame implements ActionListener,MouseListener {
	private JLabel lblTieuDe;
	private JLabel lblMaNV;
	private JTextField txtMaNV;
	private JLabel lblHo;
	private JTextField txtHo;
	private JLabel lblTen;
	private JTextField txtTen;
	private JLabel lblTuoi;
	private JTextField txtTuoi;
	private JLabel lblPhai;
	private JCheckBox chkNu;
	private PhongBan_Dao pb_dao;
	private JLabel lblTienLuong;
	private JTextField txtTienLuong;
	private JLabel lblPhongBan;
	private JComboBox<String> cboPhongBan;
	private DefaultTableModel modelNhanVien;
	private JTable tableNhanVien;
	private JPanel p;
	private JPanel pLeft;
	private JPanel pRight;
	private JLabel lblTim;
	private JTextField txtTim;
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnXoaTrang;
	private JButton btnXoa;
	private JButton btnLuu;
	private NhanVien_Dao nv_dao;
	public NhanVien_GUI() {
		try {
			ConnectDB.getInstance().connect();
			System.out.println("Ket noi thanh cong");
		} catch (Exception e) {
			System.out.println("Ket noi that bai");
			e.printStackTrace();
			// TODO: handle exception
		}
		pb_dao=new PhongBan_Dao();
		nv_dao=new NhanVien_Dao();
		setTitle("QUAN LI NHAN VIEN");
		setSize(800,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		lblTieuDe=new JLabel("THONG TIN NHAN VIEN");
		lblTieuDe.setFont(new Font("Arial",Font.BOLD,20));
		lblTieuDe.setForeground(Color.BLUE);
		Box b=Box.createVerticalBox();
		Box bl1,b1,b2,b3,b4;
		
		b.add(bl1=Box.createHorizontalBox());
		bl1.add(lblTieuDe);
		b.add(b1=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblMaNV=new JLabel("Ma Nhan Vien:   "));
		b1.add(txtMaNV=new JTextField());
		
		b.add(b2=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblHo=new JLabel("Ho:  "));
		b2.add(txtHo=new JTextField());
		b2.add(lblTen=new JLabel("Ten Nhan Vien:   "));
		b2.add(txtTen=new JTextField());
		b.add(b3=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lblTuoi=new JLabel("Tuoi:  "));
		b3.add(txtTuoi=new JTextField());
		b3.add(lblPhai=new JLabel("Phai: "));
		b3.add(chkNu=new JCheckBox("Nu"));
		b.add(b4=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(lblTienLuong=new JLabel("Tien Luong: "));
		b4.add(txtTienLuong=new JTextField());
		b4.add(lblPhongBan=new JLabel("Phong Ban: "));
		b4.add(cboPhongBan=new JComboBox<String>());
		cboPhongBan.setEditable(true);
		ArrayList<PhongBan> listPB=pb_dao.getAllPhongBan();
		for(PhongBan pb:listPB) {
			cboPhongBan.addItem(pb.getMaPhong());
		}
		lblHo.setPreferredSize(lblMaNV.getPreferredSize());
		lblTuoi.setPreferredSize(lblMaNV.getPreferredSize());
		lblPhai.setPreferredSize(lblMaNV.getPreferredSize());
		lblTienLuong.setPreferredSize(lblMaNV.getPreferredSize());
		
		cboPhongBan.setPreferredSize(lblMaNV.getPreferredSize());
		b.add(Box.createHorizontalStrut(10));
		
		String[] colHeader= {"Ma NV","Ho NV","Ten","Tuoi","Phai","Luong","Phong Ban"};
		modelNhanVien=new DefaultTableModel(colHeader,0);
		tableNhanVien=new JTable(modelNhanVien);
		add(new JScrollPane(tableNhanVien),BorderLayout.CENTER);
		add(b,BorderLayout.NORTH);
		docDuLieuTuDatabaseVaoTable();
		p=new JPanel();
		add(p,BorderLayout.SOUTH);
		p.add(pLeft=new JPanel());
		p.add(pRight=new JPanel());
		pLeft.add(lblTim=new JLabel("Nhap ma so can tim:  "));
		pLeft.add(txtTim=new JTextField(10));
		pLeft.add(btnTim=new JButton("Tim"));
		pRight.add(btnThem = new JButton("Thêm"));
		pRight.add(btnXoaTrang = new JButton("Xóa trắng"));
		pRight.add(btnXoa = new JButton("Xóa"));
		pRight.add(btnLuu = new JButton("Loc theo Ph Ban"));
		btnLuu.addActionListener(this);
		btnThem.addActionListener(this);
		btnTim.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		tableNhanVien.addMouseListener(this);
		
	}
	
	private void docDuLieuTuDatabaseVaoTable() {
		List<NhanVien> dsNV=nv_dao.getAllNhanVien();
		for(NhanVien nv:dsNV) {
			modelNhanVien.addRow(new Object[] {
					nv.getMaNV(),nv.getHo(),nv.getTen(),nv.getTuoi(),nv.isPhai()?"Nu":"Nam",nv.getLuong(),
							nv.getPhong().getMaPhong()
			});
		}
	}
	public static void main(String[] args) {
		new NhanVien_GUI().setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o==btnThem) {
			them();
		}
	}
	private void them() {
		try {
			String ma=txtMaNV.getText().trim();
			String ho=txtHo.getText().trim();
			String ten=txtTen.getText().trim();
			int tuoi=Integer.parseInt(txtTuoi.getText().trim());
			boolean phai=chkNu.isSelected();
			PhongBan pb=new PhongBan(cboPhongBan.getSelectedItem().toString());
			double luong=Double.parseDouble(txtTienLuong.getText().trim());
			NhanVien nv=new NhanVien(ma, ho, ten, tuoi, phai, pb, luong);
			if(nv_dao.them(nv)) {
				modelNhanVien.addRow(new Object[] {
						nv.getMaNV(),nv.getHo(),nv.getTen(),nv.getTuoi(),nv.isPhai()?"Nu":"Nam",nv.getLuong(),
								nv.getPhong().getMaPhong()
				});
			}
					
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Trùng mã");
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
