package database_payroll;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

//import database_payroll.HOME;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.JCheckBox;

public class Login {

	private JFrame frame;
	private JTextField txt1;
	private JPasswordField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 592, 325);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 556, 275);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(9, 9, 9, 9, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBounds(232, 0, 327, 270);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		txt1 = new JTextField();
		txt1.setFont(new Font("Agency FB", Font.BOLD, 17));
		txt1.setBounds(168, 119, 132, 20);
		panel_1.add(txt1);
		txt1.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setFont(new Font("Agency FB", Font.BOLD, 17));
		pwd.setBounds(168, 163, 132, 20);
		panel_1.add(pwd);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 17));
		lblNewLabel.setBounds(52, 125, 79, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Agency FB", Font.BOLD, 17));
		lblPassword.setBounds(52, 166, 79, 14);
		panel_1.add(lblPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Agency FB", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = pwd.getText();
				String username = txt1.getText();
				
				if (password.contains("fidele9") && username.contains("fidele")) {
					pwd.setText(null);
					txt1.setText(null);
					JOptionPane.showMessageDialog(null, "login successful ");
					frame.dispose();
						HOME info = new HOME();
					HOME.main(null);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "invalid creditantials, "
							+ "if you are not admin you are allowe to register only", "allowed to register", JOptionPane.ERROR_MESSAGE);
					frame.dispose();
					APDMS info = new APDMS();
					APDMS.main(null);
					pwd.setText(null);
					txt1.setText(null);
				}
			}
		});
		btnNewButton.setBounds(110, 220, 89, 23);
		panel_1.add(btnNewButton);
		
		JLabel l3 = new JLabel("ADIMIN LOGIN");
		l3.setFont(new Font("Agency FB", Font.BOLD, 17));
		l3.setBounds(100, 77, 99, 14);
		panel_1.add(l3);
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/admn.png"));
		lblNewLabel_1.setIcon(img);
		lblNewLabel_1.setBounds(32, 77, 189, 160);
		panel.add(lblNewLabel_1);
	}

	private ImageIcon ImageIcon(URL resource) {
		// TODO Auto-generated method stub
		return null;
	}
}