package com.srcEmpCreation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srcEmpCreation.Employee;

import com.srcEmpCreation.EmployeeDB;

/**
 * Servlet implementation class empServlet
 */
/**
 * @author M1019048
 *
 */
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement preparedStatement = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**/
	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 System.out.println("----- InsertEmployeeServlet -----");
	        try {
	        	// Get the employee value submitted from index.jsp page through HttpServletRequest object
	            String empName=request.getParameter("empname");
	            String empId=request.getParameter("empid");
	            String empCompt=request.getParameter("empCompt");
	            String empPrac=request.getParameter("empPrac");
	            String empVert=request.getParameter("empVert");
	            String empIdSearch= request.getParameter("empIdSearch");           
	            
	             
	            //Set the Employee values into Employee Object
	            Employee employee=new Employee();
	            employee.setName(empName);
	            employee.setId(empId);
	            employee.setCompt(empCompt);
	            employee.setPrac(empPrac);
	            employee.setVert(empVert);
	            employee.setempIdSearch(empIdSearch);
	            
	            
	            //Verify if employee ID Search value exists, if exists perform search
	            
	            if(empIdSearch!=null) {	            	
	            	searchEmployee(request,response,empIdSearch);              	           	
	            }            
	            
	            // Else perform insert with duplicate employee id validation
	            else {
	            	insertEmployee(request,response,employee);
	            }

	        }catch(Exception e){
	            e.printStackTrace();
	        }		
		
	}
	
	/**
	 * Function to Search EMP DB for the employee
	 * @param request
	 * @param response
	 * @param empIdSearch
	 */
	public void searchEmployee(HttpServletRequest request, HttpServletResponse response,String empIdSearch){
		ResultSet rs;
		try {
			rs = EmployeeDB.readdb(empIdSearch);
			if(rs!=null && rs.next()){      	            		
	    		Employee emp2 =new Employee();
	    		emp2.setName(rs.getString("emp_Name"));
	    		emp2.setId(rs.getString("emp_Id"));
	    		emp2.setCompt(rs.getString("emp_Compt"));
	    		emp2.setPrac(rs.getString("emp_Prac"));
	    		emp2.setVert(rs.getString("emp_Vert"));
	            request.setAttribute("emp",emp2);
	            request.getRequestDispatcher("/Search.jsp").forward(request, response);
	    	
	    		}	            		
	    	else {
	    		request.setAttribute("errorMessage", "Employee ID does not exists in record");
	    		request.getRequestDispatcher("/Search.jsp").forward(request, response);
	    					            
	    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     	
    	 
	}

	
	/**
	 * Function to check and insert Employee details into EMPDB
	 * @param request
	 * @param response
	 * @param employee
	 */
	public void insertEmployee(HttpServletRequest request, HttpServletResponse response,Employee employee){
		int flag = 0;        
        flag = EmployeeDB.insertdb(employee.getId(), employee.getName(), employee.getCompt(),
        		employee.getPrac(), employee.getVert());
        
        if (flag == 0) {
            request.setAttribute("errorMessage", "Employee ID is already in use, Please enter a different ID");
        } else if (flag ==1) {
        	request.setAttribute("errorMessage", "Employee details successfully added");
        }		            
        
		try {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			request.setAttribute("emp",employee);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	
	
}
