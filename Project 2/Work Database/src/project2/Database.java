package project2;

import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import csdbdao.SqlServerDbAccessor;
import net.proteanit.sql.DbUtils;

public class Database {

	private static SqlServerDbAccessor sqda;
	private static String username;
	
	public Database(String username) {
		this.username = username;
		sqda = new SqlServerDbAccessor();
		sqda.setDbName("SSE660-Employee");
	}
	
	public static void changePassword(String newPassword) {
		String sql = "UPDATE login " +"SET Password ='"+newPassword+"'"
				+ " WHERE Username='"+username+"'";
		sqda.connectToDb();
		try {
			
			Statement stmt = sqda.getConnection().createStatement();
			
			stmt.executeUpdate(sql);
	    	
		}
		catch (SQLException e1) {
	            // TODO Auto-generated catch block
	             JOptionPane.showMessageDialog(null, e1);
		}
	}
	
	public static void logHours() {
		
	}
	
	public static void addEmployee(String fn, String ln, String we, String wp, 
			String rn, String sp, String sa, String of, String ct, String st, String zc, 
			String cp, String sn) 
	{
		String un = fn + "." + ln;
		String sql = "INSERT INTO employee (FirstName, LastName, WorkEmail, WorkPhone, Office, RoomNumber, "
				+ "Supervisor, StreetAddress, City, State, ZipCode, Cellphone, SSN)"
				+ "VALUES ('" +fn+ "' , '" + ln + "' , '" + we + "' ,  '" + wp + "' , '" + of + "' , '" +  
				rn +  "' , '" + sp + "' , '" + sa + "' , '" + ct + "' , '" + st + "' , '" + zc + "' , '" + 
				cp + "' , '" + sn + "')" ;
		String sql2 = "INSERT INTO login (LastName, FirstName, Username, Password, Status) VALUES ('"
				+ ln + "' , '" + fn + "' , '" + un + "' , 'tempPass' , 'employee')";
		try {
			
			Statement stmt = sqda.getConnection().createStatement();
			stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
		}
		catch (SQLException e1) {
            // TODO Auto-generated catch block
             JOptionPane.showMessageDialog(null, e1);
		}
	}
	
	public static void deleteEmployee(String firstName, String lastName) {
		String sql = "DELETE FROM employee WHERE FirstName = '" + firstName + "' AND "
				+ "LastName = '" + lastName + "'";
		String sql2 = "DELETE FROM login WHERE FirstName = '" + firstName + "' AND "
				+ "LastName = '" + lastName + "'";
		sqda.connectToDb();
		try {
			
			Statement stmt = sqda.getConnection().createStatement();
			
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql2);
	    	
		}
		catch (SQLException e1) {
	            // TODO Auto-generated catch block
	             JOptionPane.showMessageDialog(null, e1);
		}
	}
	
	public static void requestLeave() {
		
	}
	
	public static void viewEmployees() {
		JFrame f = new JFrame("My Employees");
		sqda.connectToDb();
		System.out.println("username: " + username);
		String sql = ("SELECT * FROM login WHERE Username = '"+username+"'");
		
		try { 
			Statement stmt = sqda.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next() == false)
				JOptionPane.showMessageDialog(null, "You have no employees to view.");
			else {
			String firstName = rs.getString("FirstName");
			String lastName = rs.getString("LastName");
			System.out.println(firstName + lastName);
			String sql2 = "SELECT * FROM employee "
					+ "WHERE Supervisor = '" + firstName + " " + lastName + "'";
			System.out.println(sql2);
			ResultSet rs2 = stmt.executeQuery(sql2);
			JTable employees= new JTable(); 
            employees.setModel(DbUtils.resultSetToTableModel(rs2)); 
            
            JScrollPane scrollPane = new JScrollPane(employees); 
            
            
            f.add(scrollPane); 
            f.setSize(800, 400); 
            f.setVisible(true);
            f.setLocationRelativeTo(null);
			}
		}
		catch(Exception ex){ 
			ex.printStackTrace();
		}
	}
}
