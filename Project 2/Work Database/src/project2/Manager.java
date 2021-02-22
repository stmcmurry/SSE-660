package project2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Manager extends Employee {
	
	private String username; 
	
	public Manager(String username, String password) {
		// TODO Auto-generated constructor stub
		super(username, password);
		this.username = username;
	}

	public void menuManager() {
		// TODO Auto-generated method stub
		System.out.print("man");
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
		
		JButton add_employee=new JButton("Add Employee");
	    add_employee.setBounds(50,60,150,25);
	    add_employee.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	addEmployee();
	        }	
	    });
	    
	    JButton delete_employees =new JButton("Delete Employees");
	    delete_employees.setBounds(250,60,150,25);
	    delete_employees.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	deleteEmployee();
	        }	
	    });
		
	    JButton view_employees=new JButton("View Employees");
	    view_employees.setBounds(450,60,150,25);
	    view_employees.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	viewEmployees();
	        }	
	    });
	    
		userMenu.add(log_hours);
		userMenu.add(request_leave);
		userMenu.add(change_password);
		userMenu.add(add_employee);
		userMenu.add(delete_employees);
		userMenu.add(view_employees);
		
		userMenu.setSize(700,180);//360 width and 100 height  
	    userMenu.setLayout(null);  
	    userMenu.setVisible(true);//making the frame visible 
	    userMenu.setLocationRelativeTo(null);
	}
	
	
	private void addEmployee() {
		JFrame window=new JFrame("Add Employee");  
	    JLabel l1,l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;  
	    
	    l2=new JLabel("First Name");  
	    l2.setBounds(30,15, 100,30); 
	    
	    JTextField firstName=new JTextField(); 
	    firstName.setBounds(120, 15, 200, 30);
	    
	    l3=new JLabel("Last Name");  
	    l3.setBounds(30,50, 100,30); 
	    
	    JTextField lastName=new JTextField(); 
	    lastName.setBounds(120, 50, 200, 30);
	    
	    l4=new JLabel("Work Email");  
	    l4.setBounds(30,85, 100,30); 
	    
	    JTextField workEmail=new JTextField(); 
	    workEmail.setBounds(120, 85, 200, 30);
	    
	    l5=new JLabel("Work Phone");  
	    l5.setBounds(30,120, 100,30); 
	    
	    JTextField workPhone=new JTextField(); 
	    workPhone.setBounds(120, 120, 200, 30);
	    
	    l1=new JLabel("Office");  
	    l1.setBounds(30,155, 100,30); 
	    
	    JTextField office=new JTextField(); 
	    office.setBounds(120, 155, 200, 30);
	    
	    l6=new JLabel("Room Number");  
	    l6.setBounds(30,190, 100,30); 
	    
	    JTextField roomNumber=new JTextField(); 
	    roomNumber.setBounds(120, 190, 200, 30);
	    
	    l7=new JLabel("Supervisor");  
	    l7.setBounds(30,225, 100,30); 
	    
	    JTextField supervisor=new JTextField(); 
	    supervisor.setBounds(120, 225, 200, 30);
	    
	    l8=new JLabel("Street Address");  
	    l8.setBounds(30,260, 100,30); 
	    
	    JTextField streetAddress=new JTextField(); 
	    streetAddress.setBounds(120, 260, 200, 30);
	    
	    l9=new JLabel("City");  
	    l9.setBounds(30,295, 100,30); 
	    
	    JTextField city=new JTextField(); 
	    city.setBounds(120, 295, 200, 30);
	       
	    l10=new JLabel("State");  
	    l10.setBounds(30,330, 100,30); 
	    
	    JTextField state=new JTextField(); 
	    state.setBounds(120, 330, 200, 30);
	    
	    l11=new JLabel("Zip Code");  
	    l11.setBounds(30,365, 100,30); 
	    
	    JTextField zipCode=new JTextField(); 
	    zipCode.setBounds(120, 365, 200, 30);
	    
	    l12=new JLabel("Cell Phone");  
	    l12.setBounds(30,400, 100,30); 
	    
	    JTextField cellPhone=new JTextField(); 
	    cellPhone.setBounds(120, 400, 200, 30);
	    
	    l13=new JLabel("SSN");  
	    l13.setBounds(30,435, 100,30); 
	    
	    JTextField ssn=new JTextField(); 
	    ssn.setBounds(120, 435, 200, 30);
	    
	    JButton add_but=new JButton("Add User");
	    add_but.setBounds(120,470,200,25);
	    add_but.addActionListener(new ActionListener() {  //Perform action
	         
	    public void actionPerformed(ActionEvent e){  
	    	//String memberid = F_memberID.getText();
        	String fn = firstName.getText();
        	String ln = lastName.getText();
        	String we = workEmail.getText();
        	String wp = workPhone.getText();
        	String rn = roomNumber.getText();
        	String sp = supervisor.getText();
        	String sa = streetAddress.getText();
        	String of = office.getText();
        	String ct = city.getText();
        	String st = state.getText();
        	String zc = zipCode.getText();
        	String cp = cellPhone.getText();
        	String sn = ssn.getText();
        	
        	if(fn.equals("") || ln.equals("") || we.equals("") || wp.equals("") || rn.equals("") || sp.equals("")
        			|| sa.equals("") || of.equals("") || ct.equals("") || st.equals("") || zc.equals("")
        			|| cp.equals("") || sn.equals(""))
        		JOptionPane.showMessageDialog(null, "Please fill in all fields!");
        	
        	else
        	{	
	        	db.addEmployee(fn, ln, we, wp, rn, sp, sa, of, ct, st, zc, cp, sn);
		    }
	    	}
	    });
	    
	     
		
	    window.add(workEmail); //add password
	    //window.add(F_memberID);//adding button in JFrame  
	    window.add(lastName);  //add user
	    window.add(firstName);
	    window.add(office);
	    window.add(cellPhone);
	    window.add(workPhone);
	    window.add(roomNumber);
	    window.add(supervisor);
	    window.add(streetAddress);
	    window.add(city);
	    window.add(state);
	    window.add(zipCode);
	    window.add(ssn);
	    window.add(add_but);
	    //window.add(l1);  // add label1 i.e. for username
	    window.add(l2); // add label2 i.e. for password
	    window.add(l3);
	    window.add(l4);
	    window.add(l5);
	    window.add(l1);
	    window.add(l6); // add label2 i.e. for password
	    window.add(l7);
	    window.add(l8);
	    window.add(l9);
	    window.add(l10);
	    window.add(l11); // add label2 i.e. for password
	    window.add(l12);
	    window.add(l13);
	     
	    window.setSize(400,600);//400 width and 500 height  
	    window.setLayout(null); 
	    window.setVisible(true);//making the frame visible 
	    window.setLocationRelativeTo(null);
	}
	
	private void deleteEmployee() {
		JFrame window=new JFrame("Delete User");  
	    JLabel l1, l2;  
	    l1=new JLabel("First Name");  
	    l1.setBounds(20,15, 100,30); //x axis, y axis, width, height    
	     
	    JTextField firstName = new JTextField(); 
	    firstName.setBounds(130, 15, 200, 30);
	    
	    l2=new JLabel("Last Name");  
	    l2.setBounds(20,50, 100,30); //x axis, y axis, width, height    
	     
	    JTextField lastName = new JTextField(); 
	    lastName.setBounds(130, 50, 200, 30);
	    
	    JButton add_but=new JButton("Delete Employee");
	    add_but.setBounds(110,105,200,25);
	    add_but.addActionListener(new ActionListener() {  //Perform action
	         
	        public void actionPerformed(ActionEvent e){ 
	        	//String author = F_author.getText();
	        	String fn = firstName.getText();
	        	String ln = lastName.getText();
	        			
	        	if(fn.equals("") || ln.equals(""))
	        		JOptionPane.showMessageDialog(null, "Please fill out all fields!");
	        	else {
	        		db.deleteEmployee(fn, ln);
	        	}
	        }  		
	    });
	    
	    
		
	    window.add(add_but);//adding button in JFrame  
	    window.add(firstName); 
	    window.add(l1);  
	    window.add(l2);
	    window.add(lastName);
	   
	     
	    window.setSize(400,180);  
	    window.setLayout(null); 
	    window.setVisible(true);//making the frame visible 
	    window.setLocationRelativeTo(null);
	}
	
	
	private void viewEmployees() {
		db.viewEmployees();
	}
}
