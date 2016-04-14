import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ItemReg extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfModelId;
	private JTextField tfAuctPrice;
	private JTextField tfDescrip;
	private JButton btnSubmit;
	private JButton btnClear;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	   static final String USER = "root";
	   static final String PASS = "root";

	
	private String name, description, modelID, status;
	private int auctionPrice, sellingPrice, id, sellerID, buyerID;// 0 for not sold; 1 for available; 2 for sold;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemReg frame = new ItemReg(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ItemReg(HomePage user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 464);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfName = new JTextField();
		tfName.setBounds(235, 63, 155, 20);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setBounds(71, 63, 154, 20);
		contentPane.add(lblItemName);
		
		JLabel lblModelId = new JLabel("Model ID");
		lblModelId.setBounds(71, 111, 154, 20);
		contentPane.add(lblModelId);
		
		JLabel lblAuctionId = new JLabel("Auction price");
		lblAuctionId.setBounds(71, 162, 154, 20);
		contentPane.add(lblAuctionId);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(71, 212, 154, 20);
		contentPane.add(lblDescription);
		
		tfModelId = new JTextField();
		tfModelId.setColumns(10);
		tfModelId.setBounds(235, 111, 155, 20);
		contentPane.add(tfModelId);
		
		tfAuctPrice = new JTextField();
		tfAuctPrice.setColumns(10);
		tfAuctPrice.setBounds(235, 162, 155, 20);
		contentPane.add(tfAuctPrice);
		
		tfDescrip = new JTextField();
		tfDescrip.setColumns(10);
		tfDescrip.setBounds(157, 212, 300, 152);
		contentPane.add(tfDescrip);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(136, 375, 89, 23);
		contentPane.add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener()     //submit button action listner
				{
					public void actionPerformed(ActionEvent event)     
						{
							getItemInformation();
							registerItemData(user);
							
							user.scrollPane.add(new Item(name, description, modelID, status, auctionPrice, sellingPrice, id, sellerID, buyerID));
						}
				});
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(235, 375, 89, 23);
		contentPane.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 tfName.setText("");
				 tfModelId.setText("");
				 tfDescrip.setText("");
				 tfAuctPrice.setText("");
			}
		});
	}
	
	public void getItemInformation() {
		 name = tfName.getText();
		 modelID = tfModelId.getText();
		 description = tfDescrip.getText();
		 auctionPrice = Integer.parseInt(tfAuctPrice.getText());
		 
	}
	
	public void registerItemData(HomePage user) {
		Connection conn = null;
	      Statement stmt = null;
	      
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			 
		      		  PreparedStatement updateemp = conn.prepareStatement("insert into item values(?,?,?,?,?,?,?,?,?)");
		      		  updateemp.setString(1,name);
		    	      updateemp.setString(2,description);
		    	      updateemp.setString(3,modelID);
		    	      updateemp.setString(4,status);
		    	      updateemp.setInt(5,auctionPrice);
		    	      updateemp.setInt(6,sellingPrice);
		    	      updateemp.setInt(7,id);
		    	      updateemp.setInt(8,user.userID);
		    	      updateemp.setInt(9,0);
			    	    
			//st1.execute("INSERT INTO User_Details (Name,Gender,Password,DOB,Mobile_Number,Email,Area,State,Nationality,StateIndex) VALUES('"+name+"','"+gender+"','"+password+"','"+dobb+"','"+mobileNumber+"','"+email+"','"+area+"','"+state+"','"+nationality+"',"+index+")");
			//st1.close();
			//con1.close();
			//JOptionPane.showMessageDialog(null,"Data are Registered Successfully");
		    	     

		}
		catch (Exception e) {
			System.out.println("ExceptionReg is " + e);
		}
	}

}
