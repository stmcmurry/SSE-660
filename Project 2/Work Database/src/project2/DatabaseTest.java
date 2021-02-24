package project2;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

class DatabaseTest {

	@Test
	void testAddEmployee() throws SQLException {
		Database d = new Database("mthoai");
		d.sqda.connectToDb();
		try(Statement stc = d.sqda.getConnection().createStatement()){
			
			d.sqda.getConnection().setAutoCommit(false);
			
			String fn = "Tester";
        	String ln = "Testy";
        	String we = "tester@work.com";
        	String wp = "470-123-4567";
        	String rn = "3";
        	String sp = "Mikae Nguyen";
        	String sa = "222 Address Lane";
        	String of = "Test";
        	String ct = "city";
        	String st = "state";
        	int zc = 86753;
        	String cp = "987-654-3210";
        	String sn = "555-55-5555";
        	String password = "tempPass";
        	String username = fn + "." + ln;
        	String status = "employee";
        	int empid = 6;
        	
        	d.addEmployee(empid, fn, ln, we, wp, rn, sp, sa, of, ct, st, zc, cp, sn);
        	
        	//checks if information was added to employee table
        	try(ResultSet rs = stc.executeQuery("SELECT * FROM employee WHERE employeeId = 6")){
        		assertTrue(rs.next());
        		assertEquals(empid, rs.getInt("employeeId"));
        		assertEquals(fn, rs.getString("FirstName"));
        		assertEquals(ln, rs.getString("LastName"));
        		assertEquals(we, rs.getString("WorkEmail"));
        		assertEquals(wp, rs.getString("WorkPhone"));
        		assertEquals(of, rs.getString("Office"));
        		assertEquals(rn, rs.getString("RoomNumber"));
        		assertEquals(sp, rs.getString("Supervisor"));
        		assertEquals(sa, rs.getString("StreetAddress"));
        		assertEquals(ct, rs.getString("City"));
        		assertEquals(st, rs.getString("State"));
        		assertEquals(zc, rs.getInt("ZipCode"));
        		assertEquals(sn, rs.getString("SSN"));
        		assertFalse(rs.next());
        	}
        	
        	//checks if information was added to login table
        	try(ResultSet rs = stc.executeQuery("SELECT * FROM login WHERE LastName = 'Testy'")){
        		assertTrue(rs.next());
        		assertEquals(ln, rs.getString("LastName"));
        		assertEquals(fn, rs.getString("FirstName"));
        		assertEquals(username, rs.getString("Username"));
        		assertEquals(password, rs.getString("Password"));
        		assertEquals(status, rs.getString("Status"));
        		assertFalse(rs.next());
        	}
		}
		catch (SQLException e)
        {
			e.printStackTrace();
            fail(e.toString());
        }
		finally {
			//removes test database cases
			d.sqda.getConnection().rollback();
		}
	}

}
