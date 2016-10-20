
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.sun.xml.internal.txw2.Document"%><html>
<%@page import="java.io.IOException" %>
<%@page import="java.io.PrintWriter" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.ResultSet" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Database</title>
<script src="gen_validatorv4.js" type="text/javascript"></script>
<script type="text/javascript">
function validate(){
	
	var eName = document.form.empname;
	var eId = document.form.empid;
	var eComp = document.form.empCompt;
	var ePrac = document.form.empPrac;
	var eVert = document.form.empVert;
	
	if(eName.value=="" || eName.value.length > 50)
    {
      alert("Employee Name should not be left blank / Maximum lenght is 50");
      document.form.empname.focus();
      return false;
    } 
	else {
    	var letters = /^[A-Za-z]+$/;  
    	if(eName.value.match(letters))  
    	{  
    		eId.focus();
    		
    		if(eId.value=="")
    	    {
    	      alert("Employee ID should not be left blank");
    	      document.form.empid.focus();
    	      return false;
    	    } else {
    	    	var idmatch = /^([A-Za-z][0-9]{7})+$/; 
    	    	if(eId.value.match(idmatch))  
    	    	{  
    	    		eComp.focus();
    	    		
    	    		if(eComp.value=="")
    	    	    {
    	    	      alert("Employee Competency should not be left blank");
    	    	      document.form.empCompt.focus();
    	    	      return false;
    	    	    } else {
    	    	    	var compmatch = /^([A-Za-z][0-9]{1,2})+$/;
    	    	    	if(eComp.value.match(compmatch))  
    	    	    	{  
    	    	    		ePrac.focus();
    	    	    		
    	    	    		
    	    	    		 if(ePrac.value=="")
    	    	    		    {
    	    	    		      alert("Practise should not be left blank");
    	    	    		      document.form.empPrac.focus();
    	    	    		      return false;
    	    	    		    } else {
    	    	    		    	
    	    	    		    	if (ePrac.value.match(letters)){
    	    	    		    		eVert.focus();
    	    	    		    	    if(eVert.value=="")
    	    	    		    	     {
    	    	    		    	       alert("Vertical should not be left blank");
    	    	    		    	       document.form.empVert.focus();
    	    	    		    	       return false;
    	    	    		    	     } else {
    	    	    		    	    	 if (eVert.value.match(letters)){ 
    	    	    		    	    		 return true;
    	    	    		    	    	 } else {
    	    	    		    	    		 alert("Vertical  must have alphabet characters only");
    	    	    	    		    	       document.form.empVert.focus();
    	    	    	    		    	       return false;
    	    	    		    	    	 }    	    	    		    	    	 
    	    	    		    	     }
    	    	    		    		
    	    	    		    		return true;
    	    	    		    	} else {
    	    	    		    		alert('Employee Practice must have alphabet characters only');  
    	    	    		    		ePrac.focus();  
    	    	    		    		return false; 
    	    	    		    	}
    	    	    		    	
    	    	    		    	
    	    	    		    }
    	    	    		
    	    	    		
    	    	    		return true;
    	    	    	} else {
    	    	    		alert("Employee Competency be in the following format CX ex: C2");
    	    	    	     eComp.focus();
    	    	    	      return false;
    	    	    	}
    	    	    	
    	    	    }
    	    		return true;
    	    	} else {
    	    		alert('Employee Id must have starting character as aplhabet and followed with 7 digit numerals eg: M1019010');  
    	    		eId.focus();  
    	    		return false;  
    	    	}   	    	
    	    	
    	    }   		
    		
    		return true;  
    	}  
    	else  
    	{  
    		alert('Employee must have alphabet characters only');  
    		eName.focus();  
    		return false;  
    	}  
    }
    	
	  
	  return document.form.runvalidation();
	  
}

</script>
</head>
<body>
<h1>Mindtree Employee Form </h1>
<hr/>
<form name="form" action ="EmpServlet"  method="post" onSubmit="return validate();" >
	<h2 align="center">Enter Employee details below</h2>
	<table align="center" bgcolor="#99FFCC" border="2" width="50%"> 
		
		<tr> <td style="width:50%" >Employee Name: </td>
			<td> <input type="text" name="empname"> </td>
		</tr>
		<tr> 
			<td style="width:50%">Employee id:</td>
			<td ><input type="text" name="empid"></td>
		</tr>
		<tr> 
			<td style="width:50%">Competency:</td>
			<td><input type="text" name="empCompt"> </td>
		</tr>
		<tr> 
			<td style="width:50%">Sub Practice:</td>
			<td> <input type="text" name="empPrac"> </td>
		</tr>
		<tr>
			<td style="width:50%">Vertical: </td>
			<td><input type="text" name="empVert"> </td>		
		</tr>	

	</table>
	<table align="center" width="50%">
		<tr>           
          <td align="left"> <a href="Search.jsp">Click to Search Employee Records </a>  </td>
          <td align="right"><input type="submit" value="Submit"></td>          
        </tr> 
        <tr>
            
        </tr>       
     </table> 
<br/>

<div style="color: #FF0000;" align="center">${errorMessage}</div>

<%  
Class.forName("com.mysql.jdbc.Driver");

System.out.println("driver loaded");
System.out.println("Driver is loaded");
Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPDB?user=root&password=root");
System.out.println("Connection created");
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("select * from EMP_TBL");%>

<h2 align="center">Employee Records</h2>

<div style="overflow:scroll;height:200px;width:100%;overflow:auto">
	<table align="center" border="1">

  	<tr>
    	<td><b>Employee ID</b></td>
    	<td><b>Employee Name</b></td>
    	<td><b>Employee Competency</b></td>
    	<td><b>Sub Practise</b></td>
    	<td><b>Vertical</b></td>
  	</tr>
  	 <% while (rs.next()) {%>
  	<tr>
  	 	<td align="center"><%=rs.getString("emp_Id")%></td>
    	<td align="center"><%=rs.getString("emp_Name") %></td>
    	<td align="center"><%=rs.getString("emp_Compt") %></td>
    	<td align="center"><%=rs.getString("emp_Prac") %></td>
    	<td align="center"><%= rs.getString("emp_Vert") %></td>

  	</tr>
 	<%}%>
	</table> 
	</div>
</form>
<br/>
</body>
</html>



