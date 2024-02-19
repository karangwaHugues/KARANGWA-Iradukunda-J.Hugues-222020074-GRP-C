package database_payroll;

import java.awt.EventQueue;



import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;

public class Employee {

	JFrame frmAlhamaEmployeeDatabase;
	private JTextField txt2;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;
	private JTextField txt7;
	private JTable table;
	private JTextField txt3;
	private JTextField txt1;
	private JTextField txt8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee window = new Employee();
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
	public Employee() {
		initialize();
		connect();
		//table_load();
	}

	Connection con;
	PreparedStatement pst;
   ResultSet rs;
	
	public void connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/apms","root","");
			//Object url;
			//Object jdbc;
			//Object driver = url=jdbc:mysql://127.0.0.1/test?zerodateBehavior=convertToNull
		}
		catch (ClassNotFoundException ex) {
	}
		catch (SQLException ex) {
		}}
	
	public void table_load() {
	try {
			pst=con.prepareStatement("select * from employee");
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
		frmAlhamaEmployeeDatabase.setTitle("ALHAMA EMPLOYEE DATABASE AND PAYROLL MANAGEMENT SYSTEM\r\n");
		frmAlhamaEmployeeDatabase.setBackground(new Color(0, 128, 128));
		frmAlhamaEmployeeDatabase.getContentPane().setBackground(new Color(255, 0, 255));
		frmAlhamaEmployeeDatabase.setBounds(100, 100, 852, 467);
		frmAlhamaEmployeeDatabase.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmAlhamaEmployeeDatabase.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(0, 0, 836, 440);
		frmAlhamaEmployeeDatabase.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel l2 = new JLabel("Employee Details");
		l2.setBounds(264, 36, 111, 14);
		panel_1.add(l2);
		l2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		
		JButton bt4 = new JButton("back");
		bt4.setBounds(0, 0, 80, 17);
		panel_1.add(bt4);
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAlhamaEmployeeDatabase.dispose();
				HOME info = new HOME();
				HOME.main(null);
			}
		});
		bt4.setIcon(null);
		
		JButton bt3 = new JButton("Signout");
		bt3.setBounds(762, -5, 74, 23);
		panel_1.add(bt3);
		bt3.setIcon(null);
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAlhamaEmployeeDatabase.dispose();
				Login info = new Login();
				Login.main(null);
			}
		});
		bt3.setFont(new Font("Agency FB", Font.BOLD, 14));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "search employee", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 316, 339, 113);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel l00 = new JLabel("Employee_id");
		l00.setBackground(SystemColor.controlLtHighlight);
		l00.setFont(new Font("Agency FB", Font.BOLD, 16));
		l00.setBounds(10, 44, 78, 14);
		panel_2.add(l00);
		
		txt8 = new JTextField();
		txt8.setBackground(SystemColor.inactiveCaptionBorder);
		txt8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				try {
					String emp_id1=txt8.getText();//to hold search value
					pst = con.prepareStatement("select emp_id,emp_title,emp_name,emp_dob,emp_doj,emp_mobile_no,dept_id from employee where emp_id=?");
					pst.setString(1,emp_id1);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()==true) {
					String emp_id = rs.getString(1);
						String emp_title = rs.getString(2);
						String emp_name = rs.getString(3);
						String emp_dob = rs.getString(4);
						String emp_doj = rs.getString(5);
						String emp_mobile_no = rs.getString(6);
						String dept_id = rs.getString(7);
						txt1.setText(emp_id);
						txt2.setText(emp_title);
						txt3.setText(emp_name);
						txt4.setText(emp_dob);
						txt5.setText(emp_doj);
						txt6.setText(emp_mobile_no);
						txt7.setText(dept_id);
						
					}
					else {
						txt3.setText("");
						
					}
				
				}
				catch (SQLException ex) {
				}
				
				
			}
		});
		txt8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txt8.setBounds(116, 41, 202, 20);
		panel_2.add(txt8);
		txt8.setColumns(10);
		
		JLabel l1 = new JLabel("WELCOME ADMIN");
		l1.setBounds(249, 11, 126, 14);
		panel_1.add(l1);
		l1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		
		JButton bt1 = new JButton("SUBMIT");
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String emp_id,emp_title,emp_name,emp_dob,emp_doj,emp_mobile_no,dept_id;
				emp_id=txt1.getText();
				emp_title=txt2.getText();
				emp_name=txt3.getText();
				emp_dob=txt4.getText();
				emp_doj=txt5.getText();
				emp_mobile_no=txt6.getText();
				dept_id=txt7.getText();
				
				try{
					pst=con.prepareStatement("insert into employee (emp_id,emp_title,emp_name,emp_dob,emp_doj,emp_mobile_no,dept_id) values(?,?,?,?,?,?,?)");
					pst.setString(1,emp_id);
					pst.setString(2,emp_title);
					pst.setString(3,emp_name);
					pst.setString(4, emp_dob);
					pst.setString(5,emp_doj);
					pst.setString(6, emp_mobile_no);
					pst.setString(7, dept_id);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "employee added succesfull Sucessful!!");
					table_load();
					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
					txt4.setText("");
					txt5.setText("");
					txt6.setText("");
					txt7.setText("");
				

					txt1.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}
				
		
				
				
			}
		});
		bt1.setBounds(352, 316, 89, 102);
		panel_1.add(bt1);
		bt1.setBackground(SystemColor.controlLtHighlight);
		bt1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		
		JButton bt5 = new JButton("UPDATE");
		bt5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String emp_id,emp_title,emp_name,emp_dob,emp_doj,emp_mobile_no,dept_id;
				emp_id=txt1.getText();
				emp_title=txt2.getText();
				emp_name=txt3.getText();
				emp_dob=txt4.getText();
				emp_doj=txt5.getText();
				emp_mobile_no=txt6.getText();
				dept_id=txt7.getText();
				emp_id=txt8.getText();
				
				try{
					pst=con.prepareStatement("update employee set emp_id=?,emp_title=?,emp_name=?,emp_dob=?,emp_doj=?,emp_mobile_no=?,dept_id=? where emp_id=?");
					pst.setString(1,emp_id);
					pst.setString(2,emp_title);
					pst.setString(3,emp_name);
					pst.setString(4, emp_dob);
					pst.setString(5,emp_doj);
					pst.setString(6, emp_mobile_no);
					pst.setString(7, dept_id);
					pst.setString(8, emp_id);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "employee updated succesfull Sucessful!!");
					table_load();
					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
					txt4.setText("");
					txt5.setText("");
					txt6.setText("");
					txt7.setText("");
					//txt6.setText("");
				

					txt1.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}
				
			}
		});
		bt5.setBounds(451, 316, 89, 102);
		panel_1.add(bt5);
		bt5.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		bt5.setBackground(SystemColor.controlLtHighlight);
		
		JButton bt6 = new JButton("DELETE");
		bt6.setBounds(550, 316, 89, 101);
		panel_1.add(bt6);
		bt6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String emp_id;
				
				emp_id=txt8.getText();
				
				try{
					pst=con.prepareStatement("delete from employee where emp_id=?");
					pst.setString(1,emp_id);
					//pst.setString(8, emp_id);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "employee deleted succesfull Sucessful!!");
					table_load();
					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
					txt4.setText("");
					txt5.setText("");
					txt6.setText("");
					txt7.setText("");
					//txt6.setText("");
				

					txt1.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}
				
				
			}
		});
		bt6.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		bt6.setBackground(SystemColor.controlLtHighlight);
		
		JButton bt2 = new JButton("CLEAR");
		bt2.setBounds(649, 316, 89, 102);
		panel_1.add(bt2);
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				txt2.setText(null);
				txt4.setText(null);
				txt5.setText(null);
				txt6.setText(null);
				txt7.setText(null);
				txt1.setText(null);
				txt3.setText(null);
				
			}
		});
		bt2.setBackground(SystemColor.controlLtHighlight);
		bt2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		btnExit.setBackground(SystemColor.controlLtHighlight);
		btnExit.setBounds(748, 316, 89, 102);
		panel_1.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("List of registered Employee");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblNewLabel.setBounds(427, 53, 273, 25);
		panel_1.add(lblNewLabel);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(383, 86, 420, 218);
		panel_1.add(scrollPane_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_3.setViewportView(scrollPane_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_2.setViewportView(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setColumnHeaderView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(412, 72, 212, 7);
		panel_1.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBounds(13, 87, 341, 218);
		panel_1.add(panel);
		panel.setBorder(new TitledBorder(null, "Employee info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		
		txt3 = new JTextField();
		txt3.setBackground(SystemColor.inactiveCaptionBorder);
		txt3.setBounds(127, 74, 195, 20);
		panel.add(txt3);
		txt3.setColumns(10);
		
		JLabel l0 = new JLabel("Employee_id");
		l0.setFont(new Font("Agency FB", Font.BOLD, 16));
		l0.setBounds(2, 26, 78, 19);
		panel.add(l0);
		
		txt1 = new JTextField();
		txt1.setBackground(SystemColor.inactiveCaptionBorder);
		txt1.setBounds(127, 25, 195, 20);
		panel.add(txt1);
		txt1.setColumns(10);
		
		JLabel l8 = new JLabel("dept_id");
		l8.setBounds(2, 190, 80, 14);
		panel.add(l8);
		l8.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		
		txt7 = new JTextField();
		txt7.setBounds(128, 187, 194, 20);
		panel.add(txt7);
		txt7.setBackground(SystemColor.inactiveCaptionBorder);
		txt7.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		txt7.setColumns(10);
		
		JLabel l7 = new JLabel("emp_mobile_no");
		l7.setBounds(2, 162, 115, 14);
		panel.add(l7);
		l7.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		
		txt6 = new JTextField();
		txt6.setBounds(127, 159, 195, 20);
		panel.add(txt6);
		txt6.setBackground(SystemColor.inactiveCaptionBorder);
		txt6.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		txt6.setColumns(10);
		
		txt5 = new JTextField();
		txt5.setBounds(127, 133, 195, 20);
		panel.add(txt5);
		txt5.setBackground(SystemColor.inactiveCaptionBorder);
		txt5.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		txt5.setColumns(10);
		
		JLabel l6 = new JLabel("emp_doj");
		l6.setBounds(2, 136, 80, 14);
		panel.add(l6);
		l6.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		
		txt4 = new JTextField();
		txt4.setBounds(127, 102, 195, 20);
		panel.add(txt4);
		txt4.setBackground(SystemColor.inactiveCaptionBorder);
		txt4.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		txt4.setColumns(10);
		
		JLabel l5 = new JLabel("emp_dob");
		l5.setBounds(2, 105, 126, 14);
		panel.add(l5);
		l5.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		
		JLabel l4 = new JLabel("emp_name");
		l4.setBounds(2, 76, 80, 14);
		panel.add(l4);
		l4.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		
		JLabel l3 = new JLabel("employee title");
		l3.setBounds(2, 51, 98, 14);
		panel.add(l3);
		l3.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		
		txt2 = new JTextField();
		txt2.setBounds(127, 48, 195, 20);
		panel.add(txt2);
		txt2.setBackground(SystemColor.inactiveCaptionBorder);
		txt2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		txt2.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(193, 0, 212, 54);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(383, 53, 420, 38);
		panel_1.add(panel_4);
	}
}
