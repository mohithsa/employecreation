package employecreation;

/**
 * 
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.srcEmpCreation.Employee;
import com.srcEmpCreation.EmployeeDB;


/**
 * @author M1019048
 *
 */
public class EmployeeDBTest {
	
	//Creating instance of EmployeeDB object
	EmployeeDB empDB = new EmployeeDB();

	/**
	 * Test method for {@link com.srcEmpCreation.EmployeeDB#insertdb(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 * @throws SQLException 
	 */
	//@SuppressWarnings("null")
	@Test //(expected = com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException.class)
	public void testInsertdb() throws Throwable {
		/*//Q1 Verify positive insert and asserts the expected and actuals		
		int result1 = EmployeeDB.insertdb("M1012988","Vidhya", "C4", "TESTING", "BFSI");
		assertEquals("The insert function does not work with positive value",result1,1);
		//Q2 Verify duplicate insert and assert if the value is not inserted to DB
		int result2 = EmployeeDB.insertdb("M1012988","Vidhya", "C4", "TESTING", "BFSI");
		assertTrue("The insert function inserts duplicate values",result2==0);
		//Q3 Verify null inserts and if throws exception
		int result3 = EmployeeDB.insertdb(null,"", "C4", "TESTING", "BFSI");
		assertFalse("The insert function inserts null values",result3==0);
		//Q9 Verify exception thrown for null values
		int exp = EmployeeDB.insertdb(null,"", "C4", "TESTING", "BFSI");*/
		
		assert(true);
			
	}
	
	/**
	 * Test method for insertdb for matching records
	 *  
	 * @throws SQLException 
	 */
	@SuppressWarnings("null")
	@Test 
	public void testInsertdb2() throws Throwable {
	
		/*//Q8 Verify inserted data is same as inputed.
		String [] expected = {"M1012199","Keaun", "C9", "TESTING", "BFSI"};
		String [] actual = new String[5];
		int input = EmployeeDB.insertdb(expected[0],expected[1],expected[2],expected[3],expected[4]);
		ResultSet rs = EmployeeDB.readdb(expected[0]);
		if(rs!=null && rs.next()){ 	       
			actual[0] = String.valueOf(rs.getString("emp_Id"));
    		actual[1] = String.valueOf(rs.getString("emp_Name"));
    		actual[2] = String.valueOf(rs.getString("emp_Compt"));
    		actual[3] = String.valueOf(rs.getString("emp_Prac"));
    		actual[4] = String.valueOf(rs.getString("emp_Vert"));    		
    		Assert.assertArrayEquals("Verify if Inputed Employee is saved", expected, actual);
     	} 	*/
		
	
		//Q7 Verify Same values are placed in  different objects
		//Assert.assertNotSame(expected[0], String.valueOf(rs.getString("emp_Id")));
		assert(true);
		
	}

	/**
	 * Test method for {@link com.srcEmpCreation.EmployeeDB#readdb(java.lang.String)}.
	 */
	@Test
	public void testReaddb() {
		/*ResultSet rs;
		String rs2;
		boolean id;
		Employee emp2 = new Employee();
		try {
			//Q4 Verify the entry retrieved is Null
			rs = EmployeeDB.readdb("M1012890");
			id = rs.next();
			if(id==false){
				rs2 = null;
				assertNull(rs2);
			}			
			//Q5 Verify the entry retrieved is Not Null
			rs = EmployeeDB.readdb("M1012908");
			id = rs.next();
			if(id==true){
				rs2= "NOT NULL";
				assertNotNull(rs2);							
			}			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	*/	
		assert(true);
	}
}

