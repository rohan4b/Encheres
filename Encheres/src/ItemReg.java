import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class ItemReg {

	private JFrame frame;
	private JTextField tfName;
	private JTextField tfItem;
	private JTextField tfDescription;
	private JTextField tfModelID;
	private JTextField tfAuctPrice;

	private String name, description, modelID, status="available";
	private int auctionPrice, sellingPrice, id, buyerID;// 0 for not sold; 1 for available; 2 for sold;
	 int sellerID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//ItemReg window = new ItemReg();
				//	window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ItemReg(int sellerID) {
		this.sellerID=sellerID;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(74, 68, 46, 14);
		frame.getContentPane().add(lblName);
		
		tfName = new JTextField();
		tfName.setBounds(229, 65, 86, 20);
		frame.getContentPane().add(tfName);
		tfName.setColumns(10);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setBounds(74, 110, 86, 14);
		frame.getContentPane().add(lblItemName);
		
		tfItem = new JTextField();
		tfItem.setBounds(217, 107, 86, 20);
		frame.getContentPane().add(tfItem);
		tfItem.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(63, 150, 73, 20);
		frame.getContentPane().add(lblDescription);
		
		tfDescription = new JTextField();
		tfDescription.setBounds(229, 150, 163, 80);
		frame.getContentPane().add(tfDescription);
		tfDescription.setColumns(10);
		
		tfModelID = new JTextField();
		tfModelID.setBounds(229, 252, 86, 20);
		frame.getContentPane().add(tfModelID);
		tfModelID.setColumns(10);
		
		JLabel lblModelId = new JLabel("Model ID");
		lblModelId.setBounds(74, 255, 46, 14);
		frame.getContentPane().add(lblModelId);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(113, 331, 89, 23);
		frame.getContentPane().add(btnSubmit);
				btnSubmit.addActionListener(new ActionListener()     //submit button action listner
				{
					public void actionPerformed(ActionEvent event)     
						{
							getItemInformation();
							registerItemData(sellerID);
							//refreshItemData;
							frame.setVisible(false);
							
							Timer timer = new Timer(10 * 3000, new ActionListener() {
								  @Override
								  public void actionPerformed(ActionEvent arg0) {
								  }
								});
								timer.setRepeats(false); // Only execute once
								timer.start(); // Go go go!
						
							//set the item sold; get the payment done
						}
				});
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(283, 331, 89, 23);
		frame.getContentPane().add(btnClear);
		
		JLabel AuctionPricelbl = new JLabel("Auction Price");
		AuctionPricelbl.setBounds(74, 306, 62, 14);
		frame.getContentPane().add(AuctionPricelbl);
		
		tfAuctPrice = new JTextField();
		tfAuctPrice.setBounds(229, 303, 86, 20);
		frame.getContentPane().add(tfAuctPrice);
		tfAuctPrice.setColumns(10);
		frame.setBounds(100, 100, 579, 447);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 tfName.setText("");
				 tfModelID.setText("");
				 tfDescription.setText("");
				 tfAuctPrice.setText("");
			}
		});
		
		frame.setVisible(true);
	}
	public void getItemInformation() {
		 name = tfName.getText();
		 modelID = tfModelID.getText();
		 description = tfDescription.getText();
		 auctionPrice = Integer.parseInt(tfAuctPrice.getText());
		 System.out.println(name+ " "+ modelID +" "+description+" "+" ");
		 
	}
	
	public void registerItemData(int userID) {
		Connection conn = MySql.getConnection();
	      Statement stmt = null;
	      
		try {
			 System.out.println("seller ID;"+sellerID);
		      		  PreparedStatement updateemp = conn.prepareStatement("insert into item values(?,?,?,?,?,?,?,?,?)");
		      		  updateemp.setString(1,name);
		    	      updateemp.setString(2,description);
		    	      updateemp.setString(3,modelID);
		    	      updateemp.setString(4,status);
		    	      updateemp.setInt(5,auctionPrice);
		    	      updateemp.setInt(6,sellingPrice);
		    	      updateemp.setInt(7,id);
		    	      updateemp.setInt(8,userID);
		    	      updateemp.setInt(9,userID);
		    	      updateemp.executeUpdate();

		    	     

		}
		catch (Exception e) {
			System.out.println("ExceptionRegItem is " + e);
		}
	}
}
