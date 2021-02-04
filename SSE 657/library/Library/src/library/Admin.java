package library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Admin {
	public static void menu(String username) {
		JFrame adminMenu = new JFrame("Admin Menu");
		
		JButton view_books = new JButton("View Books");
		view_books.setBounds(50,20,150,25);
		view_books.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	Controller library = new Controller();
	        	library.viewBooks();
	        }	
	    });
		
		JButton add_book = new JButton("Add Book");
		add_book.setBounds(250,20,150,25);
		add_book.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	Controller library = new Controller();
	        	library.addBook();
	        }	
	    });
		
		JButton view_issue = new JButton("View Issued Books");
		view_issue.setBounds(450,20,150,25);
		view_issue.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	Controller library = new Controller();
	        	library.viewIssued();
	        }	
	    });
		
		JButton issue_book = new JButton("Issue Book");
		issue_book.setBounds(650,20,150,25);
		issue_book.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	Controller library = new Controller();
	        	library.issueBook();
	        }	
	    });
		
		JButton add_user=new JButton("Add User");
	    add_user.setBounds(50,60,150,25);
	    add_user.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	Controller library = new Controller();
	        	library.addUser();
	        }	
	    });
	    
	    JButton view_user =new JButton("View Users");
	    view_user.setBounds(250,60,150,25);
	    view_user.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	Controller library = new Controller();
	        	library.viewUser();
	        }	
	    });
	    
	    JButton return_book=new JButton("Return Books");
	    return_book.setBounds(450,60,150,25);
	    return_book.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	Controller library = new Controller();
	        	library.returnBook();
	        }	
	    });
		
		JButton my_book=new JButton("My Books");
	    my_book.setBounds(650,60,150,25);
	    my_book.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	Controller library = new Controller();
	        	library.myBooks(username);
	        }	
	    });
	    
	    JButton delete_book = new JButton("Delete Books");
		delete_book.setBounds(50,100,150,25);
		delete_book.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	Controller library = new Controller();
	        	library.deleteBook();
	        }	
	    });
		
		JButton delete_users = new JButton("Delete Users");
		delete_users.setBounds(250,100,150,25);
		delete_users.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	Controller library = new Controller();
	        	library.deleteUser();
	        }	
	    });
	    LibraryMain lm = new LibraryMain();
	    
	    lm.setIconOnTitleBar(new ImageIcon("images/libraryIcon.png").getImage());
		adminMenu.setIconImage(lm.getIconOnTitleBar()); 
	    
	    adminMenu.add(view_books);
	    adminMenu.add(my_book);
	    adminMenu.add(add_book);
	    adminMenu.add(view_issue);
	    adminMenu.add(issue_book);
	    adminMenu.add(add_user);
	    adminMenu.add(view_user);
	    adminMenu.add(return_book);
	    adminMenu.add(delete_book);
	    adminMenu.add(delete_users);
	    
	    adminMenu.setSize(850,180);//850 width and 180 height  
	    adminMenu.setLayout(null);
	    adminMenu.setVisible(true);//making the frame visible 
	    adminMenu.setLocationRelativeTo(null);
	}
}
