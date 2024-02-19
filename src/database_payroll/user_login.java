package database_payroll;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class user_login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_login window = new user_login();
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
	public user_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBackground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
if(textField.getText().isEmpty()||passwordField.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(null,"Fill the fields first");
				}
				else {
					try{
						String query="SELECT * FROM user WHERE email_id=? and password=?";
						 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/apms","root","");
						PreparedStatement pst = con.prepareStatement(query);
						pst.setString(1,textField.getText());
						pst.setString(2,passwordField.getText());
				
						ResultSet rs=pst.executeQuery();
						if(rs.next()) {
							JOptionPane.showMessageDialog(null,"login successfully.....");
							frame.dispose();
							HRM info=new HRM();
							HRM.main(null);
							
							
							
							
						}
						else {
							JOptionPane.showMessageDialog(null,"username and password doesn't match");
						}
					}
					catch(Exception ee) {System.out.println(ee);}
					
					
				}

				
				
				
			}
		});
		btnNewButton.setBounds(183, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 7));
		panel.setBounds(42, 94, 293, 122);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(128, 29, 155, 20);
		panel.add(textField);
		textField.setFont(new Font("Monospaced", Font.BOLD, 14));
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setBounds(17, 29, 101, 20);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setBounds(17, 85, 101, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 14));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 82, 155, 17);
		panel.add(passwordField);
		passwordField.setFont(new Font("Monospaced", Font.BOLD, 14));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(21, 26, 390, 57);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ALHAMA USER LOGIN");
		lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 25));
		lblNewLabel_2.setBounds(10, 11, 370, 35);
		panel_1.add(lblNewLabel_2);
	}
}
