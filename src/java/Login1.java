import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Login1 extends HttpServlet{

    @Override
protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out=response.getWriter();
    try{
       
        String email=request.getParameter("email");
        String pass=request.getParameter("psw");
        ResultSet rs=null;
    
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","admin");
        Statement stmt=con.createStatement();
        rs=stmt.executeQuery("SELECT password_id FROM signuptb where email_id='"+email+"'" );
        rs.next();
        if(pass.equals(rs.getString(1)))
{
            RequestDispatcher rd=request.getRequestDispatcher("homepage.html");
            rd.forward(request,response);
}

else
{
    out.println("<font color='red'><center><b>You have entered the wrong password</center></b></font>");
        RequestDispatcher rd=request.getRequestDispatcher("index.html");
        rd.include(request, response);    }
   
    }  
    catch(Exception ex){}
}
}


