import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Button;
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
import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.List;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import java.awt.Dimension;

public class HomePage {

	private JFrame homepageFrame;
	private JTextField searchField;
	private JScrollPane scrollPane;

	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	   static final String USER = "root";
	   static final String PASS = "root";
	   
	    String name, username, password, securityQ, answer;
	    int credits, userID, contactNo;
	    ArrayList<Item> itemList;
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
				
		itemList = new ArrayList<Item>();
		
				Connection conn = null;
			      Statement stmt = null;
			      
				try {
					conn = MySql.getConnection();
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
				}
				catch (Exception e) {
					System.out.println("Exceptionhomepage is " + e);
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
		btnSellItem.addActionListener(new ActionListener()     //sellItem button action listner
				{
					public void actionPerformed(ActionEvent event)     
						{
						System.out.println("user ID:"+userID);
						
							new ItemReg(userID);
							refreshItemPanel();
						}
				});
		
		JButton btnNewButton = new JButton("Account Details");
		btnNewButton.setBounds(486, 263, 146, 23);
		homepageFrame.getContentPane().add(btnNewButton);
		
		JLabel lblYouHave = new JLabel("You have ");
		lblYouHave.setFont(new Font("Coffee At Midnight Demo", Font.BOLD | Font.ITALIC, 14));
		lblYouHave.setBounds(476, 159, 77, 38);
		homepageFrame.getContentPane().add(lblYouHave);
		
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 298, 805, 170);
		
		
		JPanel CurItemsPane = new JPanel();
		
		//CurItemsPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5))
		
		for(int i=0; i<itemList.size(); i++)
		{
			itemList.get(i).setPreferredSize(new Dimension(150,150));
			CurItemsPane.add(itemList.get(i));
		}
		
		CurItemsPane.revalidate();
		scrollPane.setViewportView(CurItemsPane);
		homepageFrame.getContentPane().add(scrollPane);
		
		homepageFrame.setVisible(true);
	}
	
	
	public void refreshItemPanel()
	{
		itemList.clear();
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
		String itemName, description, modelID,  status;
		int auctionPrice, sellingPrice, id, sellerID, buyerID;
		
		  Connection conn = null;
	      Statement stmt = null;
		try {
			  Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		     // System.out.println(name+password);

		       stmt = conn.createStatement();
		    String SQL = "SELECT * FROM item ;";

		    ResultSet rs = stmt.executeQuery(SQL);
		    
		            // Check Username and Password
		    while (rs.next()) {
		    	id = rs.getInt("id");
		    	sellerID = rs.getInt("sellerID");
		    	buyerID = rs.getInt("buyerID");
		    	auctionPrice = rs.getInt("auctionPrice");
		    	sellingPrice = rs.getInt("sellingPrice");
		    	status = rs.getString("status");
		    	modelID = rs.getString("modelID");
		    	description = rs.getString("description");
		    	itemName = rs.getString("name");
		    	System.out.println("ooooooooooooo");
		        
		              
		    if (status.equalsIgnoreCase("Available") && sellerID != userID) 
		    	{
		    		itemList.add(new Item(itemName, description, modelID,  status, auctionPrice, sellingPrice, id, sellerID, buyerID));
		    	} 
		    }
		}catch (Exception e) {
			System.out.println("ExceptionAddItemPanel is " + e);
		}	
	}
	
	
}
