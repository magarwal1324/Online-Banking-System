import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class withdrawmoney extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter pw1 = res.getWriter();
        String em = req.getParameter("eml");
        String account_number = req.getParameter("account_num");
        String pin_number = req.getParameter("pin_num");
        String dep_amount = req.getParameter("amt");
//        pw1.println(em);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "root", "123");
            Statement stmt = con.createStatement();
//            pw1.println(em);

            String q3 = "select * from account_detail where email='" + em + "'";
//            pw1.println(q3);

            ResultSet x0 = stmt.executeQuery(q3);
            if (x0.next()) {
                int amt = x0.getInt("BALANCE"); // Use getInt() for numeric columns
//                pw1.println("Current Balance: " + amt);

                int x2 = Integer.parseInt(dep_amount);
                int x4 =amt-x2;
//                pw1.println("Updated Balance: " + x4);

                String q1 = "UPDATE account_detail SET BALANCE=" + x4 + " WHERE email='" + em + "'";
                int x = stmt.executeUpdate(q1);
                if (x > 0) {
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
"        font-size: 32px;\n" +
"        margin-bottom: 150px;\n" +
"      }\n" +
"      \n" +
"      .balance-section{\n" +
"        margin: 20px 0;\n" +
"      }\n" +
"      \n" +
"      h2 {\n" +
"        font-size: 24px;\n" +
"       \n" +
"      }\n" +
"      \n" +
"      p {\n" +
"        font-size: 20px;\n" +
"        font-weight: bold;\n" +
"      }\n" +
"  </style>\n" +
"</head>\n" +
"<body>\n" +
"  <div class=\"container\">\n" +
"    <h1>Successfully Done!</h1>\n" +
"    <div class=\"balance-section\">\n" +
"      <h2>withdraw Money:</h2>\n" +dep_amount
+
"      <h2>Total Balance:</h2>\n" +x4
+
"    </div>\n" +
"  </div>\n" +
"</body>\n" +
"</html>");
//                    pw1.println(x0.getString(3));
                } else {
                    pw1.println("Not found");
                }
            } else {
                pw1.println("Email not found");
            }

            con.close(); // Close the connection after use
        } catch (Exception e) {
            pw1.println(e);
        }
    }
}
