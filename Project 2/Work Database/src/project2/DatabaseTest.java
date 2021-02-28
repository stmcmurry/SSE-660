package project2;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

class DatabaseTest {

	@Test
	void testAddEmployee() throws SQLException {
		Database d = new Database("mthoai17");
		d.sqda.connectToDb();
		try(Statement stc = d.sqda.getConnection().createStatement()){
			
			//d.sqda.getConnection().setAutoCommit(false);
			
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
        	
        	//verify that Tester Testy is  not in the database
        	try(ResultSet rs = stc.executeQuery("SELECT * FROM employee WHERE employeeId = 6")){
        		assertFalse(rs.next());
        	}
        	
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
			//d.sqda.getConnection().rollback();
		}
	}

	@Test
	void testDeleteEmployee() throws SQLException {
		Database d2 = new Database("mthoai17");
		d2.sqda.connectToDb();
		try(Statement stc = d2.sqda.getConnection().createStatement()){
			
			//stc.getConnection().setAutoCommit(false);//throwing error Cannot invoke a rollback operation when the AutoCommit mode is set to "true"
			
			String fn = "Tester";
        	String ln = "Testy";
        	
        	//verify that Tester Testy was originally in database
        	try(ResultSet rs = stc.executeQuery("SELECT * FROM employee WHERE FirstName = 'Tester' AND LastName = 'Testy'")){
        		assertTrue(rs.next());
        		assertEquals(fn, rs.getString("FirstName"));
        		assertEquals(ln, rs.getString("LastName"));
        		assertFalse(rs.next());
        	}
        	
        	d2.deleteEmployee(fn, ln);
        	
        	//checks if information was deleted to employee table
        	try(ResultSet rs = stc.executeQuery("SELECT * FROM employee WHERE FirstName = 'Tester' AND LastName = 'Testy'")){
        		//assertTrue(rs.next());
        		//assertNotSame(fn, rs.getString("FirstName"));
        		//assertNotSame(ln, rs.getString("LastName"));
        		assertFalse(rs.next());
        	}
        	
        	//checks if information was added to login table
        	try(ResultSet rs = stc.executeQuery("SELECT * FROM login WHERE FirstName = 'Tester' AND LastName = 'Testy'")){
        		//assertTrue(rs.next());
        		//assertNotSame(fn, rs.getString("FirstName"));
        		//assertNotSame(ln, rs.getString("LastName"));
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
			//d2.sqda.getConnection().rollback();
		}
	}
	
	
	@Test
	void testViewEmployees() throws SQLException {
		Database d3 = new Database("mthoai17");
		d3.sqda.connectToDb();
		try(Statement stc = d3.sqda.getConnection().createStatement()){
			
			//stc.getConnection().setAutoCommit(false);//throwing error Cannot invoke a rollback operation when the AutoCommit mode is set to "true"
			
			String supervisor = "Mikae Nguyen";
        	
        	//d3.deleteEmployee(fn, ln);
        	
        	//checks if Xiu Mai's supervisor is Mikae Nguyen
        	try(ResultSet rs = stc.executeQuery("SELECT * FROM employee WHERE FirstName = 'Xiu Mai' AND LastName = 'Dang'")){
        		assertTrue(rs.next());
        		assertEquals(supervisor, rs.getString("Supervisor"));
        		assertFalse(rs.next());
        	}
        	
        	//Checks if Tester's supervisor is Mikae Nguyen
        	try(ResultSet rs = stc.executeQuery("SELECT * FROM employee WHERE FirstName = 'Tester' AND LastName = 'Testy'")){
        		assertTrue(rs.next());
        		assertEquals(supervisor, rs.getString("Supervisor"));
        		assertFalse(rs.next());
        	}
        	
        	//checks if Emma Anderson's supervisor is not Mikae Nguyen
        	try(ResultSet rs = stc.executeQuery("SELECT * FROM employee WHERE FirstName = 'Emma' AND LastName = 'Anderson'")){
        		assertTrue(rs.next());
        		assertNotSame(supervisor, rs.getString("Supervisor"));
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
			//d3.sqda.getConnection().rollback();
		}
	}
	
	@Test
	void testChangePassword() throws SQLException {
		Database d4 = new Database("mthoai17");
		d4.sqda.connectToDb();
		try(Statement stc = d4.sqda.getConnection().createStatement()){
			
			//stc.getConnection().setAutoCommit(false);//throwing error Cannot invoke a rollback operation when the AutoCommit mode is set to "true"
			
			String newPassword = "newPass";
        	//checks if original password is 'cats'
        	try(ResultSet rs = stc.executeQuery("SELECT * FROM login WHERE Username = 'mthoai17'")){
        		assertTrue(rs.next());
        		assertEquals("cats", rs.getString("Password"));
        		assertNotSame(newPassword, rs.getString("Password"));
        		assertFalse(rs.next());
        		rs.close();
        	}
        	
        	d4.changePassword(newPassword);
        	//checks if new password is not 'cats' and is newPassword
        	try(ResultSet rs2 = stc.executeQuery("SELECT * FROM login WHERE Username = 'mthoai17'")){
        		assertTrue(rs2.next());
        		System.out.println(rs2.getString("Password"));
        		assertNotSame("cats", rs2.getString("Password"));
        		assertEquals(newPassword, rs2.getString("Password"));
        		assertFalse(rs2.next());
        	}
        	
		}
		catch (SQLException e)
        {
			e.printStackTrace();
            fail(e.toString());
        }
		finally {
			//removes test database cases
			//d4.sqda.getConnection().rollback();
			d4.changePassword("cats");
		}
	
	}
	
	@Test
    void testLogHours() throws SQLException {
        Database d5 = new Database("mthoai17");
        d5.sqda.connectToDb();
        try (Statement stc = d5.sqda.getConnection().createStatement()) {
            int id = 9;
            String PayPeriod = "2/26/2021 - 3/12/2021";
            int hrs = 8;

            d5.logHours(id, PayPeriod, hrs);

            // checks if information was added to the log hours table
            try (ResultSet rs = stc.executeQuery("SELECT * FROM WorkHours WHERE employeeId = 9")) {
                assertTrue(rs.next());
                assertEquals(id, rs.getInt("employeeID"));
                assertEquals(PayPeriod, rs.getString("PayPeriod"));
                assertEquals(hrs, rs.getInt("HoursWorked"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }
    
    @Test
    void testRequestLeave() throws SQLException{
        Database d6 = new Database("mthoai17");
        d6.sqda.connectToDb();
        try (Statement stc = d6.sqda.getConnection().createStatement()) {
            int id = 1;
            int anLeave = 20;
            int compLeave = 21;
            int sickLeave = 22;
            
            int tanLeave;
            int tcompLeave;
            int tsickLeave;
            try (ResultSet rs = stc.executeQuery("SELECT * FROM leave WHERE employeeId = 1")) {
                assertTrue(rs.next());
                tanLeave = rs.getInt("AnnualLeave");
                tcompLeave = rs.getInt("CompLeave");
                tsickLeave = rs.getInt("SickLeave");
                assertFalse(rs.next());
            }
            d6.requestLeave(id, anLeave, compLeave, sickLeave);
            
            // checks if information was added to the leave table
            try (ResultSet rs = stc.executeQuery("SELECT * FROM leave WHERE employeeId = 1")) {
                assertTrue(rs.next());
                assertEquals(tanLeave - 20, rs.getInt("AnnualLeave"));
                assertEquals(tsickLeave - 22, rs.getInt("SickLeave"));
                assertEquals(tcompLeave - 21, rs.getInt("CompLeave"));
                assertFalse(rs.next());
            }
        
        }catch (SQLException e) {
            e.printStackTrace();
            fail(e.toString());
      }
    }
}
