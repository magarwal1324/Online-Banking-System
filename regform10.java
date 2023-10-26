
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.*;   //for generic servlet class 
import javax.servlet.http.*;  //for getting http servlet class 

public class regform10 extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter pw1 = res.getWriter();
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phoneno = req.getParameter("phone-number");
        String address = req.getParameter("address");
        String state = req.getParameter("state");
        String city = req.getParameter("city");
        String pincode = req.getParameter("pin-code");
        String dob = req.getParameter("dob");
        String gender = req.getParameter("gender");
//        String bal="0";

//      pw1.println(city);
        try {

            HttpSession ses = req.getSession();
            ses.setAttribute("nm1", email);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "root", "123");
            Statement stmt = con.createStatement();

//    pw1.println(city);
            String q1 = "insert into signup values('" + email + "','" + password + "','" + phoneno + "','" + address + "',"
                    + "'" + state + "','" + city + "','" + pincode + "','" + gender + "','" + dob + "','" + name + "','" + ("SRM" + phoneno) + "')";
//        pw1.println(q1);
//String q2="update account_detail join signup on account_detail.email=signup.email set balance=0";
            int x = stmt.executeUpdate(q1);
            
            String q2="insert into account_detail values ('"+("SRM"+phoneno)+"','"+email+"','"+0+"')";
            
            
            
            int y=stmt.executeUpdate(q2);
            if (x > 0 && y>0) {
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
            } else {
                pw1.println("Not found");
                con.close();
            }

        } catch (Exception e) {
            pw1.println(e);
        }
//        //response from servlet
    }
}
//
