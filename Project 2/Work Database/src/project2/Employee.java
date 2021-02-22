package project2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Employee extends JFrame {

	private static String username;
	protected static String password;
	static Database db;
	
	public Employee(String username, String password) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.password = password;
		db = new Database(Employee.username);
	}

	public static void menu() {
		// TODO Auto-generated method stub
		System.out.print("emp");
		JFrame userMenu = new JFrame("Welcome " + username);
		
		JButton log_hours = new JButton("Log Hours");
		log_hours.setBounds(50,20,150,25);
		log_hours.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	logHours();
	        }	
	    });
		
		JButton request_leave = new JButton("Request Leave");
		request_leave.setBounds(250,20,150,25);
		request_leave.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	requestLeave();
	        }	
	    });
		
		JButton change_password = new JButton("Change Password");
		change_password.setBounds(450,20,150,25);
		change_password.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	changePassword();
	        }	
	    });
		
		userMenu.add(log_hours);
		userMenu.add(request_leave);
		userMenu.add(change_password);
		
		userMenu.setSize(700,100);//360 width and 100 height  
	    userMenu.setLayout(null);  
	    userMenu.setVisible(true);//making the frame visible 
	    userMenu.setLocationRelativeTo(null);
	}

	static void changePassword() {
		JFrame window=new JFrame("Change Password");  
	    JLabel l1,l2,l3;  
	    l1=new JLabel("Old Password");  
	    l1.setBounds(10,15, 150,30); //x axis, y axis, width, height 
	     
	    l2=new JLabel("New Password");  
	    l2.setBounds(10,50, 150,30);  
	    
	    l3=new JLabel("Confirm Password");  
	    l3.setBounds(10,85, 150,30);
	     
	    JPasswordField oldPassword = new JPasswordField(); 
	    oldPassword.setBounds(130, 15, 200, 30);
	         
	    JPasswordField newPassword=new JPasswordField(); 
	    newPassword.setBounds(130, 50, 200, 30);
	    
	    JPasswordField confirmPassword=new JPasswordField(); 
	    confirmPassword.setBounds(130, 85, 200, 30);
	       
	    JButton login_but=new JButton("Update Password");
	    login_but.setBounds(150,125,150,25);
	    login_but.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String pOld = oldPassword.getText(); 
				String pNew = newPassword.getText();
				String pNew2 = confirmPassword.getText();
				
				if(pOld.equals("") || pNew.equals("") || pNew2.equals(""))
				{ 
					JOptionPane.showMessageDialog(null, "Please fill in all fields!");
				}
				else if (!password.equals(pOld))
				{ 
					JOptionPane.showMessageDialog(null, "Old pasword is not correct!");
				}
				else if(!pNew.equals(pNew2)) {
					JOptionPane.showMessageDialog(null, "New passwords do not match!");
				}
				else if(pOld.equals(pNew)) {
					JOptionPane.showMessageDialog(null, "Old and new password can not be the same!");
				}
				else {
					db.changePassword(pNew2);
					JOptionPane.showMessageDialog(null, "Password Changed!");
					window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
				}
			} 
	    	
	    });
	    
     
	
    window.add(newPassword); //add password
    window.add(login_but);//adding button in JFrame  
    window.add(oldPassword);  //add user
    window.add(confirmPassword);
    window.add(l1);  // add label1 i.e. for username
    window.add(l2); // add label2 i.e. for password
    window.add(l3);
     
    window.setSize(450,200);//400 width and 500 height  
    window.setLayout(null); 
    window.setVisible(true);//making the frame visible 
    window.setLocationRelativeTo(null);
	}
	
	
	static void logHours() {
		
	}
	
	static void requestLeave() {
		
	}
}
