package com.srcEmpCreation;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author M1019048
 *
 */
public class EmployeeDB {
	
	
	static Connection con;
	static Statement stmt;

	/**
	 * Method to read and insert data into DB
	 * @param emp_Id
	 * @param emp_Name
	 * @param emp_Compt
	 * @param emp_Prac
	 * @param emp_Vert
	 * @return
	 */
	public static int insertdb(String emp_Id, String emp_Name, String emp_Compt,
		String emp_Prac, String emp_Vert) {
		
		
		int ret = 0;
		ResultSet rs1;
		int total = 0;
		try {
			//Gets the result set for the Employee ID
			rs1 = readdb(emp_Id);
			while (rs1.next()) {
				total++;
			}
			/*
			 * If the count of columns from the returned result is Zero then
			 * inserts the employee data into DB
			 */
			if (total == 0) {
				String sql = "INSERT INTO EMP_TBL " + "VALUES (?,?,?,?,?)";
				PreparedStatement preparedStatement;
				try {
					preparedStatement = con.prepareStatement(sql);
					preparedStatement.setString(1, emp_Id);
					preparedStatement.setString(2, emp_Name);
					preparedStatement.setString(3, emp_Compt);
					preparedStatement.setString(4, emp_Prac);
					preparedStatement.setString(5, emp_Vert);
					int i = preparedStatement.executeUpdate();
					if (i > 0)
						ret = 1;
				} catch (SQLException e) {
					ret = 3;
					e.printStackTrace();
				}

			}

		} catch (SQLException e1) {
			ret = 3;
			e1.printStackTrace();
		}
		return ret;
	}

	
	/**
	 * Queries the DB for the emp_Id and returns result set
	 * @param emp_Id
	 * @return result set
	 * @throws SQLException
	 */
	public  static ResultSet readdb(String emp_Id) throws SQLException {
		PreparedStatement ps = connectDb().prepareStatement("select * from EMP_TBL where emp_Id=?");
		ps.setString(1, emp_Id);
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int total = rsmd.getColumnCount();
		return rs;
	}

	/**
	 * Connects to DB
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection connectDb() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPDB?user=root&password=root");
			stmt = con.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * @throws SQLException
	 * Closes the Connection
	 */
	public void closeconnection() throws SQLException {
		con.close();
		System.out.println("connection closed");
	}

}

