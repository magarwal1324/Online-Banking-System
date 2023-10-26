import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
//for getting a generic servlet class
// for getting the HttpServlet.
public class fp3 extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        res.setContentType("text/html");
        PrintWriter pw1=res.getWriter();
      String email=req.getParameter("e");
       
        
        
        try{
             HttpSession ses=req.getSession();
            ses.setAttribute("nm1",email);
//            HttpSession ses=req.getSession();
//            String s1=(String)ses.getAttribute("nm1");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","root","123");
            Statement stmt=con.createStatement();
            
            
           String q1="select * from signup where email='"+email+"'";
            ResultSet rs=stmt.executeQuery(q1);
            
            if(rs.next()){
               pw1.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <title>Online Banking - New Password</title>\n" +
"    <link rel=\"stylesheet\" href=\"styles.css\">\n" +
"    <style>\n" +
"        body {\n" +
"            font-family: Arial, sans-serif;\n" +
"            background-image: url(7.png);\n" +
"            background-size: cover;\n" +
"            margin: 0;\n" +
"            padding: 0;\n" +
"        }\n" +
"        \n" +
"        .container {\n" +
"            display: flex;\n" +
"            flex-direction: column;\n" +
"            align-items: center;\n" +
"            justify-content: center;\n" +
"            height: 100vh;\n" +
"            \n" +
"        }\n" +
"        form {\n" +
"    background-color: #fff;\n" +
"    border: 1px solid #ccc;\n" +
"    border-radius: 5px;\n" +
"    padding: 20px;\n" +
"    width: 400px;\n" +
"    max-width: 90%;\n" +
"}\n" +
"        \n" +
"        h1 {\n" +
"            text-align: center;\n" +
"            margin-bottom: 20px;\n" +
"        }\n" +
"        \n" +
"        .form-group {\n" +
"            margin-bottom: 20px;\n" +
"        }\n" +
"        \n" +
"        label {\n" +
"            display: block;\n" +
"            font-weight: bold;\n" +
"            margin-bottom: 5px;\n" +
"        }\n" +
"        \n" +
"        input[type=\"password\"] {\n" +
"            width: 100%;\n" +
"            padding: 8px;\n" +
"            border: 1px solid #ccc;\n" +
"            border-radius: 5px;\n" +
"        }\n" +
"        \n" +
"        input[type=\"submit\"] {\n" +
"            width: 100%;\n" +
"            padding: 10px;\n" +
"            background-color: #4CAF50;\n" +
"            color: #fff;\n" +
"            border: none;\n" +
"            border-radius: 5px;\n" +
"            cursor: pointer;\n" +
"        }\n" +
"        \n" +
"        input[type=\"submit\"]:hover {\n" +
"            background-color:#45a049;\n" +
"        }\n" +
"        \n" +
"    </style>\n" +
"</head>\n" +
"<body>\n" +
"    <div class=\"container\">\n" +
"        <h1>Change Password</h1>\n" +
"        <form action=\"fp4\" method=\"GET\">\n" +
"            <div class=\"form-group\">\n" +
"                <label for=\"newPassword\">New Password:</label>\n" +
"                <input type=\"password\" id=\"newPassword\" name=\"newPassword\" required>\n" +
"            </div>\n" +
"            <div class=\"form-group\">\n" +
"                <label for=\"confirmPassword\">Confirm Password:</label>\n" +
"                <input type=\"password\" id=\"confirmPassword\" name=\"confirmPassword\" required>\n" +
"            </div>\n" +
"            <div class=\"form-group\">\n" +
"                <input type=\"submit\" value=\"Submit\">\n" +
"            </div>\n" +
"        </form>\n" +
"    </div>\n" +
"</body>\n" +
"</html>");
        
            }
            else{
                pw1.println("Unsuccess");
                con.close();
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