import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import dao.menuDAO;

public class tabel extends JFrame implements ActionListener{
	JButton exit;
	
	public tabel() {
		// TODO Auto-generated constructor stub
		initframe();
	}
	
	public void initframe() {
		setTitle("View Data");
		setSize(500, 500);
		initjtabel();
		komponen();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(450,100);
		setVisible(true);
	}
	
	public void initjtabel() {
		menuDAO MenuDAO=new menuDAO();
		
		Vector<String> columns = new Vector<>();
		columns.add("Kode Menu");
		columns.add("Nama Menu");
		columns.add("Harga Menu");
		columns.add("Stok Menu");
		
		JTable table= new JTable(MenuDAO.getMenuData(),columns) {
		@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}	
		};
		setLayout(new BorderLayout());
		JScrollPane sp = new JScrollPane(table);
		add(sp,BorderLayout.NORTH);
	}

	public void komponen() {
		exit= new JButton("Exit");
		exit.addActionListener(this);
		JPanel bawah= new JPanel();
		bawah.setLayout(new FlowLayout());
		bawah.add(exit);
		add(bawah);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(exit)) {
			new Main();
			setVisible(false);
		}
	}
}