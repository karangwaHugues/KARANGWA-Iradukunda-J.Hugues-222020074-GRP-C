package database_payroll;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Employee_reg {

	private JFrame frame;
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
					Employee_reg window = new Employee_reg();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Employee_reg() {
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
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBackground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 698, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBorder(new TitledBorder(null, "Employe_reg form", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 66, 336, 251);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel l0 = new JLabel("Employee_id");
		l0.setFont(new Font("Agency FB", Font.BOLD, 16));
		l0.setBounds(10, 40, 78, 19);
		panel.add(l0);
		
		JLabel l3 = new JLabel("employee title");
		l3.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		l3.setBounds(10, 65, 98, 14);
		panel.add(l3);
		
		JLabel l4 = new JLabel("emp_name");
		l4.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		l4.setBounds(10, 90, 80, 14);
		panel.add(l4);
		
		JLabel l5 = new JLabel("emp_dob");
		l5.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		l5.setBounds(10, 119, 126, 14);
		panel.add(l5);
		
		JLabel l6 = new JLabel("emp_doj");
		l6.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		l6.setBounds(10, 150, 80, 14);
		panel.add(l6);
		
		JLabel l7 = new JLabel("emp_mobile_no");
		l7.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		l7.setBounds(10, 176, 115, 14);
		panel.add(l7);
		
		JLabel l8 = new JLabel("dept_id");
		l8.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		l8.setBounds(10, 204, 80, 14);
		panel.add(l8);
		
		txt1 = new JTextField();
		txt1.setColumns(10);
		txt1.setBackground(SystemColor.inactiveCaptionBorder);
		txt1.setBounds(135, 39, 195, 20);
		panel.add(txt1);
		
		txt2 = new JTextField();
		txt2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		txt2.setColumns(10);
		txt2.setBackground(SystemColor.inactiveCaptionBorder);
		txt2.setBounds(135, 62, 195, 20);
		panel.add(txt2);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBackground(SystemColor.inactiveCaptionBorder);
		txt3.setBounds(135, 88, 195, 20);
		panel.add(txt3);
		
		txt4 = new JTextField();
		txt4.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		txt4.setColumns(10);
		txt4.setBackground(SystemColor.inactiveCaptionBorder);
		txt4.setBounds(135, 116, 195, 20);
		panel.add(txt4);
		
		txt5 = new JTextField();
		txt5.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		txt5.setColumns(10);
		txt5.setBackground(SystemColor.inactiveCaptionBorder);
		txt5.setBounds(135, 147, 195, 20);
		panel.add(txt5);
		
		txt6 = new JTextField();
		txt6.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		txt6.setColumns(10);
		txt6.setBackground(SystemColor.inactiveCaptionBorder);
		txt6.setBounds(135, 173, 195, 20);
		panel.add(txt6);
		
		txt7 = new JTextField();
		txt7.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		txt7.setColumns(10);
		txt7.setBackground(SystemColor.inactiveCaptionBorder);
		txt7.setBounds(136, 201, 194, 20);
		panel.add(txt7);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(356, 66, 316, 241);
		frame.getContentPane().add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
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
					//table_load();
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
		btnNewButton.setBounds(10, 340, 129, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CHECK");
		btnNewButton_1.setFont(new Font("Monospaced", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_load();
			}
		});
		btnNewButton_1.setBounds(370, 340, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				APDMS info = new APDMS();
				APDMS.main(null);
				
			}
		});
		btnBack.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnBack.setBounds(0, 0, 74, 23);
		frame.getContentPane().add(btnBack);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(84, 13, 530, 53);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE OWN REGISTRATION FORM");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
		lblNewLabel.setBounds(46, 11, 462, 31);
		panel_1.add(lblNewLabel);
	}
}
