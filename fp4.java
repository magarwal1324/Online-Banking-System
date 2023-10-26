import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
//for getting a generic servlet class
// for getting the HttpServlet.
public class fp4 extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        res.setContentType("text/html");
        PrintWriter pw1=res.getWriter();
        
        String new_password=req.getParameter("newPassword");
        
        try{
            HttpSession ses=req.getSession();
            String s1=(String)ses.getAttribute("nm1");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","root","123");
            Statement stmt=con.createStatement();
            
          
String q1="update signup set password='"+new_password+"' where email='"+s1+"'";

int x=stmt.executeUpdate(q1);
            if(x>0){
               pw1.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"  <meta charset=\"UTF-8\">\n" +
"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"  <title>Success Page</title>\n" +
"  <link rel=\"stylesheet\" href=\"styles.css\">\n" +
"  <style>\n" +
"    body {\n" +
"        margin: 0;\n" +
"        padding: 0;\n" +
"        display: flex;\n" +
"        justify-content: center;\n" +
"        align-items: center;\n" +
"        height: 100vh;\n" +
"        background-image: url(7.png);\n" +
"        background-size: cover;\n" +
"      }\n" +
"      \n" +
"      .container {\n" +
"        text-align: center;\n" +
"      }\n" +
"      \n" +
"      h1 {\n" +
"        font-size: 60px;\n" +
"        margin-bottom: 20px;\n" +
"      }\n" +
"      \n" +
"      button {\n" +
"        padding: 10px 20px;\n" +
"        font-size: 18px;\n" +
"        color:black;\n" +
"        text-decoration: none;\n" +
"        border: none;\n" +
"        border-radius: 4px;\n" +
"        cursor: pointer;\n" +
"      }\n" +
"      \n" +
"      button:hover {\n" +
"background: linear-gradient(#a7f7b8,#709ff7);;\n" +
"      }\n" +
"      \n" +
"  </style>\n" +
"</head>\n" +
"<body>\n" +
"  <div class=\"container\">\n" +
"    <h1>Successfully Done!</h1>\n" +
"    \n" +
"    <a href=\"log-in.html\"><button class=\"button\">Back to Login Page</button></a>\n" +
"  </div>\n" +
"  <script>\n" +
"    function goToNextPage() {\n" +
"      // Replace \"next-page.html\" with the URL of the next page you want to navigate to\n" +
"      window.location.href = \"next-page.html\";\n" +
"    }\n" +
"  </script>\n" +
"</body>\n" +
"</html>");
        
            }
            else{
                pw1.println("Unsuccess");
            }
        }
        catch(Exception e)
        {
            pw1.println(e);
        }
//        pw1.println("<html><body bgcolor=skyblue>");
//        pw1.println(" Name: "+nm+"<br>");
//        pw1.println(" Password: "+nm1+"<br>");
//        pw1.println(" Email: "+nm2+"<br>");
//        pw1.println(" Phone: "+nm3+"<br>");
//        pw1.println("</body></html>");
//        
    }
        
}