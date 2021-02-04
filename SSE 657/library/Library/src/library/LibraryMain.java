package library;
import java.awt.Dimension;
import java.awt.Image;
 
import javax.swing.*;
public class LibraryMain extends JPanel {
	
	private Image iconOnTitleBar;
	//private Image backgroundPhoto;
	
	public void libraryMain() {
		Dimension windowSize = new Dimension(900, 600);
		this.setPreferredSize(windowSize);
		this.setMaximumSize(windowSize);
		this.setMinimumSize(windowSize);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login login = new Login();
		login.gui();
		//myBooks();
		//addBook();
		//addUser();
		//issueBooks();
		//returnBook();
		//viewIssued();
		//deleteBook();
		//deleteUser();
		//viewBooks();
		//viewUsers();
	}
	
	public void setIconOnTitleBar(Image image) {
		// TODO Auto-generated method stub
		iconOnTitleBar = image;
	}
	
	public Image getIconOnTitleBar() {
		// TODO Auto-generated method stub
		return iconOnTitleBar;
	}
	
	public static void myBooks() {
		Controller c = new Controller();
		c.myBooks("mikae");
	}
	
	public static void addBook() {
		Controller c = new Controller();
		c.addBook();
		//c.viewBooks();
	}
	
	public static void addUser() {
		Controller c = new Controller();
		c.addUser();
		//c.viewUser();
	}
	
	public static void viewIssued() {
		Controller c = new Controller();
		c.viewIssued();
	}
	
	public static void deleteBook() {
		Controller c = new Controller();
		c.deleteBook();
		//c.viewBooks();
	}
	
	public static void viewBooks() {
		Controller c = new Controller();
		c.viewBooks();
	}
	
	public static void returnBook() {
		Controller c = new Controller();
		c.returnBook();
		//c.viewBooks();
	}
	
	public static void issueBooks() {
		Controller c = new Controller();
		c.issueBook();
		//c.viewIssued();
	}
	
	public static void deleteUser() {
		Controller c = new Controller();
		c.deleteUser();
		//c.viewUser();
	}
	
	public static void viewUsers() {
		Controller c = new Controller();
		c.viewUser();
	}
}
