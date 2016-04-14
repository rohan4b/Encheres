//import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
//import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.ScrollPane;
import java.awt.Color;
//import java.awt.List;
import javax.swing.UIManager;

public class HomePage {

	private JFrame homepageFrame;
	private JTextField searchField;
	ScrollPane scrollPane;
	private final Action action = new SwingAction();
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	   static final String USER = "root";
	   static final String PASS = "root";
	   
	    String name, username, password, securityQ, answer;
	    int credits, userID, contactNo;
		JTextField buyCredTestField;
	   
	   

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
			
				try{
					HomePage window = new HomePage(0);
					window.homepageFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	

	/**
	 * Create the application.
	 */

	public HomePage(int userID){
				
				Connection conn = null;
			      Statement stmt = null;
			      
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL,USER,PASS);
					stmt=conn.createStatement();
					String SQL = "SELECT * FROM user_detail WHERE userID = " + String.valueOf(userID);
					ResultSet rs = stmt.executeQuery(SQL);
					rs.next();
					this.userID=rs.getInt("userID");
					this.name=rs.getString("name");
					this.username=rs.getString("username");
					this.securityQ = rs.getString("question");
					this.answer = rs.getString("answer");
					this.credits = rs.getInt("credits");
					this.contactNo = rs.getInt("contact");
					
					System.out.println("name: "+this.name);

				}
				catch (Exception e) {
					System.out.println("ExceptionReg is " + e);
				}
				initialize();
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		homepageFrame = new JFrame();
		homepageFrame.setBounds(100, 100, 821, 507);
		homepageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homepageFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(32, 101, 106, -71);
		homepageFrame.getContentPane().add(lblNewLabel);
		
		JLabel welcomeLabel = new JLabel("Welcome");
		welcomeLabel.setFont(new Font("Coffee At Midnight Demo", Font.BOLD | Font.ITALIC, 14));
		welcomeLabel.setBounds(476, 110, 67, 38);
		homepageFrame.getContentPane().add(welcomeLabel);
		
		JLabel TitleLabel = new JLabel("Encheres");
		TitleLabel.setFont(new Font("Coffee At Midnight Demo", Font.BOLD | Font.ITALIC, 49));
		TitleLabel.setBounds(259, 29, 309, 59);
		homepageFrame.getContentPane().add(TitleLabel);
		
		searchField = new JTextField();
		searchField.setBounds(70, 116, 221, 26);
		homepageFrame.getContentPane().add(searchField);
		searchField.setColumns(10);
		
		JButton SearchBtn = new JButton("Search");
		SearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SearchBtn.setBounds(297, 118, 89, 23);
		homepageFrame.getContentPane().add(SearchBtn);
		
		JButton btnSellItem = new JButton("Sell Item");
		btnSellItem.setBounds(486, 229, 146, 23);
		homepageFrame.getContentPane().add(btnSellItem);
		btnSellItem.addActionListener(new ActionListener()     //submit button action listner
				{
					public void actionPerformed(ActionEvent event)     
						{
							//new ItemReg(HomePage);
						}
				});
		
		JButton btnNewButton = new JButton("Account Details");
		btnNewButton.setBounds(486, 263, 146, 23);
		homepageFrame.getContentPane().add(btnNewButton);
		
		JLabel lblYouHave = new JLabel("You have ");
		lblYouHave.setFont(new Font("Coffee At Midnight Demo", Font.BOLD | Font.ITALIC, 14));
		lblYouHave.setBounds(476, 159, 77, 38);
		homepageFrame.getContentPane().add(lblYouHave);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBackground(Color.RED);
		scrollPane.setBounds(0, 292, 805, 176);
		homepageFrame.getContentPane().add(scrollPane);
		
		JLabel welcomeName = new JLabel(name);
		welcomeName.setBackground(UIManager.getColor("Button.background"));
		welcomeName.setBounds(554, 116, 191, 26);
		//welcomeName.setText(this.name);
		homepageFrame.getContentPane().add(welcomeName);
		
		
		
		JLabel lblCredit = new JLabel(String.valueOf(this.credits));
		lblCredit.setBounds(554, 165, 59, 26);
		homepageFrame.getContentPane().add(lblCredit);
		
		JLabel Credits = new JLabel("Credits");
		Credits.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		Credits.setBounds(623, 166, 106, 25);
		homepageFrame.getContentPane().add(Credits);
		
		JButton btnBuyCredits = new JButton("Buy Credits");
		btnBuyCredits.setBounds(486, 195, 146, 23);
		homepageFrame.getContentPane().add(btnBuyCredits);
		
		btnBuyCredits.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
				try{
					Connection conn=null;
					Statement stmt=null;
					conn = DriverManager.getConnection(DB_URL,USER,PASS);
					stmt = conn.createStatement();
					credits+=Integer.parseInt(buyCredTestField.getText());
					String sql=" Update user_detail set credits = " + String.valueOf(credits) + " where userID = " + String.valueOf(userID);
					stmt.executeUpdate(sql);
					lblCredit.setText(String.valueOf(credits));
					
				}catch(SQLException se)
				{
					se.printStackTrace();
				}
					
				}
				
		});
		
		
		buyCredTestField = new JTextField();
		buyCredTestField.setBounds(664, 196, 86, 20);
		homepageFrame.getContentPane().add(buyCredTestField);
		buyCredTestField.setColumns(10);
		homepageFrame.setVisible(true);
	}
	
	
	void addItems()
	{
		int numItems = 0;
		
		/*
		 * access the item data table
		 * while(rs.next())
		 * {
		 * 		if(status of item is available)
		 * 		{
		 * 			Item item = new Item(all para);
		 * 			scrollPane.setViewportView(Item);
		 * 		}
		 * }
		 */
		
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
