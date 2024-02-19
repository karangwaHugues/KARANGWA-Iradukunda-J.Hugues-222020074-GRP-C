package database_payroll;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.print.PrintException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.SystemColor;

public class View {

	private JFrame frmAlhamaEmployeeDatabase;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
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
	public View() {
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
			pst=con.prepareStatement("select * from employee_salary_details");
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
		frmAlhamaEmployeeDatabase.setResizable(false);
		frmAlhamaEmployeeDatabase.setTitle("ALHAMA EMPLOYEE DATABASE AND PAYROLLMANAGEMENT SYSTEM\r\n");
		frmAlhamaEmployeeDatabase.getContentPane().setBackground(new Color(0, 128, 128));
		frmAlhamaEmployeeDatabase.setBounds(100, 100, 761, 388);
		frmAlhamaEmployeeDatabase.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmAlhamaEmployeeDatabase.getContentPane().setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 74, 713, 204);
		frmAlhamaEmployeeDatabase.getContentPane().add(scrollPane_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_2.setViewportView(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Monospaced", Font.PLAIN, 16));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "employee grade details", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(128, 0, 128)));
		panel.setBounds(0, 54, 735, 284);
		frmAlhamaEmployeeDatabase.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("VIEW");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table_load();
			}
		});
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNewButton.setBounds(144, 239, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnExit.setBounds(383, 241, 89, 23);
		panel.add(btnExit);
		
		JButton btnNewButton_1 = new JButton("PRINT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MessageFormat header = new MessageFormat("print is in progress");
				MessageFormat footer = new MessageFormat("page(0,number,integer)");
				
				
				try {
					table.print();
				}
				
				 catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(524, 241, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmAlhamaEmployeeDatabase.dispose();
				HOME info = new HOME();
				HOME.main(null);
				
			}
		});
		btnBack.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnBack.setBounds(0, 0, 89, 23);
		frmAlhamaEmployeeDatabase.getContentPane().add(btnBack);
		
		JButton btnSignout = new JButton("Signout");
		btnSignout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAlhamaEmployeeDatabase.dispose();
				Login info = new Login();
				Login.main(null);
			}
		});
		btnSignout.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnSignout.setBounds(640, 0, 105, 23);
		frmAlhamaEmployeeDatabase.getContentPane().add(btnSignout);
	}
}
