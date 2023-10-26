
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;

public class viewaccount extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter pw1 = res.getWriter();
        String em = req.getParameter("email");

        try {
            HttpSession ses = req.getSession();
            String s1 = (String) ses.getAttribute("nm1");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "root", "123");
            Statement stmt = con.createStatement();

            String q1 = "SELECT signup.name,signup.email,signup.phoneno,signup.account_num,account_detail.balance FROM signup JOIN account_detail ON signup.email = account_detail.email";
            ResultSet rs = stmt.executeQuery(q1);

            if (rs.next()) {
                pw1.println("<!DOCTYPE html>\n"
                        + "<html lang=\"en\">\n"
                        + "<head>\n"
                        + "  <meta charset=\"UTF-8\">\n"
                        + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                        + "  <title>View Balance</title>\n"
//                        +"<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">\n"
                        + "  <style>\n"
                        + "    body {\n"
                        + "      font-family: Arial, sans-serif;\n"
                        + "      margin: 0;\n"
                        + "      padding: 0;\n"
                       +" background-image: url(7.png);\n"
      +"background-size: cover;"
                        + "    }\n"
                        + "    \n"
                        + "    .container {\n"
                        + "      max-width: 400px;\n"
                        + "      margin: 40px auto;\n"
                        + "      padding: 20px;\n"
                        
                        + "      border-radius: 5px;\n"
                        + "      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\n"
                        + "    }\n"
                        + "    \n"
                        + "    h1 {\n"
                        + "      text-align: center;\n"
                        + "    }\n"
                        + "    \n"
                        + "    .user-details {\n"
                        + "      margin-bottom: 20px;\n"
                        + "    }\n"
                        + "    \n"
                        + "    .user-details label {\n"
                        + "      font-weight: bold;\n"
                        + "    }\n"
                        + "    \n"
                        + "    .balance {\n"
                        + "      text-align: center;\n"
                        + "      font-size: 24px;\n"
                        + "      margin-top: 30px;\n"
                        + "    }\n"
                        + "  </style>\n"
                        + "</head>\n"
                        + "<body>\n"
                        + "  <div class=\"container\">\n"
                        + "    <h1>View Balance</h1>\n"
                        + "    \n"
                        + "    <div class=\"user-details\">\n"
                        + "      <label for=\"user-name\">User Name:</label>\n"
                        + "      <span id=\"user-name\">" + rs.getString("name")
                        + "</span>\n"
                        + "    </div>\n"
                        + "    \n"
                        + "    <div class=\"user-details\">\n"
                        + "      <label for=\"account-number\">Email:</label>\n"
                        + "      <span id=\"account-number\">" + rs.getString("email")
                        + "</span>\n"
                        + "    </div>\n"
                        + "    \n"
                        + "    <div class=\"user-details\">\n"
                        + "      <label for=\"account-number\">Phone Number:</label>\n"
                        + "      <span id=\"account-number\">" + rs.getString("phoneno")
                        + "</span>\n"
                        + "    </div>\n"
                        + "    <div class=\"user-details\">\n"
                        + "      <label for=\"user-name\">Account Number:</label>\n"
                        + "      <span id=\"user-name\">" + rs.getString("account_num")
                        + "</span>\n"
                        + "    </div>\n"
                        + "    <div class=\"balance\">\n"
                        + "      <label for=\"balance\">Current Balance:Rs.</label>\n"
                        + "      <span id=\"balance\">" + rs.getString("balance")
                        + "</span>\n"
                        + "    </div>\n"
                        + "  </div>\n"
                        + "</body>\n"
                        + "</html>");
//                pw1.println(rs.getString("name"));
//                pw1.println(rs.getString("email"));
//                pw1.println(rs.getString("phoneno"));
//                pw1.println(rs.getString("account_num"));
//                pw1.println(rs.getString("balance"));
            } else {
                pw1.println("Not found");
            }

            // Close the resources
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            pw1.println(e);
        }
    }
}
