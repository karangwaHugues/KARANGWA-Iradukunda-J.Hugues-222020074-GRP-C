package database_payroll;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class Grade {

	private JFrame frmAlhamaEmployeeDatabase;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;
	private JTextField txt7;
	private JTextField txt8;
	private JTextField txt9;
	private JTextField txt10;
	private JTable table;
	private JTextField txt13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grade window = new Grade();
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
	public Grade() {
		initialize();
		
		connect();
		table_load();
		
	}

	Connection con;
	PreparedStatement pst;
	private JTextField txt11;
	private JTextField txt12;
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
			pst=con.prepareStatement("select * from grade");
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
		frmAlhamaEmployeeDatabase.setTitle("ALHAMA EMPLOYEE DATABASE AND PAYROLL MANAGEMENT SYSTEM");
		frmAlhamaEmployeeDatabase.setResizable(false);
		frmAlhamaEmployeeDatabase.setBounds(100, 100, 831, 617);
		frmAlhamaEmployeeDatabase.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmAlhamaEmployeeDatabase.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(-11, -30, 840, 656);
		frmAlhamaEmployeeDatabase.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBorder(new TitledBorder(null, "add grade", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 122, 415, 363);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("grade_id");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 23, 78, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblGradename = new JLabel("grade_name");
		lblGradename.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblGradename.setBounds(10, 48, 78, 14);
		panel_1.add(lblGradename);
		
		JLabel lblGradebasic = new JLabel("grade_basic");
		lblGradebasic.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblGradebasic.setBounds(10, 73, 66, 14);
		panel_1.add(lblGradebasic);
		
		JLabel lblGradeta = new JLabel("grade_ta");
		lblGradeta.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblGradeta.setBounds(10, 98, 78, 14);
		panel_1.add(lblGradeta);
		
		JLabel lblGradeDa = new JLabel("grade da");
		lblGradeDa.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblGradeDa.setBounds(10, 123, 46, 14);
		panel_1.add(lblGradeDa);
		
		JLabel lblGradehra = new JLabel("grade_hra");
		lblGradehra.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblGradehra.setBounds(10, 148, 66, 14);
		panel_1.add(lblGradehra);
		
		JLabel lblGradema = new JLabel("grade_ma");
		lblGradema.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblGradema.setBounds(10, 172, 66, 14);
		panel_1.add(lblGradema);
		
		JLabel lblGradebonus = new JLabel("grade_bonus");
		lblGradebonus.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblGradebonus.setBounds(10, 202, 66, 14);
		panel_1.add(lblGradebonus);
		
		JLabel lblGradepf = new JLabel("grade_pf");
		lblGradepf.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblGradepf.setBounds(10, 231, 66, 14);
		panel_1.add(lblGradepf);
		
		JLabel lblGradept = new JLabel("grade_pt");
		lblGradept.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblGradept.setBounds(10, 256, 46, 14);
		panel_1.add(lblGradept);
		
		txt1 = new JTextField();
		txt1.setBounds(168, 20, 86, 20);
		panel_1.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setFont(new Font("Agency FB", Font.BOLD, 16));
		txt2.setColumns(10);
		txt2.setBounds(168, 45, 86, 20);
		panel_1.add(txt2);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(168, 70, 86, 20);
		panel_1.add(txt3);
		
		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBounds(168, 95, 86, 20);
		panel_1.add(txt4);
		
		txt5 = new JTextField();
		txt5.setColumns(10);
		txt5.setBounds(168, 120, 86, 20);
		panel_1.add(txt5);
		
		txt6 = new JTextField();
		txt6.setColumns(10);
		txt6.setBounds(168, 145, 86, 20);
		panel_1.add(txt6);
		
		txt7 = new JTextField();
		txt7.setColumns(10);
		txt7.setBounds(168, 169, 86, 20);
		panel_1.add(txt7);
		
		txt8 = new JTextField();
		txt8.setColumns(10);
		txt8.setBounds(168, 199, 86, 20);
		panel_1.add(txt8);
		
		txt9 = new JTextField();
		txt9.setColumns(10);
		txt9.setBounds(168, 228, 86, 20);
		panel_1.add(txt9);
		
		txt10 = new JTextField();
		txt10.setColumns(10);
		txt10.setBounds(168, 253, 86, 20);
		panel_1.add(txt10);
		
		JLabel lblNewLabel_2 = new JLabel("dept_id");
		lblNewLabel_2.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 293, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		txt11 = new JTextField();
		txt11.setBounds(168, 290, 86, 20);
		panel_1.add(txt11);
		txt11.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("transaction_id");
		lblNewLabel_3.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 318, 121, 14);
		panel_1.add(lblNewLabel_3);
		
		txt12 = new JTextField();
		txt12.setBounds(168, 315, 86, 20);
		panel_1.add(txt12);
		txt12.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(435, 131, 380, 315);
		panel.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		panel_2.setBorder(new TitledBorder(null, "search by Grade_id", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(20, 517, 323, 70);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("grade_id");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 37, 46, 14);
		panel_2.add(lblNewLabel_1);
		
		txt13 = new JTextField();
		txt13.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					String grade_id1=txt13.getText();//to hold search value
					pst = con.prepareStatement("select grade_id,grade_name,grade_basic,grade_ta,grade_da,grade_hra,grade_ma,grade_bonus,grade_pf,grade_pt,dept_id,transaction_id from grade where grade_id=?");
					pst.setString(1,grade_id1);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()==true) {
					String grade_id = rs.getString(1);
						String grade_name = rs.getString(2);
						String grade_basic = rs.getString(3);
						String grade_ta = rs.getString(4);
						String grade_da = rs.getString(5);
						String grade_hra = rs.getString(6);
						String grade_ma = rs.getString(7);
						
						String grade_bonus = rs.getString(8);
						String grade_pf = rs.getString(9);
						String grade_pt = rs.getString(10);
						String dept_id = rs.getString(11);
						String transaction_id = rs.getString(12);
						
						
						txt1.setText(grade_id);
						txt2.setText(grade_name);
						txt3.setText(grade_basic);
						txt4.setText(grade_ta);
						txt5.setText(grade_da);
						txt6.setText(grade_hra);
						txt7.setText(grade_ma);
						txt8.setText(grade_bonus);
						txt9.setText(grade_pf);
						txt10.setText(grade_pt);
						txt11.setText(dept_id);
						txt12.setText(transaction_id);
						
					}
					else {
						txt2.setText("");
						
					}
				
				}
				catch (SQLException ex) {
				}
				
			}
		});
		txt13.setBounds(140, 31, 131, 20);
		panel_2.add(txt13);
		txt13.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String grade_id,grade_name,grade_basic,grade_ta,grade_da,grade_hra,grade_ma,grade_bonus,grade_pf,grade_pt,dept_id,transaction_id;
				grade_id=txt1.getText();
				grade_name=txt2.getText();
				grade_basic=txt3.getText();
				grade_ta=txt4.getText();
				grade_da=txt5.getText();
				grade_hra=txt6.getText();
				grade_ma=txt7.getText();
				grade_bonus=txt8.getText();
				grade_pf=txt9.getText();
				grade_pt=txt10.getText();
				dept_id=txt11.getText();
				transaction_id=txt11.getText();
				
				try{
					pst=con.prepareStatement("insert into grade(grade_id,grade_name,grade_basic,grade_ta,grade_da,grade_hra,grade_ma,grade_bonus,grade_pf,"
							+ "grade_pt,dept_id,transaction_id) values(?,?,?,?,?,?,?,?,?,?,?,?)");
					
					// invorked event in database
					pst.setString(1,grade_id);
					pst.setString(2,grade_name);
					pst.setString(3,grade_basic);
					pst.setString(4, grade_ta);
					pst.setString(5,grade_da);
					pst.setString(6,grade_hra);
					pst.setString(7,grade_ma);
					pst.setString(8,grade_bonus);
					pst.setString(9,grade_pf);
					pst.setString(10,grade_pt);
					pst.setString(11, dept_id);
					pst.setString(12, transaction_id);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Grade added succesfull Sucessful!!");
					table_load();
					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
					txt4.setText("");
					txt5.setText("");
					txt6.setText("");
					txt7.setText("");
					txt8.setText("");
					txt9.setText("");
					txt10.setText("");
					txt11.setText("");
					txt12.setText("");
				

					txt1.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}
				
			}
		});
		btnAdd.setBounds(353, 517, 89, 70);
		panel.add(btnAdd);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String grade_id,grade_name,grade_basic,grade_ta,grade_da,grade_hra,grade_ma,grade_bonus,grade_pf,grade_pt,dept_id,transaction_id;
				grade_id=txt1.getText();
				grade_name=txt2.getText();
				grade_basic=txt3.getText();
				grade_ta=txt4.getText();
				grade_da=txt5.getText();
				grade_hra=txt6.getText();
				grade_ma=txt7.getText();
				grade_bonus=txt8.getText();
				grade_pf=txt9.getText();
				grade_pt=txt10.getText();
				dept_id=txt11.getText();
				transaction_id=txt12.getText();
				grade_id=txt13.getText();
				
				try{
					pst=con.prepareStatement("update grade set grade_id=?,grade_name=?,grade_basic=?,grade_ta=?,grade_da=?,grade_hra=?,grade_ma=?,grade_bonus=?,"
							+ "grade_pf=?,grade_pt=?,dept_id=?,transaction_id=? where grade_id=?");
					pst.setString(1,grade_id);
					pst.setString(2,grade_name);
					pst.setString(3,grade_basic);
					pst.setString(4, grade_ta);
					pst.setString(5,grade_da);
					pst.setString(6,grade_hra);
					pst.setString(7,grade_ma);
					pst.setString(8,grade_bonus);
					pst.setString(9,grade_pf);
					pst.setString(10,grade_pt);
					pst.setString(11, dept_id);
					pst.setString(12, transaction_id);
					pst.setString(13, grade_id);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Grade update succesfull Sucessful!!");
			        table_load();
					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
					txt4.setText("");
					txt5.setText("");
					txt6.setText("");
					txt7.setText("");
					txt8.setText("");
					txt9.setText("");
					txt10.setText("");
					txt11.setText("");
					txt12.setText("");
					txt13.setText("");
				

					txt1.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}	
				
				
				
			}
		});
		btnUpdate.setBounds(445, 465, 89, 81);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String grade_id;
				
				grade_id=txt13.getText();
				
				try{
					pst=con.prepareStatement(" delete from grade where grade_id=?");
					pst.setString(1,grade_id);
					
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Grade deleted succesfull Sucessful!!");
					table_load();
					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
					txt4.setText("");
					txt5.setText("");
					txt6.setText("");
					txt7.setText("");
					txt8.setText("");
					txt9.setText("");
					txt10.setText("");
					txt11.setText("");
					txt12.setText("");
					txt13.setText("");
				

					txt1.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}
				
				
			}
		});
		btnDelete.setBounds(536, 465, 89, 81);
		panel.add(btnDelete);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnExit.setBounds(726, 465, 89, 81);
		panel.add(btnExit);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txt1.setText(null);
				txt2.setText(null);
				txt3.setText(null);
				txt4.setText(null);
				txt5.setText(null);
				txt6.setText(null);
				txt7.setText(null);
				txt8.setText(null);
				txt9.setText(null);
				txt10.setText(null);
				txt11.setText(null);
				txt12.setText(null);
				txt13.setText(null);
				
				
			}
		});
		btnClear.setBounds(627, 465, 89, 81);
		panel.add(btnClear);
		
		JLabel lblNewLabel_4 = new JLabel("COMPOSE NEW GRADE");
		lblNewLabel_4.setFont(new Font("Agency FB", Font.BOLD, 25));
		lblNewLabel_4.setBounds(296, 63, 296, 30);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("WELLCOME BACK ADMIN");
		lblNewLabel_5.setFont(new Font("Agency FB", Font.BOLD, 25));
		lblNewLabel_5.setBounds(286, 32, 216, 35);
		panel.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Signout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmAlhamaEmployeeDatabase.dispose();
				Login info = new Login();
				Login.main(null);
				
			}
		});
		btnNewButton.setFont(new Font("Agency FB", Font.BOLD, 18));
		btnNewButton.setBounds(741, 32, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmAlhamaEmployeeDatabase.dispose();
				HOME info = new HOME();
				HOME.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Agency FB", Font.BOLD, 18));
		btnNewButton_1.setBounds(10, 32, 89, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(266, 32, 245, 81);
		panel.add(panel_3);
		panel_3.setLayout(null);
	}
}
