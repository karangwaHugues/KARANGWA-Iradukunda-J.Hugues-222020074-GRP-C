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

public class User {

	private JFrame frmAlhamaemployeeDatabaseAnd;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt6;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User window = new User();
					window.frmAlhamaemployeeDatabaseAnd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public User() {
		initialize();
		connect();
		table_load();
	}

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	
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
			pst=con.prepareStatement("select * from user");
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
		frmAlhamaemployeeDatabaseAnd = new JFrame();
		frmAlhamaemployeeDatabaseAnd.setTitle("ALHAMAEMPLOYEE DATABASE AND PAYROLL MANAGEMENT SYSTEM");
		frmAlhamaemployeeDatabaseAnd.getContentPane().setBackground(new Color(0, 128, 0));
		frmAlhamaemployeeDatabaseAnd.setBackground(new Color(0, 255, 0));
		frmAlhamaemployeeDatabaseAnd.setBounds(100, 100, 764, 444);
		frmAlhamaemployeeDatabaseAnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlhamaemployeeDatabaseAnd.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, -21, 748, 415);
		frmAlhamaemployeeDatabaseAnd.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		panel_1.setBorder(new TitledBorder(null, "add user", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 53, 338, 211);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel l1 = new JLabel("user_id");
		l1.setFont(new Font("Agency FB", Font.BOLD, 16));
		l1.setBounds(10, 25, 78, 14);
		panel_1.add(l1);
		
		JLabel l2 = new JLabel("user_name");
		l2.setFont(new Font("Agency FB", Font.BOLD, 16));
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
		
		JLabel l4 = new JLabel("password");
		l4.setFont(new Font("Agency FB", Font.BOLD, 16));
		l4.setBounds(10, 104, 66, 17);
		panel_1.add(l4);
		
		txt3 = new JTextField();
		txt3.setBounds(112, 101, 190, 20);
		panel_1.add(txt3);
		txt3.setColumns(10);
		
		JLabel l5 = new JLabel("email_id");
		l5.setFont(new Font("Agency FB", Font.BOLD, 16));
		l5.setBounds(10, 143, 66, 14);
		panel_1.add(l5);
		
		txt4 = new JTextField();
		txt4.setBounds(112, 140, 190, 20);
		panel_1.add(txt4);
		txt4.setColumns(10);
		
		JLabel l6 = new JLabel("user_type");
		l6.setFont(new Font("Agency FB", Font.BOLD, 16));
		l6.setBounds(10, 179, 92, 17);
		panel_1.add(l6);
		
		txt5 = new JTextField();
		txt5.setBounds(112, 176, 190, 20);
		panel_1.add(txt5);
		txt5.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.window);
		panel_2.setBorder(new TitledBorder(null, "search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 272, 345, 77);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel l3 = new JLabel("user_id");
		l3.setFont(new Font("Agency FB", Font.BOLD, 16));
		l3.setBounds(10, 40, 75, 14);
		panel_2.add(l3);
		
		txt6 = new JTextField();
		txt6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
			try {
				String user_id=txt6.getText();
				pst = con.prepareStatement("select user_id,user_name,password,email_id,user_type from user where user_id=?");
				pst.setString(1, user_id);
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()==true) {
				String user_id1 = rs.getString(1);
					String user_name = rs.getString(2);
					String password = rs.getString(3);
					String email_id = rs.getString(4);
					String user_type = rs.getString(5);
					txt1.setText(user_id1);
					txt2.setText(user_name);
					txt3.setText(password);
					txt4.setText(email_id);
					txt5.setText(user_type);
				}
				else {
					txt2.setText("");
					
				}
			
			}
			catch (SQLException ex) {
			}
			}
		});
		txt6.setBounds(108, 37, 196, 20);
		panel_2.add(txt6);
		txt6.setColumns(10);
		
		JButton bt1 = new JButton("save");
		bt1.setFont(new Font("Agency FB", Font.BOLD, 16));
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user_id,user_name,password,email_id,user_type;
				user_id=txt1.getText();
				user_name=txt2.getText();
				password=txt3.getText();
				email_id=txt4.getText();
				user_type=txt5.getText();
				try{
					pst=con.prepareStatement("insert into user(user_id,user_name,password,email_id,user_type) values(?,?,?,?,?)");
					pst.setString(1,user_id);
					pst.setString(2, user_name);
					pst.setString(3, password);
					pst.setString(4, email_id);
					pst.setString(5, user_type);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "user added succesfull Sucessful!!");
					table_load();
					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
					txt4.setText("");
					txt5.setText("");
					

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
		bt2.setFont(new Font("Agency FB", Font.BOLD, 16));
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user_id,user_name,password,email_id,user_type;
				user_id=txt1.getText();
				user_name=txt2.getText();
				user_id=txt6.getText();//REMOVE INVORKE
				password=txt3.getText();
				email_id=txt4.getText();
				user_type=txt5.getText();
				try{
					pst=con.prepareStatement("update user set user_id=?,user_name=?,password=?,email_id=?,user_type=? where user_id=?");
					pst.setString(1,user_id);
					pst.setString(2, user_name);
					pst.setString(3, user_id);
					pst.setString(3, password);
					pst.setString(4, email_id);
					pst.setString(5, user_type);
					pst.setString(6,user_id);// REMOVE INVOKE ERROR
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "departiment updated succesfull Sucessful!!");
					table_load();
					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
					txt4.setText("");
					txt5.setText("");
					txt6.setText("");

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
		bt3.setFont(new Font("Agency FB", Font.BOLD, 16));
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String user_id;
				user_id=txt6.getText();
				try{
					pst=con.prepareStatement("delete from user where user_id=?");
					pst.setString(1, user_id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "user deleted succesfull Sucessful!!");
					table_load();
					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
					txt4.setText("");
					txt5.setText("");

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
		bt4.setFont(new Font("Agency FB", Font.BOLD, 16));
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt1.setText("");
				txt2.setText("");
				txt6.setText("");
				txt3.setText("");
				txt4.setText("");
				txt5.setText("");

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
		bt5.setFont(new Font("Agency FB", Font.BOLD, 16));
		bt5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		bt5.setBounds(442, 360, 74, 23);
		panel.add(bt5);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmAlhamaemployeeDatabaseAnd.dispose();
				HOME info = new HOME();
				HOME.main(null);
				
			}
		});
		btnNewButton.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnNewButton.setBounds(10, 19, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Signout");
		btnNewButton_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmAlhamaemployeeDatabaseAnd.dispose();
				Login info = new Login();
				Login.main(null);
			}
			
		});
		btnNewButton_1.setBounds(638, 21, 110, 23);
		panel.add(btnNewButton_1);
	}
}