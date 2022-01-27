package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<html><body>\n");

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
out.println("Registered Successfully");
response.sendRedirect("success.html");
}
else
{
out.println("Registration FAILED!!!!");

      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "signup.html", out, false);
      out.write("\n");
      out.write("    \n");

}
}catch(Exception e){out.println(e);}

      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
