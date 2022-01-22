import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Login extends HttpServlet{

    @Override
protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out=response.getWriter();
    try{
       
         String email=request.getParameter("email");
        String pass=request.getParameter("psw");
       
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","admin");
        PreparedStatement p=con.prepareStatement("insert into logintb values(?,?)");
        p.setString(1,email);
        p.setString(2,pass);
        p.executeUpdate();
       out.println("<a href=homepage.html></a>");
    }
   catch(Exception ex){}
} 
}
