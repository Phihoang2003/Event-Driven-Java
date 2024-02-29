package tuan2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.print.PrinterGraphics;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
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
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;


public class JListCheckbox extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton selectBtnEN;
	private JButton selectBtnON;
	private JButton btnSelectP;
	private JButton btnUnSelect;
	private JButton btnRemove;
	private JButton btnNhap;
	private JTextField txtField;
	private JCheckBox checkBox;
	private JButton btnClose;
	private JButton btnCreateNumber;
	private JButton btnSum;
	private final int MAXSIZE = 10;
	private JLabel resultSum;
	private DefaultListModel<Integer> listModel;
	private JList<Integer> list;
	public JListCheckbox() {
		//Init
		setTitle("Thao tac tren JList");
		setSize(700,500);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Header
		Font fontHeader=new Font("Aria",Font.BOLD,30);
		JPanel header=new JPanel();
		JLabel lblHeader=new JLabel("Thao Tac Tren List-Checkbox");
		lblHeader.setFont(fontHeader);
		lblHeader.setForeground(Color.BLUE);
		header.add(lblHeader);
		add(header,BorderLayout.NORTH);
		//Left
		JPanel selectTask=new JPanel(new GridLayout(8,1));
		TitledBorder titleLeft=new TitledBorder(BorderFactory.createLineBorder(Color.RED),"Chon Tac Vu");
		titleLeft.setTitleJustification(TitledBorder.CENTER);
		selectTask.setBorder(titleLeft);
		 selectBtnEN=new JButton("To den so chan");
		selectTask.add(selectBtnEN);
		 selectBtnON=new JButton("To den so le");
		selectTask.add(selectBtnON);
		btnSelectP = new JButton("Tô đen số nguyên tố");
		selectTask.add(btnSelectP);
		 btnUnSelect = new JButton("Bỏ tô đen");
		selectTask.add(btnUnSelect);
		btnRemove = new JButton("Xóa các giá trị đang tô đen");
		selectTask.add(btnRemove);
		 btnSum = new JButton("Tổng giá trị trong JList");
		selectTask.add(btnSum);
		 resultSum = new JLabel("");
		selectTask.add( resultSum);
		((GridLayout) selectTask.getLayout()).setVgap(10); 
		add(selectTask,BorderLayout.WEST);
		//center
		JPanel inputInfo=new JPanel();
		TitledBorder titleRight=new TitledBorder(BorderFactory.createLineBorder(Color.RED),"Nhap thong tin");
		inputInfo.setBorder(titleRight);
		 btnNhap=new JButton("Nhap");
		inputInfo.add(btnNhap);
		 txtField=new JTextField(15);
		inputInfo.add(txtField);
		 checkBox=new JCheckBox("Cho nhap so am");
		inputInfo.add(checkBox);
		listModel = new DefaultListModel<Integer>();
		list = new JList<Integer>(listModel);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane croll = new JScrollPane(list,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		croll.setPreferredSize(new Dimension(400,270));
		inputInfo.add(croll);
		 btnCreateNumber=new JButton("Tao so ngau nhien");
		inputInfo.add(btnCreateNumber);
		add(inputInfo);
		//footer
		JPanel footer = new JPanel();
		 btnClose = new JButton("Đóng chương trình");
		footer.add(btnClose);
		add(footer,BorderLayout.SOUTH);
		//Event Handling
		txtField.addActionListener(this);
		btnNhap.addActionListener(this);
		btnClose.addActionListener(this);
		checkBox.addActionListener(this);
		btnCreateNumber.addActionListener(this);
		selectBtnEN.addActionListener(this);
		selectBtnON.addActionListener(this);
		btnSelectP.addActionListener(this);
		btnUnSelect.addActionListener(this);
		btnRemove.addActionListener(this);
		btnSum.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
	    Object o = e.getSource();
	    if (o == btnNhap || o == txtField) {
	        inputNumber();
	    } else if (o == btnCreateNumber) {
	        randomNumbers1();
	    } else if (o == selectBtnEN) {
	        selectEvenNumbers();
	    } else if (o == selectBtnON) {
	        selectOddNumbers();
	    } else if (o == btnSelectP) {
	        selectPrime();
	    } else if (o == btnUnSelect) {
	        list.clearSelection();
	    } else if (o == btnRemove) {
	        removeSelected();
	    } else if (o == btnSum) {
	        sum();
	    }
	    else if(o==btnCreateNumber) {
	    	randomNumbers1();
	    }
	}
	private void randomNumbers1() {
		for(int i = 0; i<MAXSIZE; i++) {
			if(checkBox.isSelected())
				listModel.addElement(new Random().nextInt(101)-50);//-50 -> 50
			else 
				listModel.addElement(new Random().nextInt(51));//0 -> 50
		}
	}
	private void sum() {
			int total = 0;
			for(int i = 0; i<listModel.size();i++) {
				total+=(int)listModel.getElementAt(i);
			}
			resultSum.setText("Tổng giá trị trong JList là: "+total);
	}
	
	private void inputNumber() {
        // TODO: Thêm logic cho phương thức inputNumber
		try {
			int n=Integer.parseInt(txtField.getText());
			if(checkBox.isSelected()||n>0) {
				listModel.addElement(n);
			}
			else {
				JOptionPane.showMessageDialog(this, "Khong duoc nhap so am");
				txtField.selectAll();
				txtField.requestFocus();
				return;
			}
			txtField.setText("");
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Nhap so!!!");
			txtField.selectAll();
			txtField.requestFocus();
		}
    }

    private void randomNumbers() {
        // TODO: Thêm logic cho phương thức randomNumbers
    	System.out.println("sdjfs");
    }

    private void selectEvenNumbers() {
        // TODO: Thêm logic cho phương thức selectEvenNumbers
    }

    private void selectOddNumbers() {
        // TODO: Thêm logic cho phương thức selectOddNumbers
    }

    private void selectPrime() {
        // TODO: Thêm logic cho phương thức selectPrime
    }

    private void removeSelected() {
    	System.out.println("Hello1");
    	List<Integer> selectedItems=list.getSelectedValuesList();
    	
    	for(int selectedItem:selectedItems) {

    		listModel.removeElement(selectedItem);
    	}
    }
	public static void main(String[] args) {
		new JListCheckbox().setVisible(true);
	}
}
