package database_payroll;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HRM {

	private JFrame frmAlhamaDatabaseAnd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HRM window = new HRM();
					window.frmAlhamaDatabaseAnd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HRM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlhamaDatabaseAnd = new JFrame();
		frmAlhamaDatabaseAnd.setTitle("ALHAMA DATABASE AND EMPLOYEE MANAGEMENT SYSTEM");
		frmAlhamaDatabaseAnd.getContentPane().setBackground(new Color(0, 128, 128));
		frmAlhamaDatabaseAnd.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 76, 434, 62);
		frmAlhamaDatabaseAnd.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SYSTEM USER  ACTIVITIES");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 28));
		lblNewLabel.setBounds(10, 11, 414, 40);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add emp");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmAlhamaDatabaseAnd.dispose();
				Employee info = new Employee();
				Employee.main(null);
			}
		});
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNewButton.setBounds(66, 177, 112, 29);
		frmAlhamaDatabaseAnd.getContentPane().add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(66, 136, 301, 70);
		frmAlhamaDatabaseAnd.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnReport = new JButton("Report");
		btnReport.setBounds(200, 39, 101, 31);
		panel_1.add(btnReport);
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				frmAlhamaDatabaseAnd.dispose();
				View info = new View();
				View.main(null);
				
			}
		});
		btnReport.setFont(new Font("Monospaced", Font.BOLD, 16));
		
		JButton btnS = new JButton("Signout");
		btnS.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnS.setBounds(322, 0, 112, 23);
		frmAlhamaDatabaseAnd.getContentPane().add(btnS);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnBack.setBounds(0, 0, 89, 23);
		frmAlhamaDatabaseAnd.getContentPane().add(btnBack);
		frmAlhamaDatabaseAnd.setBounds(100, 100, 450, 279);
		frmAlhamaDatabaseAnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
