import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import dao.menuDAO;

public class update extends JFrame implements ActionListener {
	JFrame frame;
	JButton update = new JButton("Update");
	JButton exit = new JButton("Exit");
	JTable table;
	
	public update() {
		// TODO Auto-generated constructor stub
		initframe();
	}
	
	public void initframe() {
		frame=new JFrame("Update Data");
		frame.setSize(500, 500);
		initlabel();
		initjtabel();
		initmenubawah();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(450,100);
		frame.setVisible(true);
	}
	
	public void initlabel() {
		JLabel label=new JLabel("Select row to update");
		label.setHorizontalAlignment(label.CENTER);
		label.setFont(new Font(null, Font.PLAIN, 14));
		frame.add(label, BorderLayout.NORTH);
	}
	
	public void initjtabel() {
		menuDAO MenuDAO=new menuDAO();
		
		Vector<String> columns = new Vector<>();
		columns.add("Kode Menu");
		columns.add("Nama Menu");
		columns.add("Harga Menu");
		columns.add("Stok Menu");
		
		table = new JTable(MenuDAO.getMenuData(),columns) {
		@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}	
		};
		setLayout(new BorderLayout());
		JScrollPane sp = new JScrollPane(table);
		frame.add(sp);
	}
	
	public void initmenubawah() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		update.addActionListener(this);
		exit.addActionListener(this);
		update.setBackground(Color.green);
		update.setOpaque(true);
		update.setForeground(Color.WHITE);
		exit.setBackground(Color.RED);
		exit.setOpaque(true);
		exit.setForeground(Color.WHITE);
		panel.add(update);
		panel.add(exit);
		frame.add(panel,BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(exit)) {
			new Main();
			setVisible(false);
		}
		else if (e.getSource().equals(update)) {
			int row = table.getSelectedRow();
			String cell = table.getModel().getValueAt(row, 0).toString();
			new updateForm(cell);
		}
	}
}