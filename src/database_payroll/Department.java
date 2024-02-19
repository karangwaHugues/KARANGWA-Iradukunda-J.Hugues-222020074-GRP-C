package database_payroll;

import java.awt.EventQueue;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Color;

public class Department {

	private JFrame frmAlhamaEmployeeDatabase;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Department window = new Department();
					window.frmAlhamaEmployeeDatabase.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Department() {
		initialize();
		connect();
		table_load();
	}

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public void connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/apms","root","");
		}
		catch (ClassNotFoundException ex) {
	}
		catch (SQLException ex) {
		}}
	
	public void table_load() {
		try {
			pst=con.prepareStatement("select * from department");
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlhamaEmployeeDatabase = new JFrame();
		frmAlhamaEmployeeDatabase.setTitle("ALHAMA EMPLOYEE DATABASE AND PAYROLL MANAGEMENT SYSTEM");
		frmAlhamaEmployeeDatabase.setBounds(100, 100, 764, 450);
		frmAlhamaEmployeeDatabase.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmAlhamaEmployeeDatabase.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 748, 424);
		frmAlhamaEmployeeDatabase.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "add department", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 64, 338, 109);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel l1 = new JLabel("dept_id");
		l1.setFont(new Font("Monospaced", Font.BOLD, 14));
		l1.setBounds(10, 25, 92, 14);
		panel_1.add(l1);
		
		JLabel l2 = new JLabel("dept_name");
		l2.setFont(new Font("Monospaced", Font.BOLD, 14));
		l2.setBounds(10, 65, 92, 14);
		panel_1.add(l2);
		
		txt1 = new JTextField();
		txt1.setBounds(112, 22, 190, 20);
		panel_1.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(112, 62, 190, 20);
		panel_1.add(txt2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 211, 345, 97);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel l3 = new JLabel("dept_id");
		l3.setFont(new Font("Monospaced", Font.BOLD, 14));
		l3.setBounds(10, 40, 88, 14);
		panel_2.add(l3);
		
		txt3 = new JTextField();
		txt3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
			try {
				String dept_id=txt3.getText();
				pst = con.prepareStatement("select dept_id,dept_name from department where dept_id=?");
				pst.setString(1, dept_id);
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()==true) {
				String dept_id1 = rs.getString(1);
					String dept_name = rs.getString(2);
					txt1.setText(dept_id1);
					txt2.setText(dept_name);
				}
				else {
					txt2.setText("");
					
				}
			
			}
			catch (SQLException ex) {
			}
			}
		});
		txt3.setBounds(108, 37, 196, 20);
		panel_2.add(txt3);
		txt3.setColumns(10);
		
		JButton bt1 = new JButton("save");
		bt1.setFont(new Font("Monospaced", Font.BOLD, 14));
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String dept_id,dept_name;
				dept_id=txt1.getText();
				dept_name=txt2.getText();
				try{
					pst=con.prepareStatement("insert into department(dept_id,dept_name) values(?,?)");
					pst.setString(1,dept_id);
					pst.setString(2, dept_name);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "departiment added succesfull Sucessful!!");
					table_load();
					txt1.setText("");
					txt2.setText("");
					

					txt2.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}
				
			}
		});
		bt1.setBounds(23, 360, 89, 23);
		panel.add(bt1);
		
		JButton bt2 = new JButton("update");
		bt2.setFont(new Font("Monospaced", Font.BOLD, 14));
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String dept_id,dept_name;
				dept_id=txt1.getText();
				dept_name=txt2.getText();
				dept_id=txt3.getText();
				try{
					pst=con.prepareStatement("update department set dept_id=?,dept_name=? where dept_id=?");
					pst.setString(1,dept_id);
					pst.setString(2, dept_name);
					pst.setString(3, dept_id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "departiment updated succesfull Sucessful!!");
					table_load();
					txt1.setText("");
					txt2.setText("");
					

					txt2.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}
				
			}	
				
			//}
		});
		bt2.setBounds(122, 360, 89, 23);
		panel.add(bt2);
		
		JButton bt3 = new JButton("delete");
		bt3.setFont(new Font("Monospaced", Font.BOLD, 14));
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String dept_id;
				dept_id=txt3.getText();
				try{
					pst=con.prepareStatement("delete from department where dept_id=?");
					pst.setString(1, dept_id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "departiment deleted succesfull Sucessful!!");
					table_load();
					txt1.setText("");
					txt2.setText("");
					

					txt2.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}
				
			}
				
			//}
		});
		bt3.setBounds(221, 360, 89, 23);
		panel.add(bt3);
		
		JButton bt4 = new JButton("clear");
		bt4.setFont(new Font("Monospaced", Font.BOLD, 14));
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");

				txt2.requestFocus();
			}
		});
		bt4.setBounds(328, 360, 89, 23);
		panel.add(bt4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(358, 64, 380, 285);
		panel.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton bt5 = new JButton("exit");
		bt5.setFont(new Font("Monospaced", Font.BOLD, 14));
		bt5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		bt5.setBounds(442, 360, 74, 23);
		panel.add(bt5);
		
		JButton btnNewButton = new JButton("Signout");
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmAlhamaEmployeeDatabase.dispose();
				Login info = new Login();
				Login.main(null);
			}
		});
		btnNewButton.setBounds(651, 0, 97, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmAlhamaEmployeeDatabase.dispose();
				HOME info = new HOME();
				HOME.main(null);
			}
		});
		btnNewButton_1.setBounds(0, 0, 89, 23);
		panel.add(btnNewButton_1);
	}
}
