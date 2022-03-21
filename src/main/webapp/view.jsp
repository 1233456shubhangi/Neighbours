<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<html>
    <head>
        <title>student informations</title>
    </head>
    <body>
       <font color="green" size="5" >Congratulations !</font>
        <h2><p>Welcome <%=request.getParameter("name")%>...<br></p></h2>
        <%String name=request.getParameter("name");  
        
        
        try
    	{
    		Connection con=null;
    	       
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housecolony","root", "root");
    		//System.out.println("connection value is "+con);
    		Statement statement=con.createStatement();
    	

    		String query = "SELECT * From neighbours where name='"+name+"'";
    	
    		ResultSet rs=statement.executeQuery(query);
    		while(rs.next())
    		{
        
        
        
        
        %>
   		<TABLE style="background-color: #c7bcbb;" WIDTH="30%">
              <tr width="100%">
                             <tr>
                    <td width="50%">Mobile No</td>
                    <td width="50%"><%=rs.getString(3)%></td>
                </tr>
                
                
                <tr>
                    <td>area</td>
                    <td width="50%"><%=rs.getString(5)%></td>
                </tr>
                
                 <tr>
                    <td>house_no</td>
                    <td width="50%"><%=rs.getString(6)%></td>
                </tr>
                
                <tr>
                <td>City</td>
                <td width="50%"><%=rs.getString(7) %></td>
                </tr>
                
                 <tr>
                <td>State</td>
                <td width="50%"><%=rs.getString(8) %></td>
                </tr>
                
                 <tr>
                <td>Country</td>
                <td width="50%"><%=rs.getString(9) %></td>
                </tr>
                
                
                
				<tr><td></td><td align="right">
			  <a href="second.jsp">
					<font size="4" color="blue">edit</font></A>
			</td>
	    </tr>
        </table>
        <%
    	}
        
    	}catch(Exception e)
        {
        	System.out.println(e);
        }
        
        
        %>   
    </body>
</html>
</body>
</html>