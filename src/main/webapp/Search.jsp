<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.srcEmpCreation.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.sun.xml.internal.txw2.Document"%><html>
<%@page import="java.io.IOException" %>
<%@page import="java.io.PrintWriter" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.ResultSet" %>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Employee Records</title>

<script src="gen_validatorv4.js" type="text/javascript"></script>
<script type="text/javascript">

function validate(){
	
	var eIdSearch = document.form2.empIdSearch;
	
    	var letters = /^([A-Za-z][0-9]{7})+$/;  
    	if(eIdSearch.value.match(letters))  
    	{      		
    		return true;     		
    	   } else {
    	    		alert('Employee Id must have starting character as aplhabet and followed with 7 digit numerals eg: M1019010');  
    	    		eIdSearch.focus();  
    	    		return false;  
    	    }   	    	
	
  
	  return document.form.runvalidation();
	  
}
</script>

</head>
<body>

<h2 align="center">Search Employee Details</h2>
<form name="form2" action ="EmpServlet"  method="post" onSubmit="return validate();">
      <table align="center" width="50%" border="2" bgcolor="#99FFCC">

		<tr>
			<td style="width:50%">Search for Employee with Id(MXXXXXXX): </td>
			<td><input type="text" name="empIdSearch"> </td>  
          	<td align="center"><input type="submit" value="Submit"></td>    
        </tr> 
        
      </table>       
<div style="color: #FF0000;" align="center">${errorMessage}</div>
<%
Employee emp=new Employee();
if(request.getAttribute("emp")!=null){	
 emp=(Employee)request.getAttribute("emp");
 emp.getName();
%>
<h2 align="center">Employee Records</h2>
<table align="center" border="1">
  <tr>
    	<td><b>Employee Name</b></td>
    	<td><b>Employee ID</b></td>
    	<td><b>Employee Competency</b></td>
    	<td><b>Sub Practise</b></td>
    	<td><b>Vertical</b></td>
  </tr>
   
  <tr>
    <td align="center"><%=emp.getName()%></td>
    <td align="center"><%=emp.getId()%></td>
    <td align="center"><%=emp.getCompt() %></td>
    <td align="center"><%=emp.getPrac() %></td>
    <td align="center"><%=emp.getVert() %></td>
  </tr> 
</table>
<% 
}
%>  
<table align="Right"> 
	<tr>
       <td align="Right"> <a href="index.jsp">Click to Go back </a>  </td>  
    </tr>
</table>  
      
</form>
</body>
</html>