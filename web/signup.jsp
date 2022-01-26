<%@page contentType="text/html" import="java.sql.*"%>
<html><body>
<%
String name=request.getParameter("name");
String phoneno=request.getParameter("phoneno");
String email=request.getParameter("email");
String pass=request.getParameter("psw");
String age=request.getParameter("age");
String pro=request.getParameter("pro");
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","admin");
PreparedStatement stmt=con.prepareStatement("insert into signuptb values(?,?,?,?,?,?)");
stmt.setString(1,name);
stmt.setString(2,phoneno);
stmt.setString(3,email);
stmt.setString(4,pass);
stmt.setString(5,age);
stmt.setString(6,pro);
int row=stmt.executeUpdate();
if(row==1)
{
response.sendRedirect("success.html");
}
else
{
out.println("Registration FAILED!!!!");
%>
<jsp:include page="signup.html"></jsp:include>
    
<%
}
}catch(Exception e){out.println(e);}
%>
</body>
</html>