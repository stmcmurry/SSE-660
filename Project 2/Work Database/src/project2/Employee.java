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
	private static String password;
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
					setPassword(pNew2);
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
		JFrame window=new JFrame("Log Hours");  
	    JLabel l1,l2,l3;  
	    l1=new JLabel("Employee ID");  
	    l1.setBounds(10,15, 150,30); //x axis, y axis, width, height 
	     
	    l2=new JLabel("Pay Period");  
	    l2.setBounds(10,50, 150,30);  
	    
	    l3=new JLabel("Hours Worked");  
	    l3.setBounds(10,85, 150,30);
	     
	    JTextField employeeID = new JTextField(); 
	    employeeID.setBounds(130, 15, 200, 30);
	         
	    JTextField payPeriod=new JTextField(); 
	    payPeriod.setBounds(130, 50, 200, 30);
	    
	    JTextField hoursWorked=new JTextField(); 
	    hoursWorked.setBounds(130, 85, 200, 30);
	       
	    JButton enterHours=new JButton("Enter Hours");
	    enterHours.setBounds(150,125,150,25);
	    
	    enterHours.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ei = employeeID.getText(); 
				String pp = payPeriod.getText();
				String hw = hoursWorked.getText();
				
				int meowTest = Integer.parseInt(employeeID.getText());
				int numHours = Integer.parseInt(hoursWorked.getText());
				
				if(ei.equals("") || pp.equals("") || hw.equals(""))
				{ 
					JOptionPane.showMessageDialog(null, "Please fill in all fields!");
				}
				
				else {
					db.logHours(meowTest, pp, numHours); //this occassionally throws an error
					//db.logHours(meow, pp, numHours);
					JOptionPane.showMessageDialog(null, "Hours Logged!");
					window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
				}
			} 
	    	
	    });
	    
	    window.add(enterHours);
	    window.add(employeeID);
	    window.add(l1);
	    window.add(payPeriod);
	    window.add(l2);
	    window.add(hoursWorked);
	    window.add(l3);
	    
	    window.setSize(400,300);  
	    window.setLayout(null); 
	    window.setVisible(true);//making the frame visible 
	    window.setLocationRelativeTo(null);
	}
	
	static void requestLeave() {
		JFrame window=new JFrame("Request Leave");  
	    JLabel l0, l1,l2,l3;
	    
	    l0 = new JLabel("Employee ID");
	    l0.setBounds(10, 15, 150, 30);
	    
	    l1=new JLabel("Annual Leave");  
	    l1.setBounds(10,50, 150,30); //x axis, y axis, width, height 
	     
	    l2=new JLabel("Sick Leave");  
	    l2.setBounds(10,85, 150,30);  
	    
	    l3=new JLabel("Comp Leave");  
	    l3.setBounds(10,120, 150,30);
	    
	    JTextField id = new JTextField();
	    id.setBounds(130, 15, 200, 30);
	    
	    JTextField annual = new JTextField(); 
	    annual.setBounds(130, 50, 200, 30);
	         
	    JTextField sick=new JTextField(); 
	    sick.setBounds(130, 85, 200, 30);
	    
	    JTextField comp=new JTextField(); 
	    comp.setBounds(130, 120, 200, 30);
	       
	    JButton enterLeave=new JButton("Enter Amount");
	    enterLeave.setBounds(150,180,150,25);
	    
	    
	    enterLeave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String getId = id.getText();
				String an= annual.getText();
				String pp = sick.getText();
				String hw = comp.getText();
				
				/*
				int actId = Integer.parseInt(id.getText());
				int anNum= Integer.parseInt(annual.getText());
				int sickNum = Integer.parseInt(sick.getText());
				int compNum = Integer.parseInt(comp.getText());
				*/
				if(an.equals("") || pp.equals("") || hw.equals(""))
				{ 
					JOptionPane.showMessageDialog(null, "Please fill in all fields!");
				}
				
				else {
					int actId = Integer.parseInt(id.getText());
					int anNum= Integer.parseInt(annual.getText());
					int sickNum = Integer.parseInt(sick.getText());
					int compNum = Integer.parseInt(comp.getText());
					
					db.requestLeave(actId,anNum, sickNum, compNum); 
					JOptionPane.showMessageDialog(null, "Leave Requested!");
					window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
				}
			} 
	    	
	    });
	    
	    window.add(enterLeave);
	    window.add(id);
	    window.add(l0);
	    window.add(annual);
	    window.add(l1);
	    window.add(sick);
	    window.add(l2);
	    window.add(comp);
	    window.add(l3);
	    
	    window.setSize(400,300);  
	    window.setLayout(null); 
	    window.setVisible(true);//making the frame visible 
	    window.setLocationRelativeTo(null);
	}
	
	
	private static void setPassword(String password2) {
		password = password2;
	}
		
}
