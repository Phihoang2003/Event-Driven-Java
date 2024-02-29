package test1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class NhanVien_UI extends JFrame implements ActionListener,MouseListener {
	private JPanel jp_header;
	private JLabel jl_title;
	private JPanel jp_title;
	private JLabel jl_hoTen;
	private JLabel jl_ma;
	private JLabel jl_tuoi;
	private JLabel jl_phai;
	private JLabel jl_luong;
	private JTextField jtf_ma;
	private JTextField jtf_hoTen;
	private JTextField jtf_tuoi;
	private JCheckBox ck_phai;
	private JTextField jtf_luong;
	private JPanel jp_body;
	private DefaultTableModel nhanVien_model;
	private JTable nhanVien_table;
	private JScrollPane js_table;
	private JButton btn_them;
	private JButton btn_xoaRong;
	private JButton btn_xoa;
	private JButton btn_sua;
	private JButton btn_luu;

	public NhanVien_UI() {
		this.setTitle("THÔNG TIN NHÂN VIÊN");
		this.setSize(700,700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		Font font=new Font("Arial",Font.BOLD,20);
		jp_header = new JPanel();
		jp_title=new JPanel();
		jl_title=new JLabel("THÔNG TIN NHÂN VIÊN");
		jl_title.setFont(font);
		jl_title.setForeground(Color.BLUE);
		
		jl_ma=new JLabel("Ma Nhan Vien: ");
		jl_hoTen=new JLabel("Ho Ten: ");
		jl_tuoi=new JLabel("Tuoi: ");
		jl_phai=new JLabel("Phai: ");
		jl_luong=new JLabel("Luong: ");
		
		jtf_ma=new JTextField();
		jtf_hoTen=new JTextField();
		jtf_tuoi=new JTextField();
		ck_phai=new JCheckBox();
		jtf_luong=new JTextField();
		
		jl_hoTen.setPreferredSize(jl_ma.getPreferredSize());
		jl_tuoi.setPreferredSize(jl_ma.getPreferredSize());
		jl_phai.setPreferredSize(jl_ma.getPreferredSize());
		jl_luong.setPreferredSize(jl_ma.getPreferredSize());
		
		Box b,b1,b2,b3,b4;
		b=Box.createVerticalBox();
		b1=Box.createHorizontalBox();
		b2=Box.createHorizontalBox();
		b3=Box.createHorizontalBox();
		b4=Box.createHorizontalBox();
		
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
		b.add(Box.createVerticalStrut(10));
		b.add(b2);
		b.add(Box.createVerticalStrut(10));
		b.add(b3);
		b.add(Box.createVerticalStrut(10));
		b.add(b4);
		b.add(Box.createVerticalStrut(10));
		
		jp_title.add(jl_title,CENTER_ALIGNMENT);
		jp_header.setLayout(new BorderLayout());
		jp_header.add(jp_title,BorderLayout.NORTH);
		jp_header.add(b,BorderLayout.CENTER);
		
		jp_body=new JPanel();
		String[] name_cols= {"Ma NV","Ho Ten","Tuoi","Phai","Luong"};
		nhanVien_model=new DefaultTableModel(name_cols,0);
		nhanVien_table=new JTable(nhanVien_model);
		js_table=new JScrollPane(nhanVien_table);
		jp_body.setLayout(new BorderLayout());
		jp_body.add(js_table,BorderLayout.CENTER);
		
		JPanel jp_footer = new JPanel();
		btn_them=new JButton("Them");
		btn_xoaRong=new JButton("Xoa Rong");
		btn_xoa=new JButton("Xoa");
		btn_sua=new JButton("Sua");
		btn_luu=new JButton("Luu");
		jp_footer.add(btn_them);
		jp_footer.add(btn_xoaRong);
		jp_footer.add(btn_xoa);
		jp_footer.add(btn_sua);
		jp_footer.add(btn_luu);
		
		btn_them.addActionListener(this);
		btn_xoaRong.addActionListener(this);
		btn_xoa.addActionListener(this);
		btn_sua.addActionListener(this);
		btn_luu.addActionListener(this);
		nhanVien_table.addMouseListener(this);
		
		this.setLayout(new BorderLayout());
		this.add(jp_header,BorderLayout.NORTH);
		this.add(jp_body,BorderLayout.CENTER);
		this.add(jp_footer,BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new NhanVien_UI();
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
