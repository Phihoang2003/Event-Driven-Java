package sample;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TranKhanhLinh_20065731_PTB2 extends JFrame implements ActionListener {
	private JPanel pnn;
	private JPanel pns;
	private JPanel pnc;
	private JLabel lblTitle;
	private JButton btnGiai;
	private JButton btnXoaRong;
	private JButton btnThoat;
	private JLabel lblNhapa;
	private JLabel lblNhapb;
	private JLabel lblNhapc;
	private JLabel lblKetQua;
	private JTextField txtNhapb;
	private JTextField txtNhapc;
	private JTextField txtNhapa;
	private JTextField txtKetQua;
	public TranKhanhLinh_20065731_PTB2() {
		setTitle("giải phương trình bậc 2");
		setSize(550,450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//
		pnn = new JPanel();
		add(BorderLayout.NORTH,pnn);
		pnn.setBackground(Color.GREEN);
		lblTitle = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI");
		pnn.add(lblTitle);
		lblTitle.setFont(new Font(null,Font.PLAIN,18));
		//
		pnc = new JPanel();
		add(BorderLayout.CENTER,pnc);
		pnc.setLayout(new BoxLayout(pnc, BoxLayout.Y_AXIS));
		JPanel pnc1 = new JPanel();
		JPanel pnc2= new JPanel();
		JPanel pnc3 = new JPanel();
		JPanel pnc4 = new JPanel();
		pnc.add(Box.createRigidArea(new Dimension(10,30)));
		pnc.add(pnc1);
		pnc.add(Box.createRigidArea(new Dimension(10,30)));
		pnc.add(pnc2);
		pnc.add(Box.createRigidArea(new Dimension(10,30)));
		pnc.add(pnc3);
		pnc.add(Box.createRigidArea(new Dimension(10,30)));
		pnc.add(pnc4);
		pnc.add(Box.createRigidArea(new Dimension(10,30)));
		pnc1.setLayout(new BoxLayout(pnc1,BoxLayout.X_AXIS));
		pnc2.setLayout(new BoxLayout(pnc2,BoxLayout.X_AXIS));
		pnc3.setLayout(new BoxLayout(pnc3,BoxLayout.X_AXIS));
		pnc4.setLayout(new BoxLayout(pnc4,BoxLayout.X_AXIS));
		lblNhapa = new JLabel("Nhập a:");
		txtNhapa = new JTextField(20);
		pnc1.add(lblNhapa);
		pnc1.add(txtNhapa);
		lblNhapb = new JLabel("Nhập b:");
		txtNhapb = new JTextField(20);
		pnc2.add(lblNhapb);
		pnc2.add(txtNhapb);
		lblNhapc = new JLabel("Nhập c:");
		txtNhapc = new JTextField(20);
		pnc3.add(lblNhapc);
		pnc3.add(txtNhapc);
		lblKetQua = new JLabel("Ket Qua");
		txtKetQua = new JTextField(20);
		txtKetQua.setEditable(false);
		pnc4.add(lblKetQua);
		pnc4.add(txtKetQua);
		
		
		
	
		//
		pns = new JPanel();
		add(BorderLayout.SOUTH,pns);
		pns.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		btnGiai = new JButton("Giải");
		pns.add(btnGiai);
		btnXoaRong = new JButton("Xóa rỗng");
		pns.add(btnXoaRong);
		btnThoat = new JButton("Thoát");
		pns.add(btnThoat);
		
		//
		btnGiai.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnThoat.addActionListener(this);
	}
	//
	public static void main(String[] args) {
		new TranKhanhLinh_20065731_PTB2().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThoat))
			System.exit(0);
		else if(o.equals(btnXoaRong))
		{
			txtNhapa.setText("");
			txtNhapb.setText("");
			txtNhapc.setText("");
			txtKetQua.setText("");
		}else
		{
			if(!isInt(txtNhapa))
			{
				focus(txtNhapa);
			}else if(!isInt(txtNhapb))
			{
				focus(txtNhapb);
			}else if(!isInt(txtNhapc))
			{
				focus(txtNhapc);
			}else
			{
				float a = Integer.parseInt(txtNhapa.getText());
				float b = Integer.parseInt(txtNhapb.getText());
				float c = Integer.parseInt(txtNhapc.getText());
				if (a == 0) {
		            if (b == 0) {
		            	txtKetQua.setText("Phương trình vô nghiệm!");
		            } else {
		            	txtKetQua.setText("x= "+(-c / b)+"");
		            }
		            return;
		        }
				// tính delta
		        float delta = b*b - 4*a*c;
		        float x1;
		        float x2;
		        // tính nghiệm
		        if (delta > 0) {
		            x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
		            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
		            txtKetQua.setText("x1 = " + x1 + " và x2 = " + x2);
		        } else if (delta == 0) {
		            x1 = (-b / (2 * a));
		            txtKetQua.setText("x1 = x2 = " + x1);
		        } else {
		        	txtKetQua.setText("Phương trình vô nghiệm!");
		        }
		    }
		}
	}	
	public boolean isInt(JTextField text)
	{
		try {
			Integer.parseInt(text.getText());
			
		}catch (NumberFormatException e)
		{
			return false;
		}
		return true;
	}
	public void focus(JTextField t)
	{
		JOptionPane.showMessageDialog(null,"Nhập số nguyên");
		t.selectAll();
		t.requestFocus();
	}
}
