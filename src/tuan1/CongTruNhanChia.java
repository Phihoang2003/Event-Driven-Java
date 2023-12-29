package tuan1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class CongTruNhanChia extends JFrame {
	public CongTruNhanChia(String title) {
		setTitle(title);
	}
	public void doShow() {
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addControl();
		setResizable(true);
		setVisible(true);
	}
	public void addControl() {
		JPanel pnBorder=new JPanel();
		pnBorder.setLayout(new BorderLayout());
		JPanel pnNorth=new JPanel();
		JLabel lblTitle=new JLabel("Cong Tru Nhan Chia");
		pnNorth.add(lblTitle);
		pnBorder.add(pnNorth,BorderLayout.NORTH);
		lblTitle.setForeground(Color.BLUE);
		Font ft=new Font("arial",Font.BOLD,25);
		lblTitle.setFont(ft);
		JPanel pnWest = new JPanel(new BorderLayout());
		JPanel pnBtn=new JPanel();
		pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));
		JButton btnGiai=new JButton("Giai");
		pnBtn.add(btnGiai);
		pnWest.add(Box.createVerticalStrut(10));
		JButton btnXoa=new JButton("Xoa");
		pnBtn.add(btnXoa);
		pnWest.add(Box.createVerticalStrut(10));
		JButton btnThoat=new JButton("Thoat");
		pnBtn.add(btnThoat);
		pnWest.add(pnBtn,BorderLayout.CENTER);
		pnWest.add(Box.createVerticalStrut(10));
		pnWest.setBackground(Color.LIGHT_GRAY);
		Border southBorder=BorderFactory.createLineBorder(Color.RED);
		TitledBorder southTitleBorder=new TitledBorder(southBorder,"Chon Tac Vu");
		pnWest.setBorder(southTitleBorder);
		pnBorder.add(pnWest,BorderLayout.WEST);
		pnWest.setPreferredSize(new Dimension(100,0) );

	    btnGiai.setPreferredSize(btnThoat.getPreferredSize());
	    btnXoa.setPreferredSize(btnThoat.getPreferredSize());
	    
	    JPanel pnSouth=new JPanel();
	    pnSouth.setPreferredSize(new Dimension(0,30));
	    pnSouth.setBackground(Color.PINK);
	    JPanel pns1=new JPanel();
	    pns1.setBackground(Color.BLUE);
	    pnSouth.add(pns1);
	    JPanel pns2=new JPanel();
	    pns2.setBackground(Color.RED);
	    pnSouth.add(pns2);
	    JPanel pns3=new JPanel();
	    pns3.setBackground(Color.YELLOW);
	    pnSouth.add(pns3);
	    pnSouth.setAlignmentX(BOTTOM_ALIGNMENT);
	    pnBorder.add(pnSouth,BorderLayout.SOUTH);
	    JPanel pnCenter=new JPanel();
	    pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
	    Border centerBorder=BorderFactory.createLineBorder(Color.RED);
	    TitledBorder titleBorderCenter=new TitledBorder(centerBorder,"Nhap 2 so a va b");
	    pnCenter.setBorder(titleBorderCenter);
	    JPanel pna=new JPanel();
	    JLabel lbla=new JLabel("Nhap a:");
	    final JTextField txta=new JTextField(15);
	    pna.add(lbla);
	    pna.add(txta);
	    pnCenter.add(pna);
	    JPanel pnb=new JPanel();
	    JLabel lblb=new JLabel("Nhap b:");
	    final JTextField txtb=new JTextField(15);
	    pnb.add(lblb);
	    pnb.add(txtb);
	    pnCenter.add(pnb);
	    JPanel pnc=new JPanel();
	    JPanel pnPhepToan=new JPanel();
	    pnPhepToan.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Chon Phep Toan"));
	    pnPhepToan.setLayout(new GridLayout(2,2));
	    final JRadioButton radCong=new JRadioButton("Cong");
	    pnPhepToan.add(radCong);
	    final JRadioButton radTru=new JRadioButton("Tru");
	    pnPhepToan.add(radTru);
	    final JRadioButton radNhan=new JRadioButton("Nhan");
	    pnPhepToan.add(radNhan);
	    final JRadioButton radChia=new JRadioButton("Chia");
	    pnPhepToan.add(radChia);
	    ButtonGroup group=new ButtonGroup();
	    group.add(radCong);
	    group.add(radTru);
	    group.add(radNhan);
	    group.add(radChia);
	    pnc.add(pnPhepToan);
	    pnCenter.add(pnc);
	    JPanel	pnkq=new JPanel();
	    JLabel	lblkq=new JLabel("Kết quả:");
	    final JTextField txtkq=new JTextField(15);
	    pnkq.add(lblkq);
	    pnkq.add(txtkq);
	    pnCenter.add(pnkq);
	    lbla.setPreferredSize(lblkq.getPreferredSize());
	    lblb.setPreferredSize(lblkq.getPreferredSize());
	    btnThoat.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent	e)	{
	    	int ret=JOptionPane.showConfirmDialog(null,	
	    	"Xác Nhận Muốn Thoát",	"Thoát", JOptionPane.YES_NO_OPTION);
	    	if(ret==JOptionPane.YES_OPTION)
	    	System.exit(0);
	    	}
	    	});
	    btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txta.setText("");
				txtb.setText("");
				txtkq.setText("");
				txta.requestFocus();
				
			}
		});
	    btnGiai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int a=0,b=0;
				String sa=txta.getText();
				try {
					a=Integer.parseInt(sa);
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Nhap a sai dinh dang");
					txta.selectAll();
					txta.requestFocus();
				}
				
				String sb=txtb.getText();
				try {
					b=Integer.parseInt(sb);
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Nhap a sai dinh dang");
					txtb.selectAll();
					txtb.requestFocus();
				}
				double kq=0;
				if(radCong.isSelected()) {
					kq=(a+b);
				}
				else if(radTru.isSelected()) {
					kq=(a-b);
				}
				else if(radNhan.isSelected()) {
					kq=(a*b);
				}
				else {
					kq=a*1.0/b*1.0;
				}
				txtkq.setText(kq+"");
			}
		});
	    pnBorder.add(pnCenter,BorderLayout.CENTER);
		add(pnBorder);
	}
	
	public static void main(String[] args) {
		CongTruNhanChia ui=new CongTruNhanChia("Cong-Tru-Nhan-Chia");
		ui.doShow();
	}
}

