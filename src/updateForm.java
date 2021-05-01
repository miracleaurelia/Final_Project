import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import dao.menuDAO;

public class updateForm extends JFrame implements ActionListener {
	JButton savebutton = new JButton("Save");
	JButton cancelbutton = new JButton("Cancel");
	JTextField txtprice;
	JTextField txtstock;
	String codeUpdate;
	
	public updateForm(String cell) {
		// TODO Auto-generated constructor stub
		codeUpdate = cell;
		initframe();
	}
	
	public void initframe() {
		setTitle("Masukkan Data");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,2));
		komponen();
		setLocation(450,100);
		setVisible(true);
	}
	
	public void komponen() {
		JLabel labelprice = new JLabel("Harga Menu");
		txtprice = new JTextField();
		JLabel labelstock = new JLabel("Stok Menu");
		txtstock = new JTextField();
		add(labelprice);
		add(txtprice);
		add(labelstock);
		add(txtstock);
		add(savebutton);
		add(cancelbutton);
		savebutton.addActionListener(this);
		cancelbutton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
		if (e.getSource().equals(savebutton)) {
			int price = Integer.parseInt(txtprice.getText());
			int stock = Integer.parseInt(txtstock.getText());
			JOptionPane.showMessageDialog(null, "Menu Updated Successfully");
			menuDAO MenuDAO = new menuDAO();
			MenuDAO.updateData(codeUpdate, price, stock);
			
			new Main();
			setVisible(false);
		} else if (e.getSource().equals(cancelbutton)) {
			JOptionPane.showMessageDialog(null, "Update cancelled");
			setVisible(false);
			new Main();
		}
	}
}