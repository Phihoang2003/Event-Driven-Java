package tuan5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class JListCheckbox extends JFrame implements ActionListener {
	
	private JLabel topLable;
	private JPanel header;
	private JPanel left;
	private JButton btnChan;
	private JButton btnLe;
	private JButton btnSoNguyenTo;
	private JButton btnBoToDen;
	private JButton btnXoa;
	private JButton btnTong;
	private JPanel right;
	private DefaultListModel<Integer> listModel;
	private JList<Integer> list;
	private JScrollPane scroll;
	private JPanel bottom;
	private JButton btnNhap;
	private JTextField txtField;
	private JCheckBox ckb;
	private JButton btnClose;

	public JListCheckbox() {
		setTitle("Thao tac tren JList Checkbox");
		setSize(700,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		header=new JPanel();
		topLable=new JLabel("Thao Tac Tren JList-Checkbox");
		topLable.setFont(new Font("arial", Font.BOLD, 30));
		topLable.setForeground(Color.BLUE);
		header.add(topLable);
		add(header,BorderLayout.NORTH);
		GridLayout layout=new GridLayout(8,1);
		layout.setVgap(10);
		left=new JPanel();
		left.setLayout(layout);
		left.setBorder(BorderFactory.createTitledBorder("Chon Tac Vu"));
		btnChan=new JButton("To den so chan");
		left.add(btnChan);
		btnLe=new JButton("To den so le");
		left.add(btnLe);
		btnSoNguyenTo=new JButton("To den so nguyen to");
		left.add(btnSoNguyenTo);
		btnBoToDen=new JButton("Bo to den");
		left.add(btnBoToDen);
		btnXoa=new JButton("Xoa cac gia tri dang to den");
		left.add(btnXoa);
		btnTong=new JButton("Tong gia tri trong JList");
		left.add(btnTong);
		add(left,BorderLayout.WEST);
		right=new JPanel();
		right.setBorder(BorderFactory.createTitledBorder("Nhap thong tin"));
		Box box1,box2;
		box1=Box.createHorizontalBox();
		box1.add(btnNhap=new JButton("Nhap"));
		box1.add(txtField=new JTextField(15));
		box1.add(ckb=new JCheckBox("Cho Nhap so am"));
		listModel=new DefaultListModel<Integer>();
		list=new JList<Integer>(listModel);
		scroll=new JScrollPane(list,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(400,270));
		box2=Box.createHorizontalBox();
		box2.add(scroll);
		right.add(box1);
		right.add(box2);
		add(right,BorderLayout.CENTER);
		
		bottom=new JPanel();
		bottom.add(btnClose=new JButton("Dong chuong trinh"));
		add(bottom,BorderLayout.SOUTH);
		
		txtField.addActionListener(this);
		btnBoToDen.addActionListener(this);
		btnChan.addActionListener(this);
		btnLe.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSoNguyenTo.addActionListener(this);
		btnTong.addActionListener(this);
		ckb.addActionListener(this);
		btnNhap.addActionListener(this);
		btnClose.addActionListener(this);
		
		
	}
	public static void main(String[] args) {
		new JListCheckbox().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o==btnNhap||o==txtField) {
			inputNumber();
		}
		else if(o==btnChan) {
			selectChan();
		}
	}
	public void inputNumber() {
		try {
			int n=Integer.parseInt(txtField.getText());
			if(ckb.isSelected()||n>0) {
				listModel.addElement(n);
			}
			else {
				JOptionPane.showMessageDialog(this, "Khong duoc nhap so am");
				return;
			}
			txtField.requestFocus();
			txtField.selectAll();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Nhap so");
			txtField.requestFocus();
			txtField.selectAll();
		}
	}
	public void selectChan() {
		list.clearSelection();
		for(int i=0;i<listModel.getSize();i++) {
			if((int)listModel.getElementAt(i)%2==0) {
				list.addSelectionInterval(i, i);
			}
		}
	}

}
