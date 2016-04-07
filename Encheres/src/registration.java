import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.sql.*;

public class registration {

	private JFrame frmEncheres;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_6;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private final Action action = new SwingAction();
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "abcd";
	/**
	 * Launch the application.
	 */
	   String name,username,question,answer,contact;
	char[] password;
	String questions[] = new String[50];
	int userid;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration window = new registration();
					window.frmEncheres.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEncheres = new JFrame();
		frmEncheres.setTitle("Encheres");
		frmEncheres.getContentPane().setBackground(Color.CYAN);
		frmEncheres.getContentPane().setForeground(Color.CYAN);
		frmEncheres.setBounds(100, 100, 612, 599);
		frmEncheres.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEncheres.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(74, 23, 297, 20);
		frmEncheres.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(74, 85, 46, 14);
		frmEncheres.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(361, 83, 110, 20);
		frmEncheres.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(74, 127, 95, 20);
		frmEncheres.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(361, 128, 86, 20);
		frmEncheres.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(74, 168, 95, 14);
		frmEncheres.getContentPane().add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("Re-Enter Password");
		lblReenterPassword.setBounds(74, 193, 153, 14);
		frmEncheres.getContentPane().add(lblReenterPassword);
		
		JLabel lblContactDetails = new JLabel("Contact No.");
		lblContactDetails.setBounds(74, 243, 106, 14);
		frmEncheres.getContentPane().add(lblContactDetails);
		
		textField_6 = new JTextField();
		textField_6.setBounds(361, 241, 86, 20);
		frmEncheres.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"What is your favourite flower?", "What is the name of your first pet?"}));
		
		comboBox.setBounds(361, 296, 173, 20);
		frmEncheres.getContentPane().add(comboBox);
		questions[0] = "In what city were you born?";
		questions[1] = "What is the name of your first school?";
		questions[2] = "What is your favorite movie?";
		questions[3] = "What is your favorite color?";
		questions[4] = "What is the name of your favorite pet?";

		for (int j= 0 ; j< 5; j++) {
			comboBox.addItem(questions[j]);
		}
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				Object selectedStateobj = comboBox.getSelectedItem();
				question = String.valueOf(selectedStateobj);
				//index = combobox1.getSelectedIndex();

			}
		});
		JLabel lblSecurityQuestion = new JLabel("Security Question");
		lblSecurityQuestion.setBounds(74, 299, 197, 14);
		frmEncheres.getContentPane().add(lblSecurityQuestion);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(74, 345, 128, 14);
		frmEncheres.getContentPane().add(lblAnswer);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(361, 343, 86, 20);
		frmEncheres.getContentPane().add(textField_4);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
				{

				getUserInformation();
					registerUserData();

				}
		});
		btnSubmit.setBounds(91, 437, 153, 23);
		frmEncheres.getContentPane().add(btnSubmit);
		
		JButton btnClearDetails = new JButton("Clear details");
		btnClearDetails.setBounds(319, 437, 164, 23);
		frmEncheres.getContentPane().add(btnClearDetails);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(361, 191, 110, 19);
		frmEncheres.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(361, 166, 110, 19);
		frmEncheres.getContentPane().add(passwordField_1);
	}
	public void getUserInformation() {
		 name = textField.getText();
		 password = passwordField_1.getPassword();
		 username = textField_1.getText();
		 contact = textField_6.getText();
		 answer = textField_4.getText();
		// u[i].getuserid();
		 //user_id=u.getUserid();
		 //Object selectedStateobj = comboBox.getSelectedItem();
		//	question = String.valueOf(selectedStateobj);

	}

	public void registerUserData() {
		Connection conn = null;
	      Statement stmt = null;
		try {

		  
			  Class.forName("com.mysql.jdbc.Driver");

		    
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		    
		      		  PreparedStatement updateemp = conn.prepareStatement("insert into user_detail values(?,?,?,?,?,?)");
		    	      updateemp.setInt(3,0000);
		    	      updateemp.setString(1,name);
		    	      updateemp.setString(2, String.valueOf(passwordField_1.getPassword()));
		    	      updateemp.setString(4,question);
		    	      updateemp.setString(6,contact);
		    	      updateemp.setString(5,answer);
		    	      updateemp.executeUpdate();
			//st1.execute("INSERT INTO User_Details (Name,Gender,Password,DOB,Mobile_Number,Email,Area,State,Nationality,StateIndex) VALUES('"+name+"','"+gender+"','"+password+"','"+dobb+"','"+mobileNumber+"','"+email+"','"+area+"','"+state+"','"+nationality+"',"+index+")");
			//st1.close();
			//con1.close();
			//JOptionPane.showMessageDialog(null,"Data are Registered Successfully");
		  

		}
		catch (Exception e) {
			System.out.println("Exception1 is " + e);
		}

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
