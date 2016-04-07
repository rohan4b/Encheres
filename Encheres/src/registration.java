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

	private JFrame registrationFrame;
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
					window.registrationFrame.setVisible(true);
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
		registrationFrame = new JFrame();
		registrationFrame.setTitle("Encheres");
		registrationFrame.getContentPane().setBackground(Color.CYAN);
		registrationFrame.getContentPane().setForeground(Color.CYAN);
		registrationFrame.setBounds(100, 100, 612, 599);
		registrationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		registrationFrame.getContentPane().setLayout(null);
		
		JLabel RegistrationText = new JLabel("Registration");
		RegistrationText.setFont(new Font("Tahoma", Font.PLAIN, 17));
		RegistrationText.setForeground(Color.BLACK);
		RegistrationText.setBounds(74, 23, 297, 20);
		registrationFrame.getContentPane().add(RegistrationText);
		
		JLabel NameLabel = new JLabel("Name");
		NameLabel.setBounds(74, 85, 46, 14);
		registrationFrame.getContentPane().add(NameLabel);
		
		textField = new JTextField();
		textField.setBounds(361, 83, 110, 20);
		registrationFrame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel UsernameLabel = new JLabel("Username");
		UsernameLabel.setBounds(74, 127, 95, 20);
		registrationFrame.getContentPane().add(UsernameLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(361, 128, 86, 20);
		registrationFrame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setBounds(74, 168, 95, 14);
		registrationFrame.getContentPane().add(PasswordLabel);
		
		JLabel ReenterPasswordLabel = new JLabel("Re-Enter Password");
		ReenterPasswordLabel.setBounds(74, 193, 153, 14);
		registrationFrame.getContentPane().add(ReenterPasswordLabel);
		
		JLabel ContactDetailsLabel = new JLabel("Contact No.");
		ContactDetailsLabel.setBounds(74, 243, 106, 14);
		registrationFrame.getContentPane().add(ContactDetailsLabel);
		
		textField_6 = new JTextField();
		textField_6.setBounds(361, 241, 86, 20);
		registrationFrame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"What is your favourite flower?", "What is the name of your first pet?"}));
		
		comboBox.setBounds(361, 296, 173, 20);
		registrationFrame.getContentPane().add(comboBox);
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
		JLabel SecurityQuestionLabel = new JLabel("Security Question");
		SecurityQuestionLabel.setBounds(74, 299, 197, 14);
		registrationFrame.getContentPane().add(SecurityQuestionLabel);
		
		JLabel AnswerLabel = new JLabel("Answer");
		AnswerLabel.setBounds(74, 345, 128, 14);
		registrationFrame.getContentPane().add(AnswerLabel);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(361, 343, 86, 20);
		registrationFrame.getContentPane().add(textField_4);
		
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
		registrationFrame.getContentPane().add(btnSubmit);
		
		JButton btnClearDetails = new JButton("Clear details");
		btnClearDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 textField.setText("");
				 passwordField_1.setText("");
				 passwordField.setText("");
				  textField_1.setText("");
				 textField_6.setText("");
				  textField_4.setText("");
			}
		});
		btnClearDetails.setBounds(319, 437, 164, 23);
		registrationFrame.getContentPane().add(btnClearDetails);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(361, 191, 110, 19);
		registrationFrame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(361, 166, 110, 19);
		registrationFrame.getContentPane().add(passwordField_1);
		
		registrationFrame.setVisible(true);
		
	}
	//registrationFrame.setVisible(ture);
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
