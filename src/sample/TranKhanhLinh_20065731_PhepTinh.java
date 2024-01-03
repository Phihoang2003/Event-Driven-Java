package sample;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TranKhanhLinh_20065731_PhepTinh extends JFrame implements ActionListener{
	private JLabel lblTieuDe;
	private JButton btnGiai;
	private JButton btnXoa;
	private JButton btnThoat;
	private JTextField txtNhapa;
	private JTextField txtNhapb;
	private JRadioButton radCong;
	private JRadioButton radTru;
	private JRadioButton radNhan;
	private JRadioButton radChia;
	private JTextField txtKetQua;
	public TranKhanhLinh_20065731_PhepTinh()
	{
		setTitle("Cộng - Trừ - Nhân - Chia");
		setSize(550,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		//
		setLayout(new BorderLayout());
		JPanel pns = new JPanel();
		JPanel pnc = new JPanel();
		JPanel pnn = new JPanel();
		JPanel pnw = new JPanel();
		this.add(pns,BorderLayout.SOUTH);
		this.add(pnn,BorderLayout.NORTH);
		this.add(pnc,BorderLayout.CENTER);
		this.add(pnw,BorderLayout.WEST);
		// north
		lblTieuDe = new JLabel("Cộng Trừ Nhân Chia");
		lblTieuDe.setFont(new Font(null,Font.BOLD,30));
		lblTieuDe.setForeground(Color.BLUE);
		pnn.add(lblTieuDe);
		// west
		pnw.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		pnw.setLayout(new BoxLayout(pnw,BoxLayout.Y_AXIS));
		pnw.setPreferredSize(new Dimension(100,20));
		btnGiai =new JButton("Giải");
		btnXoa =new JButton("Xóa");
		btnThoat =new JButton("Thoát");
		pnw.add(btnGiai);
		pnw.add(Box.createRigidArea(new Dimension(10,10)));
		pnw.add(btnXoa);
		pnw.add(Box.createRigidArea(new Dimension(10,10)));
		pnw.add(btnThoat);
		//center
		pnc.setBorder(BorderFactory.createTitledBorder(null,"Tính toán"));
		pnc.add(new JLabel("Nhập a:"));
		txtNhapa = new JTextField(35);
		pnc.add(txtNhapa);
		pnc.add(new JLabel("Nhập b:"));
		txtNhapb = new JTextField(35);
		pnc.add(txtNhapb);
		JPanel pnc1 = new JPanel();
		pnc.add(pnc1);
		pnc1.setBorder(BorderFactory.createTitledBorder(null,"Phép toán"));
		pnc1.setPreferredSize(new Dimension(380,150));
		pnc1.setLayout(new GridLayout(2,2));
		radCong = new JRadioButton("Cộng");
		pnc1.add(radCong);
		radCong.setSelected(true);
		radTru = new JRadioButton("Trừ");
		pnc1.add(radTru);
		radNhan = new JRadioButton("Nhân");
		pnc1.add(radNhan);
		radChia = new JRadioButton("Chia");
		pnc1.add(radChia);
		ButtonGroup group = new ButtonGroup();
		group.add(radCong);
		group.add(radTru);
		group.add(radNhan);
		group.add(radChia);
		pnc.add(new JLabel("Kết quả:"));
		txtKetQua = new JTextField(35);
		pnc.add(txtKetQua);
		txtKetQua.setEditable(false);
		//south
		pns.setBackground(Color.pink);
		JPanel pns1 = new JPanel();
		pns1.setPreferredSize(new Dimension(40,40));
		pns1.setBackground(Color.blue);
		JPanel pns2 = new JPanel();
		pns2.setPreferredSize(new Dimension(40,40));
		pns2.setBackground(Color.red);
		JPanel pns3 = new JPanel();
		pns3.setPreferredSize(new Dimension(40,40));
		pns3.setBackground(Color.yellow);
		pns.add(pns1);
		pns.add(pns2);
		pns.add(pns3);
		// action
		btnGiai.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
		radCong.addActionListener(this);
		radTru.addActionListener(this);
		radNhan.addActionListener(this);
		radChia.addActionListener(this);
		
	}
	public static void main(String[] args) {
		new TranKhanhLinh_20065731_PhepTinh().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o =e.getSource();
		if(!isInt(txtNhapa))
		{
			focus(txtNhapa);
		}else if(!isInt(txtNhapb))
		{
			focus(txtNhapb);
		}else if(o.equals(btnXoa))
		{
			txtNhapa.setText("");
			txtNhapb.setText("");
			txtKetQua.setText("");
		}else if(o.equals(btnThoat))
		{
			System.exit(EXIT_ON_CLOSE);
		}else if(o.equals(btnGiai))
		{
			int a = Integer.parseInt(txtNhapa.getText());
			int b = Integer.parseInt(txtNhapb.getText());
			if(radCong.isSelected())
			{
				
				txtKetQua.setText((a+b)+"");
			}
			if(radTru.isSelected())
			{
				txtKetQua.setText((a-b)+"");
			}
			if(radNhan.isSelected())
			{
				txtKetQua.setText((a*b)+"");
			}
			if(radChia.isSelected())
			{
				if(b!=0)
				{
					float c = (float)a/(float)b;
					String kq= String.format("%.2f", c);
					txtKetQua.setText(kq);
				}else
				{
					JOptionPane.showMessageDialog(null, "Giá trị không hợp lệ");
					txtNhapb.selectAll();
					txtNhapb.requestFocus();
				}
			}
		}
	}
	public boolean isInt(JTextField t)
	{
		try {
			Integer.parseInt(t.getText());
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	public void focus(JTextField t)
	{
		JOptionPane.showMessageDialog(null, "Nhập số !");
		t.selectAll();
		t.requestFocus();
	}
}
