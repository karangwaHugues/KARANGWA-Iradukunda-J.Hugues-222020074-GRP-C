package database_payroll;

import java.awt.EventQueue;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

//import com.mysql.jdbc.PreparedStatement;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;

public class HOME {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HOME window = new HOME();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ClassNotFoundException 
	 */
	public HOME()  {
		initialize();
		//connect();
	}
	
	//Connection con;
	//PreparedStatement pst;
	
	//public void connect() throws ClassNotFoundException {
		//try {
			//Class.forName("com.mysql.jdbc.driver");
			// con = DriverManager.getConnection("jdbc:mysql://locolhost/apms", "root","");
	//}
		//catch (ClassCastException ex)
		//{
	//}
	//	catch (SQLException ex)
	//	{
	//	}
	//	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setFont(new Font("Agency FB", Font.BOLD, 16));
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 522, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton bt1 = new JButton("Add new employee");
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Employee info = new Employee();
				Employee.main(null);
			}
		});
		bt1.setBackground(SystemColor.activeCaption);
		bt1.setFont(new Font("Agency FB", Font.BOLD, 16));
		bt1.setBounds(113, 109, 242, 23);
		frame.getContentPane().add(bt1);
		
		JButton bt2 = new JButton("Add new department");
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Department info =new Department();
				Department.main(null);
		
			}
		});
		bt2.setBackground(SystemColor.activeCaption);
		bt2.setFont(new Font("Agency FB", Font.BOLD, 16));
		bt2.setBounds(113, 141, 242, 23);
		frame.getContentPane().add(bt2);
		
		JButton bt3 = new JButton("Add new Grade");
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Grade info = new Grade();
				Grade.main(null);
			}
		});
		bt3.setBackground(SystemColor.activeCaption);
		bt3.setFont(new Font("Agency FB", Font.BOLD, 16));
		bt3.setBounds(113, 175, 242, 23);
		frame.getContentPane().add(bt3);
		
		JButton bt4 = new JButton("Employee Grade Details");
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Employee_grade_details info = new Employee_grade_details();
				Employee_grade_details.main(null);
				//JOptionPane.showMessageDialog(null, "HABAKUBAHO FIDELE is working on this system", "Notification", JOptionPane.ERROR_MESSAGE);
			}
		});
		bt4.setBackground(SystemColor.activeCaption);
		bt4.setFont(new Font("Agency FB", Font.BOLD, 16));
		bt4.setBounds(113, 209, 242, 23);
		frame.getContentPane().add(bt4);
		
		JButton bt5 = new JButton("Monthly Salary");
		bt5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Employee_salary_details info = new Employee_salary_details();
				Employee_salary_details.main(null);
			}
		});
		bt5.setBackground(SystemColor.activeCaption);
		bt5.setFont(new Font("Agency FB", Font.BOLD, 16));
		bt5.setBounds(113, 243, 242, 23);
		frame.getContentPane().add(bt5);
		
		JButton bt6 = new JButton("Generate Report");
		bt6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "HABAKUBAHO FIDELE is working on this system", "Notification", JOptionPane.ERROR_MESSAGE);
				frame.dispose();
				View info = new View();
				View.main(null);
				
				
			}
		});
		bt6.setBackground(SystemColor.activeCaption);
		bt6.setFont(new Font("Agency FB", Font.BOLD, 16));
		bt6.setBounds(113, 277, 242, 23);
		frame.getContentPane().add(bt6);
		
		JButton bt7 = new JButton("Signout");
		bt7.setBackground(SystemColor.activeCaption);
		bt7.setIcon(null);
		bt7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Login info = new Login();
				Login.main(null);
				//this.Dispose();
			}
		});
		bt7.setFont(new Font("Agency FB", Font.BOLD, 16));
		bt7.setBounds(429, 0, 77, 23);
		frame.getContentPane().add(bt7);
		
		JButton bt8 = new JButton(" USERS");
		bt8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				User info = new User();
				User.main(null);
				
			}
		});
		bt8.setBackground(SystemColor.activeCaption);
		bt8.setFont(new Font("Agency FB", Font.BOLD, 16));
		bt8.setBounds(113, 311, 242, 23);
		frame.getContentPane().add(bt8);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(165, 42, 42), new Color(128, 0, 0), new Color(128, 0, 0), new Color(128, 0, 0)));
		panel.setBounds(20, 90, 453, 264);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(137, 0, 136, 36);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel l1 = new JLabel("WELCOME ADMIN");
		l1.setBounds(10, 11, 126, 14);
		panel_1.add(l1);
		l1.setBackground(SystemColor.activeCaption);
		l1.setFont(new Font("Agency FB", Font.BOLD, 16));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(20, 34, 453, 45);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("System Administrator Activities");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 11, 433, 23);
		panel_2.add(lblNewLabel);
	}

}
