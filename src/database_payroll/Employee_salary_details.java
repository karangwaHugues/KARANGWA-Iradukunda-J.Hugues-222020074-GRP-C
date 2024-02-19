package database_payroll;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JTextArea;

public class Employee_salary_details {

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
	private JTextField txt11;
	private JTextField txt12;
	private JTextField txt13;
	private JTextField txt14;
	private JTextField txt15;
	private JTextField txt16;
	private JTextField txt17;
	private JTextField txt18;
	
	double emp_basic,emp_da,emp_ta,emp_hra,emp_ma,emp_bonus,emp_pf,emp_pt,emp_gross,emp_total_salary,gross,net,emp_grade_id,base;
	double emp_da1,emp_ta1,emp_hra1,emp_ma1,emp_bonus1,emp_pf1,emp_pt1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee_salary_details window = new Employee_salary_details();
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
	public Employee_salary_details() {
		initialize();
		connect();
		//table_load();
	}

	Connection con;
	PreparedStatement pst;
	protected JTextArea rtfpayslip;
	//ResultSet rs;
	
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
	
	/*public void table_load() {
		try {
			pst=con.prepareStatement("select * from employee_grade_details");
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}*/
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlhamaEmployeeDatabase = new JFrame();
		frmAlhamaEmployeeDatabase.setFont(new Font("Monospaced", Font.BOLD, 17));
		frmAlhamaEmployeeDatabase.setTitle("ALHAMA EMPLOYEE DATABASE MANAGEMENT SYSTEM");
		frmAlhamaEmployeeDatabase.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		frmAlhamaEmployeeDatabase.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmAlhamaEmployeeDatabase.setResizable(false);
		frmAlhamaEmployeeDatabase.getContentPane().setBackground(new Color(0, 128, 128));
		frmAlhamaEmployeeDatabase.setBounds(100, 100, 774, 554);
		frmAlhamaEmployeeDatabase.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(128, 0, 0), new Color(128, 128, 0), new Color(128, 0, 0), new Color(128, 0, 0)));
		panel.setBounds(10, 82, 357, 258);
		frmAlhamaEmployeeDatabase.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("transaction_id");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 30, 129, 20);
		panel.add(lblNewLabel);
		
		txt1 = new JTextField();
		txt1.setBounds(161, 30, 186, 20);
		panel.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(161, 58, 186, 20);
		panel.add(txt2);
		
		JLabel lblEmpid = new JLabel("emp_id");
		lblEmpid.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblEmpid.setBounds(10, 58, 129, 20);
		panel.add(lblEmpid);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(161, 89, 186, 20);
		panel.add(txt3);
		
		JLabel lblEmpsalarymonth = new JLabel("emp_salary_month");
		lblEmpsalarymonth.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblEmpsalarymonth.setBounds(10, 89, 129, 20);
		panel.add(lblEmpsalarymonth);
		
		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBounds(161, 115, 186, 20);
		panel.add(txt4);
		
		JLabel lblEmpsalaryyear = new JLabel("emp_salary_year");
		lblEmpsalaryyear.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblEmpsalaryyear.setBounds(10, 115, 129, 20);
		panel.add(lblEmpsalaryyear);
		
		txt5 = new JTextField();
		txt5.setColumns(10);
		txt5.setBounds(189, 146, 158, 20);
		panel.add(txt5);
		
		JLabel lblEmpsalaryeimbursment = new JLabel("emp_salary_eimbursment");
		lblEmpsalaryeimbursment.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblEmpsalaryeimbursment.setBounds(10, 146, 176, 20);
		panel.add(lblEmpsalaryeimbursment);
		
		txt6 = new JTextField();
		txt6.setColumns(10);
		txt6.setBounds(161, 177, 186, 20);
		panel.add(txt6);
		
		JLabel lblEmpdeptid = new JLabel("emp_dept_id");
		lblEmpdeptid.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblEmpdeptid.setBounds(10, 177, 129, 20);
		panel.add(lblEmpdeptid);
		
		txt7 = new JTextField();
		txt7.setColumns(10);
		txt7.setBounds(161, 208, 186, 20);
		panel.add(txt7);
		
		JLabel lblEmpgradeid = new JLabel("emp_grade_id");
		lblEmpgradeid.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblEmpgradeid.setBounds(10, 208, 129, 20);
		panel.add(lblEmpgradeid);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(377, 82, 357, 322);
		frmAlhamaEmployeeDatabase.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txt9 = new JTextField();
		txt9.setColumns(10);
		txt9.setBounds(180, 56, 167, 20);
		panel_1.add(txt9);
		
		JLabel lblEmpda = new JLabel("emp_da");
		lblEmpda.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblEmpda.setBounds(10, 56, 129, 20);
		panel_1.add(lblEmpda);
		
		txt10 = new JTextField();
		txt10.setColumns(10);
		txt10.setBounds(180, 80, 167, 20);
		panel_1.add(txt10);
		
		JLabel lblEmpta = new JLabel("emp_ta");
		lblEmpta.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblEmpta.setBounds(10, 80, 129, 20);
		panel_1.add(lblEmpta);
		
		txt11 = new JTextField();
		txt11.setColumns(10);
		txt11.setBounds(180, 111, 167, 20);
		panel_1.add(txt11);
		
		JLabel lblEmphra = new JLabel("emp_hra");
		lblEmphra.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblEmphra.setBounds(10, 111, 129, 20);
		panel_1.add(lblEmphra);
		
		txt12 = new JTextField();
		txt12.setColumns(10);
		txt12.setBounds(180, 136, 167, 20);
		panel_1.add(txt12);
		
		JLabel lblEmpma = new JLabel("emp_ma");
		lblEmpma.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblEmpma.setBounds(10, 136, 129, 20);
		panel_1.add(lblEmpma);
		
		txt13 = new JTextField();
		txt13.setColumns(10);
		txt13.setBounds(180, 167, 167, 20);
		panel_1.add(txt13);
		
		JLabel lblEmpbonus = new JLabel("emp_bonus");
		lblEmpbonus.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblEmpbonus.setBounds(10, 167, 129, 20);
		panel_1.add(lblEmpbonus);
		
		txt14 = new JTextField();
		txt14.setColumns(10);
		txt14.setBounds(180, 198, 167, 20);
		panel_1.add(txt14);
		
		JLabel lblEmppf = new JLabel("emp_pf");
		lblEmppf.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblEmppf.setBounds(10, 198, 129, 20);
		panel_1.add(lblEmppf);
		
		txt15 = new JTextField();
		txt15.setColumns(10);
		txt15.setBounds(180, 229, 167, 20);
		panel_1.add(txt15);
		
		JLabel lblEmppt = new JLabel("emp_pt");
		lblEmppt.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblEmppt.setBounds(10, 229, 129, 20);
		panel_1.add(lblEmppt);
		
		txt16 = new JTextField();
		txt16.setColumns(10);
		txt16.setBounds(180, 260, 167, 20);
		panel_1.add(txt16);
		
		JLabel lblEmpgross = new JLabel("emp_gross");
		lblEmpgross.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblEmpgross.setBounds(10, 260, 129, 20);
		panel_1.add(lblEmpgross);
		
		txt17 = new JTextField();
		txt17.setColumns(10);
		txt17.setBounds(239, 291, 108, 20);
		panel_1.add(txt17);
		
		JLabel lblEmptotalsalary = new JLabel("emp_total_salary");
		lblEmptotalsalary.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblEmptotalsalary.setBounds(10, 291, 129, 20);
		panel_1.add(lblEmptotalsalary);
		
		JButton btnGross = new JButton("Press");
		btnGross.setBounds(90, 257, 94, 23);
		panel_1.add(btnGross);
		btnGross.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				emp_basic=Double.parseDouble(txt8.getText());
				emp_da=Double.parseDouble(txt9.getText());
				emp_ta=Double.parseDouble(txt10.getText());
				emp_hra=Double.parseDouble(txt11.getText());
				emp_ma=Double.parseDouble(txt12.getText());
				emp_bonus=Double.parseDouble(txt13.getText());
				//emp_pf=Double.parseDouble(txt14.getText());
				//emp_pt=Double.parseDouble(txt14.getText());
				//emp_gross=Double.parseDouble(txt16.getText());
				//emp_total_salary=Double.parseDouble(txt17.getText());
				gross=emp_basic+emp_da+emp_ta+emp_hra+emp_ma+emp_bonus;
				String emp_gross= String.format("%.2f", gross);
				txt16.setText(emp_gross);
				
				
			}
		});
		btnGross.setFont(new Font("Monospaced", Font.BOLD, 16));
		
		JButton btnTotsala = new JButton("Press");
		btnTotsala.setBounds(149, 288, 92, 23);
		panel_1.add(btnTotsala);
		btnTotsala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				emp_pf=Double.parseDouble(txt14.getText());
				emp_pt=Double.parseDouble(txt14.getText());
				emp_gross=Double.parseDouble(txt16.getText());
				//emp_total_salary=Double.parseDouble(txt17.getText());
				net=(emp_gross-emp_pt)-emp_pf;
				String emp_total_salary= String.format("%.2f", net);
				txt17.setText(emp_total_salary);
				
				
			}
		});
		btnTotsala.setFont(new Font("Monospaced", Font.BOLD, 16));
		
		JLabel lblEmpbasic = new JLabel("emp_basic");
		lblEmpbasic.setBounds(10, 25, 129, 20);
		panel_1.add(lblEmpbasic);
		lblEmpbasic.setFont(new Font("Monospaced", Font.BOLD, 14));
		
		txt8 = new JTextField();
		txt8.setBounds(180, 23, 167, 20);
		panel_1.add(txt8);
		txt8.setColumns(10);
		
		JButton btnPress = new JButton("press");
		btnPress.setBounds(158, 2, 94, 20);
		panel_1.add(btnPress);
		btnPress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				emp_grade_id=Double.parseDouble(txt7.getText());
				//emp_pt=Double.parseDouble(txt14.getText());
				//emp_gross=Double.parseDouble(txt16.getText());
				//emp_total_salary=Double.parseDouble(txt17.getText());
				if(emp_grade_id==1) {
					base=200000;
					String emp_basic= String.format("%.2f", base);
					txt8.setText(emp_basic);	
				}
				else if(emp_grade_id==2) {
					base=300000;
					String emp_basic= String.format("%.2f", base);
					txt8.setText(emp_basic);
				}
				else if(emp_grade_id==3) {
					base=400000;
					String emp_basic= String.format("%.2f", base);
					txt8.setText(emp_basic);
				}
				else {
					base=0;
					String emp_basic= String.format("%.2f", base);
					txt8.setText(emp_basic);
				}
				//emp_total_salary=Double.parseDouble(txt17.getText());
				//emp_da1,emp_ta1,emp_hra1,emp_ma1,emp_bonus1,emp_pf1,emp_pt1;
				//emp_da1=(emp_basic*20);
				//String emp_da= String.format("%.2f", emp_da1);
				//txt9.setText(emp_da);
				emp_basic=Double.parseDouble(txt8.getText());
				//emp_da=Double.parseDouble(txt9.getText());
				//emp_da1,emp_ta1,emp_hra1,emp_ma1,emp_bonus1,emp_pf1,emp_pt1;
				emp_da1=(emp_basic*20)/100;
				String emp_da= String.format("%.2f", emp_da1);
				txt9.setText(emp_da);
				//-------------------------------------------------------------------
				
				emp_basic=Double.parseDouble(txt8.getText());
				//emp_da=Double.parseDouble(txt9.getText());
				//emp_da1,emp_ta1,emp_hra1,emp_ma1,emp_bonus1,emp_pf1,emp_pt1;
				emp_ta1=(emp_basic*10)/100;
				String emp_ta= String.format("%.2f", emp_ta1);
				txt10.setText(emp_ta);
				//--------------------------------------------------
				emp_basic=Double.parseDouble(txt8.getText());
				//emp_da=Double.parseDouble(txt9.getText());
				//emp_da1,emp_ta1,emp_hra1,emp_ma1,emp_bonus1,emp_pf1,emp_pt1;
				emp_hra1=(emp_basic*12)/100;
				String emp_hra= String.format("%.2f", emp_hra1);
				txt11.setText(emp_hra);
				//-----------------------------------------------------------------
				emp_basic=Double.parseDouble(txt8.getText());
				//emp_da=Double.parseDouble(txt9.getText());
				//emp_da1,emp_ta1,emp_hra1,emp_ma1,emp_bonus1,emp_pf1,emp_pt1;
				emp_ma1=(emp_basic*2)/100;
				String emp_ma= String.format("%.2f", emp_ma1);
				txt12.setText(emp_ma);
				//-------------------------------------------------
				emp_basic=Double.parseDouble(txt8.getText());
				//emp_da=Double.parseDouble(txt9.getText());
				//emp_da1,emp_ta1,emp_hra1,emp_ma1,emp_bonus1,emp_pf1,emp_pt1;
				emp_bonus1=(emp_basic*5)/100;
				String emp_bonus= String.format("%.2f", emp_bonus1);
				txt13.setText(emp_bonus);
				//-----------------------------------------------------
				emp_basic=Double.parseDouble(txt8.getText());
				//emp_da=Double.parseDouble(txt9.getText());
				//emp_da1,emp_ta1,emp_hra1,emp_ma1,emp_bonus1,emp_pf1,emp_pt1;
				emp_pf1=(emp_basic*1)/100;
				String emp_pf= String.format("%.2f", emp_pf1);
				txt14.setText(emp_pf);
				//-----------------------------------------------------
				emp_basic=Double.parseDouble(txt8.getText());
				//emp_da=Double.parseDouble(txt9.getText());
				//emp_da1,emp_ta1,emp_hra1,emp_ma1,emp_bonus1,emp_pf1,emp_pt1;
				emp_pt1=(emp_basic*18)/100;
				String emp_pt= String.format("%.2f", emp_pt1);
				txt15.setText(emp_pt);
				
				
			}
		});
		btnPress.setFont(new Font("Monospaced", Font.BOLD, 16));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		panel_2.setBorder(new TitledBorder(null, "search", TitledBorder.RIGHT, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 399, 350, 73);
		frmAlhamaEmployeeDatabase.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		txt18 = new JTextField();
		txt18.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				try {
					String transaction_id1=txt18.getText();
					pst = con.prepareStatement("select transaction_id,emp_id,emp_salary_month,emp_salary_year,emp_salary_eimbursment,emp_dept_id,emp_grade_id,emp_basic,"
							+ "emp_da,emp_ta,emp_hra,emp_ma,emp_bonus,emp_pf,emp_pt,emp_gross,emp_total_salary from employee_salary_details where transaction_id=?");
					pst.setString(1, transaction_id1);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()==true) {
					String transaction_id = rs.getString(1);
						String emp_id = rs.getString(2);
						String emp_salary_month = rs.getString(3);
						String emp_salary_year = rs.getString(4);
						String emp_salary_eimbursment = rs.getString(5);
						String emp_dept_id = rs.getString(6);
						
						String emp_grade_id = rs.getString(7);
						String emp_basic = rs.getString(8);
						String emp_da = rs.getString(9);
						String emp_ta = rs.getString(10);
						String emp_hra = rs.getString(11);
						String emp_ma = rs.getString(12);
						String emp_bonus = rs.getString(13);
						String emp_pf = rs.getString(14);
						String emp_pt = rs.getString(15);
						String emp_gross = rs.getString(16);
						String emp_total_salary = rs.getString(17);
						
						txt1.setText(transaction_id);
						txt2.setText(emp_id);
						txt3.setText(emp_salary_month);
						txt4.setText(emp_salary_year);
						txt5.setText(emp_salary_eimbursment);
						txt6.setText( emp_dept_id);
						
						txt7.setText(emp_grade_id );
						txt8.setText(emp_basic);
						txt9.setText(emp_da);
						txt10.setText(emp_ta);
						txt11.setText( emp_hra);
						txt12.setText( emp_ma);
						txt13.setText(emp_bonus);
						txt14.setText(emp_pf);
						txt15.setText(emp_pt);
						txt16.setText(emp_gross);
						txt17.setText(emp_total_salary);
						
					}
					else {
						txt1.setText("");
						
					}
				
				}
				catch (SQLException ex) {
				}
				
				
				
			}
		});
		txt18.setColumns(10);
		txt18.setBounds(161, 30, 179, 20);
		panel_2.add(txt18);
		
		JLabel lblNewLabel_1 = new JLabel("transaction_id");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblNewLabel_1.setBounds(22, 30, 129, 20);
		panel_2.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String transaction_id,emp_id,emp_salary_month,emp_salary_year,emp_salary_eimbursment,emp_dept_id,
				emp_grade_id,emp_basic,emp_da,emp_ta,emp_hra,emp_ma,emp_bonus,emp_pf,emp_pt,emp_gross,emp_total_salary;
				transaction_id=txt1.getText();
				emp_id=txt2.getText();
				emp_salary_month=txt3.getText();
				emp_salary_year=txt4.getText();
				emp_salary_eimbursment=txt5.getText();
				emp_dept_id=txt6.getText();
				
				emp_grade_id=txt7.getText();
				emp_basic=txt8.getText();
				emp_da=txt9.getText();
				emp_ta=txt10.getText();
				emp_hra=txt11.getText();
				emp_ma=txt12.getText();
				
				emp_bonus=txt13.getText();
				emp_pf=txt14.getText();
				emp_pt=txt15.getText();
				emp_gross=txt16.getText();
				emp_total_salary=txt17.getText();
				
				try{
					pst=con.prepareStatement("insert into employee_salary_details (transaction_id,emp_id,emp_salary_month,emp_salary_year,emp_salary_eimbursment,emp_dept_id,"
+ "emp_grade_id,emp_basic,emp_da,emp_ta,emp_hra,emp_ma,emp_bonus,emp_pf,emp_pt,emp_gross,emp_total_salary) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					pst.setString(1,transaction_id);
					pst.setString(2, emp_id);
					pst.setString(3, emp_salary_month);
					pst.setString(4, emp_salary_year);
					pst.setString(5, emp_salary_eimbursment);
					pst.setString(6, emp_dept_id);
					
					pst.setString(7,emp_grade_id);
					pst.setString(8, emp_basic);
					pst.setString(9, emp_da);
					pst.setString(10, emp_ta);
					pst.setString(11, emp_hra);
					pst.setString(12,emp_ma);
					pst.setString(13,emp_bonus);
					pst.setString(14, emp_pf);
					pst.setString(15, emp_pt);
					pst.setString(16, emp_gross);
					pst.setString(17,emp_total_salary);
					
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "saved Sucessful!!");
					//table_load();
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
					txt14.setText("");
					txt15.setText("");
					txt16.setText("");
					txt17.setText("");
					
					

					txt1.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}
				
				
			}
		});
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNewButton.setBounds(377, 415, 89, 23);
		frmAlhamaEmployeeDatabase.getContentPane().add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String transaction_id,emp_id,emp_salary_month,emp_salary_year,emp_salary_eimbursment,emp_dept_id,
				emp_grade_id,emp_basic,emp_da,emp_ta,emp_hra,emp_ma,emp_bonus,emp_pf,emp_pt,emp_gross,emp_total_salary;
				transaction_id=txt1.getText();
				emp_id=txt2.getText();
				emp_salary_month=txt3.getText();
				emp_salary_year=txt4.getText();
				emp_salary_eimbursment=txt5.getText();
				emp_dept_id=txt6.getText();
				
				emp_grade_id=txt7.getText();
				emp_basic=txt8.getText();
				emp_da=txt9.getText();
				emp_ta=txt10.getText();
				emp_hra=txt11.getText();
				emp_ma=txt12.getText();
				
				emp_bonus=txt13.getText();
				emp_pf=txt14.getText();
				emp_pt=txt15.getText();
				emp_gross=txt16.getText();
				emp_total_salary=txt17.getText();
				transaction_id=txt18.getText();
				
				try{
					pst=con.prepareStatement("update employee_salary_details set transaction_id=?,emp_id=?,emp_salary_month=?,emp_salary_year=?,emp_salary_eimbursment=?,emp_dept_id=?,"
+ "emp_grade_id=?,emp_basic=?,emp_da=?,emp_ta=?,emp_hra=?,emp_ma=?,emp_bonus=?,emp_pf=?,emp_pt=?,emp_gross=?,emp_total_salary=? where transaction_id=?");
					pst.setString(1,transaction_id);
					pst.setString(2, emp_id);
					pst.setString(3, emp_salary_month);
					pst.setString(4, emp_salary_year);
					pst.setString(5, emp_salary_eimbursment);
					pst.setString(6, emp_dept_id);
					
					pst.setString(7,emp_grade_id);
					pst.setString(8, emp_basic);
					pst.setString(9, emp_da);
					pst.setString(10, emp_ta);
					pst.setString(11, emp_hra);
					pst.setString(12,emp_ma);
					pst.setString(13,emp_bonus);
					pst.setString(14, emp_pf);
					pst.setString(15, emp_pt);
					pst.setString(16, emp_gross);
					pst.setString(17,emp_total_salary);
					pst.setString(18,transaction_id);
					
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "updated!!");
					//table_load();
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
					txt14.setText("");
					txt15.setText("");
					txt16.setText("");
					txt17.setText("");
					
					

					txt1.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}
				
				
			}
		});
		btnUpdate.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnUpdate.setBounds(468, 415, 105, 23);
		frmAlhamaEmployeeDatabase.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String transaction_id;
				transaction_id=txt1.getText();
				
				
				try{
					pst=con.prepareStatement("delete from employee_salary_details where transaction_id=?");
					pst.setString(1,transaction_id);
					
					
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "deleted!!");
					//table_load();
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
					txt14.setText("");
					txt15.setText("");
					txt16.setText("");
					txt17.setText("");
					
					

					txt1.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}	
				
				
				
				
			}
		});
		btnDelete.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnDelete.setBounds(577, 415, 99, 23);
		frmAlhamaEmployeeDatabase.getContentPane().add(btnDelete);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
				txt14.setText("");
				txt15.setText("");
				txt16.setText("");
				txt17.setText("");	
				
				
			}
		});
		btnClear.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnClear.setBounds(680, 415, 85, 23);
		frmAlhamaEmployeeDatabase.getContentPane().add(btnClear);
		
		JButton btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmAlhamaEmployeeDatabase.dispose();
				View info = new View();
				View.main(null);
				
			}
		});
		btnView.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnView.setBounds(377, 449, 89, 23);
		frmAlhamaEmployeeDatabase.getContentPane().add(btnView);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		btnExit.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnExit.setBounds(494, 449, 89, 23);
		frmAlhamaEmployeeDatabase.getContentPane().add(btnExit);
		
		JButton btnReport = new JButton("REPORT");
		btnReport.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnReport.setBounds(593, 449, 116, 23);
		frmAlhamaEmployeeDatabase.getContentPane().add(btnReport);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(6, 5, 6, 6, (Color) new Color(0, 0, 0)));
		panel_3.setBackground(SystemColor.inactiveCaptionBorder);
		panel_3.setBounds(371, 415, 394, 59);
		frmAlhamaEmployeeDatabase.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ALHAMA PAYROLL MANAGEMENT SYSTEM");
		lblNewLabel_2.setBackground(SystemColor.inactiveCaptionBorder);
		lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 30));
		lblNewLabel_2.setBounds(29, 48, 607, 23);
		frmAlhamaEmployeeDatabase.getContentPane().add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel_4.setBackground(SystemColor.inactiveCaptionBorder);
		panel_4.setBounds(10, 32, 666, 44);
		frmAlhamaEmployeeDatabase.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnSignout = new JButton("Signout");
		btnSignout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmAlhamaEmployeeDatabase.dispose();
				Login info = new Login();
				Login.main(null);
				
			}
		});
		btnSignout.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnSignout.setBounds(660, 0, 105, 23);
		frmAlhamaEmployeeDatabase.getContentPane().add(btnSignout);
		
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
	}
}
