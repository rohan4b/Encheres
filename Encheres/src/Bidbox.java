import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Connection;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.sql.*;

public class Bidbox {

	private JFrame frmItemid;
	private JTextField textField;
	private int userID,itemID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	Bidbox window = new Bidbox();
				//	window.frmItemid.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Bidbox(int userID,int itemID) {
		this.userID=userID;
		this.itemID=itemID;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemid = new JFrame();
		frmItemid.setTitle("itemID");
		frmItemid.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 17));
		frmItemid.getContentPane().setBackground(Color.CYAN);
		frmItemid.setBounds(100, 100, 450, 300);
		frmItemid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmItemid.getContentPane().setLayout(null);
		
		JLabel lblBidAmount = new JLabel("Bid Amount");
		lblBidAmount.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblBidAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblBidAmount.setBounds(94, 11, 231, 64);
		frmItemid.getContentPane().add(lblBidAmount);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(94, 101, 231, 54);
		frmItemid.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Bid!");
		//btnNewButton.setAction(action);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bidAmount=Integer.parseInt(textField.getText());
				int checker=checkBid(bidAmount);
				if(checker==1)
				{
					try {
						Connection conn=(Connection) MySql.getConnection();
						Statement stmt=null;
						stmt=conn.createStatement();
						String SQL="select * from item where id = "+itemID;
						ResultSet rs = stmt.executeQuery(SQL);
						rs.next();
						int sellingPrice=rs.getInt("sellingPrice");
						if(bidAmount>sellingPrice)
						{
							String SQL2="UPDATE item SET sellingPrice = "+bidAmount+ "WHERE id = "+itemID;
							rs = stmt.executeQuery(SQL2);
						}else
						{
							JOptionPane.showMessageDialog(null, "Please Bid a higher amount!");
						}
					} catch (Exception ee) {
						ee.printStackTrace();
					}
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(165, 207, 89, 43);
		frmItemid.getContentPane().add(btnNewButton);
		frmItemid.setVisible(true);
		
		
	}
	
	
	int checkBid(int bid)
	{
		try{
			Connection conn=(Connection) MySql.getConnection();
		 Statement stmt=null;
		 stmt=conn.createStatement();
		 String SQL = "SELECT * FROM item WHERE id = " + String.valueOf(this.itemID);
		 String SQL1 = "SELECT * FROM user_detail WHERE userID = " + String.valueOf(this.userID);

		 ResultSet rs=stmt.executeQuery(SQL);
		 rs.next();
		 String status=rs.getString("status");
		 ResultSet rs1=stmt.executeQuery(SQL1);
		 rs1.next();
		 int creds=rs1.getInt("credits");
		 System.out.println("bid is: "+ bid);
		 System.out.println("creds is: " + creds);
		 
		 if(creds>=bid && status=="available" )
			 return 1;
		 else {
			 JOptionPane.showMessageDialog(null, "You aint got no credits bro!");
			 return 0;
		 }
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		 
		return 0;
		
	}

}
