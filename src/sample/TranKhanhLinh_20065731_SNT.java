package sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField; 

public class TranKhanhLinh_20065731_SNT extends JFrame implements ActionListener {
	private JTextField txtGenerate;
	private JButton btnGenerate;
	private JTextArea txtResult;
	public TranKhanhLinh_20065731_SNT() {
		setTitle("Primes");
		setSize(400,350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		//
		JPanel p = new JPanel();
		add(p);
		txtGenerate = new JTextField(20);
		btnGenerate = new JButton("Generate");
		p.add(txtGenerate);
		p.add(btnGenerate);
		txtResult = new JTextArea(15,30);
		p.add(txtResult);
		//
		btnGenerate.addActionListener(this);
	}
	public static void main(String[] args) {
		new TranKhanhLinh_20065731_SNT().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnGenerate))
		{
			if(!isInt(txtGenerate))
			{
				focus(txtGenerate);
			}else
			{
				int n = Integer.parseInt(txtGenerate.getText());
				int dem = 1;
				int i = 2;
				txtResult.setText("");
				while(dem<=n)
				{
					if(kiemTraSNT(i))
					{
						txtResult.setText(txtResult.getText()+i+"\n");
						dem++;
					}
					i++;
				}
			}
		}
	}
	public boolean kiemTraSNT(int n) {
		if(n<2)
			return false;
		for(int i=2;i<=Math.sqrt(n);i++)
		{
			if(n%i==0)
				return false;
		}
		return true;
	}
	public boolean isInt(JTextField t)
	{
		try {
			int a= Integer.parseInt(t.getText());
			if(a<0)
				return false;
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	public void focus(JTextField t)
	{
		JOptionPane.showMessageDialog(null, "Nhập số nguyên!");
		t.selectAll();
		t.requestFocus();
	}
}
