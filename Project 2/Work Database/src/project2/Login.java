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

import csdbdao.SqlServerDbAccessor;

public class Login {
	private SqlServerDbAccessor sqda;
	
	
	public Login() {
		this.sqda = new SqlServerDbAccessor();
		sqda.setDbName("SSE660-Employee");
	}
	
	public void loginMenu() {
		JFrame window=new JFrame("Login");  
	    JLabel l1,l2;  
	    l1=new JLabel("Username");  
	    l1.setBounds(30,15, 100,30); //x axis, y axis, width, height 
	     
	    l2=new JLabel("Password");  
	    l2.setBounds(30,50, 100,30);    
	     
	    JTextField F_user = new JTextField(); 
	    F_user.setBounds(110, 15, 200, 30);
	         
	    JPasswordField F_pass=new JPasswordField(); 
	    F_pass.setBounds(110, 50, 200, 30);
	       
	    JButton login_but=new JButton("Login");
	    login_but.setBounds(130,90,80,25);
	    login_but.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String username = F_user.getText(); 
				@SuppressWarnings("deprecation")
				String password = F_pass.getText();
				
				if(username.equals(""))
				{ 
					JOptionPane.showMessageDialog(null, "Please enter username");
				}
				else if (password.equals(""))
				{ 
					JOptionPane.showMessageDialog(null, "Please enter password");
				}
				else { 
					
		    		sqda.connectToDb();
		    		String sql = ("SELECT * FROM login WHERE Username = '"+username+"'AND Password='"+password+"'");
		    		//System.out.println(sql);
		    		
		    		try { 
		    			Statement stmt = sqda.getConnection().createStatement();
		    			ResultSet rs = stmt.executeQuery(sql);
		    			//System.out.println("pass"); 
		    			//stmt.executeUpdate(sql);
		    			if(rs.next()==false) { 
		    				System.out.print("No User");
		    				JOptionPane.showMessageDialog(null, "Wrong Username/Password");
		    			}
		    			else { 
		    				
		    					String status = rs.getString("Status");
		    					Manager m = new Manager(username, password);
		    					//System.out.println(status + status.equals("supervisor"));
		    					if(status.equals("supervisor"))
		    					{ 
		    						
		    						m.menuManager();
		    						window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
		    					}
		    					else { 
		    						m.menu();
		    						window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
		    					}
		    			}
		    		}
		    		catch(Exception ex){ 
		    			ex.printStackTrace();
		    		}
				}
			} 
	    	
	    });
	    
     
	
    window.add(F_pass); //add password
    window.add(login_but);//adding button in JFrame  
    window.add(F_user);  //add user
    window.add(l1);  // add label1 i.e. for username
    window.add(l2); // add label2 i.e. for password
     
    window.setSize(400,180);//400 width and 500 height  
    window.setLayout(null); 
    window.setVisible(true);//making the frame visible 
    window.setLocationRelativeTo(null);
	}

	}

