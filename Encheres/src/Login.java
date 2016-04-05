import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

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
		frame.getContentPane().setFont(new Font("Coffee At Midnight Demo", Font.PLAIN, 39));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rohan\\Downloads\\Capture.JPG"));
		frame.setBounds(100, 100, 716, 681);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(36, 191, 356, 364);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Rohan\\git\\Encheres\\Encheres\\src\\rsz_1rsz_154892547f0baaimage_1.jpg"));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEncheres = new JLabel("ench\u00E8res");
		lblEncheres.setForeground(new Color(139, 0, 0));
		lblEncheres.setFont(new Font("Coffee At Midnight Demo", Font.PLAIN, 79));
		lblEncheres.setBounds(177, 48, 305, 75);
		frame.getContentPane().add(lblEncheres);
		
		textField = new JTextField();
		textField.setBackground(new Color(0, 255, 127));
		textField.setBounds(492, 285, 146, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(0, 255, 127));
		passwordField.setBounds(492, 361, 146, 26);
		frame.getContentPane().add(passwordField);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(139, 0, 0));
		lblUsername.setFont(new Font("Coffee At Midnight Demo", Font.PLAIN, 26));
		lblUsername.setBounds(363, 280, 119, 35);
		frame.getContentPane().add(lblUsername);
		
		JLabel label = new JLabel("Password");
		label.setForeground(new Color(139, 0, 0));
		label.setFont(new Font("Coffee At Midnight Demo", Font.PLAIN, 26));
		label.setBounds(363, 361, 119, 23);
		frame.getContentPane().add(label);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setIcon(new ImageIcon("C:\\Users\\Rohan\\Desktop\\login.gif"));
		btnLogin.setBackground(new Color(30, 144, 255));
		btnLogin.setBounds(333, 488, 149, 35);
		frame.getContentPane().add(btnLogin);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Rohan\\Desktop\\register.gif"));
		btnNewButton.setBounds(473, 494, 165, 29);
		frame.getContentPane().add(btnNewButton);
	}
}
