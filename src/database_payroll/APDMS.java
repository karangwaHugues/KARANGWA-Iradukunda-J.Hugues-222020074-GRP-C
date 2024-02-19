package database_payroll;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JTextArea;

public class APDMS {

	private JFrame frmAlhamaEmployeeDatabase;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					APDMS window = new APDMS();
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
	public APDMS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlhamaEmployeeDatabase = new JFrame();
		frmAlhamaEmployeeDatabase.setTitle("ALHAMA EMPLOYEE DATABASE AND PAYROLL MANAGEMENT SYSTEM\r\n");
		frmAlhamaEmployeeDatabase.getContentPane().setBackground(new Color(255, 0, 255));
		frmAlhamaEmployeeDatabase.setBounds(100, 100, 450, 300);
		frmAlhamaEmployeeDatabase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlhamaEmployeeDatabase.getContentPane().setLayout(null);
		
		JLabel L2 = new JLabel("MY EMPLOYEE MANAGER");
		L2.setBackground(SystemColor.inactiveCaptionBorder);
		L2.setFont(new Font("Agency FB", Font.BOLD, 18));
		L2.setBounds(121, 113, 170, 36);
		frmAlhamaEmployeeDatabase.getContentPane().add(L2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(244, 164, 96));
		panel.setBounds(0, 0, 434, 261);
		frmAlhamaEmployeeDatabase.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel L1 = new JLabel("WELCOME");
		L1.setBounds(145, 84, 176, 32);
		panel.add(L1);
		L1.setBackground(SystemColor.inactiveCaptionBorder);
		L1.setFont(new Font("Agency FB", Font.BOLD, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(56, 61, 304, 142);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton BT1 = new JButton("LOGIN ");
		BT1.setBounds(10, 102, 80, 29);
		panel_1.add(BT1);
		BT1.setIcon(null);
		BT1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmAlhamaEmployeeDatabase.dispose();
				Login info = new Login();
				Login.main(null);
				//Login.SetDefoultCloseOperation(operation:JFrame.EXIT_ON_CLOSE)
			
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		BT1.setBackground(SystemColor.inactiveCaptionBorder);
		BT1.setFont(new Font("Agency FB", Font.BOLD, 18));
		
		JButton bt2 = new JButton("Register");
		bt2.setBounds(100, 102, 99, 28);
		panel_1.add(bt2);
		bt2.setBackground(SystemColor.inactiveCaptionBorder);
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmAlhamaEmployeeDatabase.dispose();
				Employee_reg info = new Employee_reg();
			   Employee_reg.main(null);
				
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		bt2.setFont(new Font("Agency FB", Font.BOLD, 18));
		
		JButton bt3 = new JButton("USER");
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmAlhamaEmployeeDatabase.dispose();
				user_login info = new user_login();
				user_login.main(null);
			}
		});
		bt3.setFont(new Font("Agency FB", Font.BOLD, 18));
		bt3.setBackground(SystemColor.inactiveCaptionBorder);
		bt3.setBounds(205, 102, 89, 28);
		panel_1.add(bt3);
		
		JLabel lblNewLabel = new JLabel("ALHAMA  DATABASE AND PAYROLL MANAGEMENT SYSTEM");
		lblNewLabel.setBackground(SystemColor.text);
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 424, 27);
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 434, 38);
		panel.add(panel_2);
		panel_2.setLayout(null);
	}
}
