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

public class RegisterWindow {

	private JFrame frmEncheres;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_6;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterWindow window = new RegisterWindow();
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
	public RegisterWindow() {
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
		frmEncheres.setBounds(100, 100, 473, 599);
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
		textField.setBounds(261, 82, 110, 20);
		frmEncheres.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(74, 127, 56, 20);
		frmEncheres.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(261, 127, 86, 20);
		frmEncheres.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(74, 168, 46, 14);
		frmEncheres.getContentPane().add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("Re-Enter Password");
		lblReenterPassword.setBounds(74, 193, 106, 14);
		frmEncheres.getContentPane().add(lblReenterPassword);
		
		textField_2 = new JTextField();
		textField_2.setBounds(261, 165, 110, 20);
		frmEncheres.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(261, 190, 110, 20);
		frmEncheres.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblContactDetails = new JLabel("Contact No.");
		lblContactDetails.setBounds(74, 243, 106, 14);
		frmEncheres.getContentPane().add(lblContactDetails);
		
		textField_6 = new JTextField();
		textField_6.setBounds(261, 237, 86, 20);
		frmEncheres.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"What is your favourite flower?", "What is the name of your first pet?"}));
		comboBox.setBounds(260, 296, 173, 20);
		frmEncheres.getContentPane().add(comboBox);
		
		JLabel lblSecurityQuestion = new JLabel("Security Question");
		lblSecurityQuestion.setBounds(74, 299, 106, 14);
		frmEncheres.getContentPane().add(lblSecurityQuestion);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(74, 345, 46, 14);
		frmEncheres.getContentPane().add(lblAnswer);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(261, 342, 86, 20);
		frmEncheres.getContentPane().add(textField_4);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(91, 437, 89, 23);
		frmEncheres.getContentPane().add(btnSubmit);
		
		JButton btnClearDetails = new JButton("Clear details");
		btnClearDetails.setBounds(261, 437, 110, 23);
		frmEncheres.getContentPane().add(btnClearDetails);
	}
}