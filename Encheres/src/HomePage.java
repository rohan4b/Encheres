import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.ScrollPane;
import java.awt.Color;
import java.awt.List;

public class HomePage {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
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
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 821, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(32, 101, 106, -71);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome");
		lblNewLabel_1.setFont(new Font("Coffee At Midnight Demo", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(476, 110, 155, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Encheres");
		lblNewLabel_2.setFont(new Font("Coffee At Midnight Demo", Font.BOLD | Font.ITALIC, 49));
		lblNewLabel_2.setBounds(259, 29, 309, 59);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(70, 116, 221, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Search");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSubmit.setBounds(297, 118, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnBuyCredits = new JButton("Buy Credits");
		btnBuyCredits.setBounds(565, 214, 146, 23);
		frame.getContentPane().add(btnBuyCredits);
		
		JButton btnSellItem = new JButton("Sell Item");
		btnSellItem.setBounds(565, 248, 146, 23);
		frame.getContentPane().add(btnSellItem);
		
		JButton btnNewButton = new JButton("Account Details");
		btnNewButton.setBounds(565, 282, 146, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblYouHave = new JLabel("You have ");
		lblYouHave.setFont(new Font("Coffee At Midnight Demo", Font.BOLD | Font.ITALIC, 14));
		lblYouHave.setBounds(476, 159, 155, 38);
		frame.getContentPane().add(lblYouHave);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBackground(Color.RED);
		scrollPane.setBounds(0, 358, 805, 100);
		frame.getContentPane().add(scrollPane);
	}
}
