package database_payroll;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Color;

public class Employee_grade_details {

	private JFrame frmAlhamaEmployeeDatabase;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;
	private JTextField txt7;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee_grade_details window = new Employee_grade_details();
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
	public Employee_grade_details() {
		
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
				pst=con.prepareStatement("select * from employee_grade_details");
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
		frmAlhamaEmployeeDatabase.getContentPane().setBackground(new Color(0, 128, 128));
		frmAlhamaEmployeeDatabase.setBackground(new Color(0, 128, 128));
		frmAlhamaEmployeeDatabase.setTitle("ALHAMA EMPLOYEE DATABASE AND PAYROLL MANAGEMENT SYSTEM\r\n");
		frmAlhamaEmployeeDatabase.setBounds(100, 100, 688, 469);
		frmAlhamaEmployeeDatabase.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmAlhamaEmployeeDatabase.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "employee_grade_details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 72, 346, 243);
		frmAlhamaEmployeeDatabase.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel transaction_id = new JLabel("transaction_id");
		transaction_id.setFont(new Font("Monospaced", Font.BOLD, 14));
		transaction_id.setBounds(10, 23, 115, 14);
		panel.add(transaction_id);
		
		JLabel emp_id = new JLabel("emp_id");
		emp_id.setFont(new Font("Monospaced", Font.BOLD, 16));
		emp_id.setBounds(10, 48, 115, 14);
		panel.add(emp_id);
		
		JLabel lblNewLabel = new JLabel("emp_dept");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 73, 105, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("emp_grade");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 111, 115, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("emp_from_date");
		lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 146, 115, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("emp_to_date");
		lblNewLabel_3.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 190, 115, 14);
		panel.add(lblNewLabel_3);
		
		txt1 = new JTextField();
		txt1.setBounds(135, 20, 86, 20);
		panel.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setBounds(135, 45, 86, 20);
		panel.add(txt2);
		txt2.setColumns(10);
		
		txt3 = new JTextField();
		txt3.setBounds(135, 70, 86, 20);
		panel.add(txt3);
		txt3.setColumns(10);
		
		txt4 = new JTextField();
		txt4.setBounds(135, 108, 86, 20);
		panel.add(txt4);
		txt4.setColumns(10);
		
		txt5 = new JTextField();
		txt5.setBounds(135, 143, 86, 20);
		panel.add(txt5);
		txt5.setColumns(10);
		
		txt6 = new JTextField();
		txt6.setBounds(135, 187, 86, 20);
		panel.add(txt6);
		txt6.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "search id", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 326, 346, 73);
		frmAlhamaEmployeeDatabase.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("transaction_id");
		lblNewLabel_4.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 32, 129, 14);
		panel_1.add(lblNewLabel_4);
		
		txt7 = new JTextField();
		txt7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				try {
					String transaction_id1=txt7.getText();
					pst = con.prepareStatement("select transaction_id,emp_id,emp_dept,emp_grade,emp_from_date,emp_to_date from employee_grade_details where transaction_id=?");
					pst.setString(1, transaction_id1);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()==true) {
					String transaction_id = rs.getString(1);
						String emp_id = rs.getString(2);
						String emp_dept = rs.getString(3);
						String emp_grade = rs.getString(4);
						String emp_from_date = rs.getString(5);
						String emp_to_date = rs.getString(6);
						txt1.setText(transaction_id);
						txt2.setText(emp_id);
						txt3.setText(emp_dept);
						txt4.setText(emp_grade);
						txt5.setText(emp_from_date);
						txt6.setText(emp_to_date);
					}
					else {
						txt1.setText("");
						
					}
				
				}
				catch (SQLException ex) {
				}
				
				
			}
		});
		txt7.setBounds(138, 29, 177, 20);
		panel_1.add(txt7);
		txt7.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(366, 72, 296, 243);
		frmAlhamaEmployeeDatabase.getContentPane().add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton bt1 = new JButton("ADD");
		bt1.setFont(new Font("Monospaced", Font.BOLD, 16));
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String transaction_id,emp_id,emp_dept,emp_grade,emp_from_date,emp_to_date;
				transaction_id=txt1.getText();
				emp_id=txt2.getText();
				emp_dept=txt3.getText();
				emp_grade=txt4.getText();
				emp_from_date=txt5.getText();
				emp_to_date=txt6.getText();
				
				try{
					pst=con.prepareStatement("insert into employee_grade_details"
							+ "(transaction_id,emp_id,emp_dept,emp_grade,emp_from_date,emp_to_date) values(?,?,?,?,?,?)");
					pst.setString(1,transaction_id);
					pst.setString(2, emp_id);
					pst.setString(3, emp_dept);
					pst.setString(4, emp_grade);
					pst.setString(5, emp_from_date);
					pst.setString(6, emp_to_date);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "employee_grade_details added succesfull Sucessful!!");
					table_load();
					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
					txt4.setText("");
					txt5.setText("");
					txt6.setText("");
					

					txt1.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}
				
				
				
			}
		});
		bt1.setBounds(361, 322, 89, 23);
		frmAlhamaEmployeeDatabase.getContentPane().add(bt1);
		
		JButton bt2 = new JButton("UPDATE");
		bt2.setFont(new Font("Monospaced", Font.BOLD, 14));
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String transaction_id,emp_id,emp_dept,emp_grade,emp_from_date,emp_to_date;
				transaction_id=txt1.getText();
				emp_id=txt2.getText();
				emp_dept=txt3.getText();
				emp_grade=txt4.getText();
				emp_from_date=txt5.getText();
				emp_to_date=txt6.getText();
				transaction_id=txt7.getText();
				
				try{
					pst=con.prepareStatement("update employee_grade_details set transaction_id=?,emp_id=?,emp_dept=?,emp_grade=?,emp_from_date=?,emp_to_date=? where transaction_id=? ");
					pst.setString(1,transaction_id);
					pst.setString(2, emp_id);
					pst.setString(3, emp_dept);
					pst.setString(4, emp_grade);
					pst.setString(5, emp_from_date);
					pst.setString(6, emp_to_date);
					pst.setString(7,transaction_id);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "employee_grade_details updated succesfull Sucessful!!");
					table_load();
					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
					txt4.setText("");
					txt5.setText("");
					txt6.setText("");
					

					txt1.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}
				
				
			}
		});
		bt2.setBounds(361, 361, 89, 23);
		frmAlhamaEmployeeDatabase.getContentPane().add(bt2);
		
		JButton bt3 = new JButton("DELETE");
		bt3.setFont(new Font("Monospaced", Font.BOLD, 14));
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String transaction_id;
				transaction_id=txt1.getText();
				
				
				try{
					pst=con.prepareStatement("delete from employee_grade_details where transaction_id=? ");
					pst.setString(1,transaction_id);
					
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "employee_grade_details deleted succesfull Sucessful!!");
					table_load();
					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
					txt4.setText("");
					txt5.setText("");
					txt6.setText("");
					

					txt1.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}
				
			}
		});
		bt3.setBounds(469, 322, 89, 23);
		frmAlhamaEmployeeDatabase.getContentPane().add(bt3);
		
		JButton bt4 = new JButton("CLEAR");
		bt4.setFont(new Font("Monospaced", Font.BOLD, 16));
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txt1.setText(null);
				txt3.setText(null);
				txt4.setText(null);
				txt5.setText(null);
				txt6.setText(null);
				txt2.setText(null);
				txt2.setText(null);
				
			}
		});
		bt4.setBounds(469, 361, 89, 23);
		frmAlhamaEmployeeDatabase.getContentPane().add(bt4);
		
		JButton bt5 = new JButton("EXIT");
		bt5.setFont(new Font("Monospaced", Font.BOLD, 16));
		bt5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		bt5.setBounds(568, 322, 89, 62);
		frmAlhamaEmployeeDatabase.getContentPane().add(bt5);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmAlhamaEmployeeDatabase.dispose();
				HOME info = new HOME();
				HOME.main(null);
				
			}
		});
		btnNewButton_1.setBounds(0, 0, 89, 23);
		frmAlhamaEmployeeDatabase.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Signout");
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmAlhamaEmployeeDatabase.dispose();
				Login info = new Login();
				Login.main(null);
				
			}
		});
		btnNewButton.setBounds(568, 0, 104, 23);
		frmAlhamaEmployeeDatabase.getContentPane().add(btnNewButton);
	}
}
