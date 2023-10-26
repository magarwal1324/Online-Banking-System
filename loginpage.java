
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.*;   //for generic servlet class 
import javax.servlet.http.*;  //for getting http servlet class 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginpage")
public class loginpage extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter pw1 = res.getWriter();

        String email = req.getParameter("email");
        String password = req.getParameter("password");
//        pw1.println(city);
        try {
            HttpSession ses = req.getSession();
            ses.setAttribute("nm1", email);

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "root", "123");
            Statement stmt = con.createStatement();

            String q1 = "select * from signup where email='" + email + "' and password='" + password + "'";
//  pw1.println(q1);
            ResultSet rs = stmt.executeQuery(q1);
//       pw1.println(q1);
//       pw1.println(rs);
            if (rs.next()) {
//               pw1.println("a");

                pw1.println("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "<head>\n"
                        + "  <title>Welcome Page</title>\n"
                        + "  <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n"
                        + "  <style>\n"
                        + "    body {\n"
                        + "      margin: 0;\n"
                        + "      padding: 0;\n"
                        + "      font-family: Arial, sans-serif;\n"
                        + "      background-image: url(7.png);\n"
                        + "      background-size: cover;\n"
                        + "    }\n"
                        + "    \n"
                        + "    header {\n"
                        + "      \n"
                        + "      padding: 20px;\n"
                        + "      text-align: right;\n"
                        + "    }\n"
                        + "    \n"
                        + "    nav ul {\n"
                        + "      list-style-type: none;\n"
                        + "      margin: 0;\n"
                        + "      padding: 0;\n"
                        + "    }\n"
                        + "    \n"
                        + "    nav ul li {\n"
                        + "      display: inline;\n"
                        + "      \n"
                        + "    }\n"
                        + "    \n"
                        + "    nav ul li a {\n"
                        + "      color: black;\n"
                        + "      text-decoration: none;\n"
                        + "      padding: 10px;\n"
                        + "    }\n"
                        + "    nav ul li a:hover{\n"
                        + "      border:1px solid black;\n"
                        + "      border-radius: 4px;\n"
                        + "      cursor: pointer;\n"
                        + "      padding: 7px;\n"
                        + "    }\n"
                        + "    \n"
                        + "    .content {\n"
                        + "      margin: 20px;\n"
                        + "      text-align: center;\n"
                        + "    }\n"
                        + "    \n"
                        + "    h1 {\n"
                        + "      color: black;\n"
                        + "      margin-top: 50px;\n"
                        + "      font-weight: normal;\n"
                        + "      font-size: 44px;\n"
                        + "    }\n"
                        + "    \n"
                        + "    .actions {\n"
                        + "      margin-top: 50px;\n"
                        + "    }\n"
                        + "    \n"
                        + "    .btn-deposit, .btn-withdraw {\n"
                        + "      display: inline-block;\n"
                        + "      padding: 10px 20px;\n"
                        + "      margin: 10px;\n"
                        + "      cursor: pointer;\n"
                        + "      border: none;\n"
                        + "      color: black;\n"
                        + "      text-decoration: none;\n"
                        + "      border-radius: 4px;\n"
                        + "    }\n"
                        + "    \n"
                        + "    .btn-deposit:hover, .btn-withdraw:hover {\n"
                        + "      background: linear-gradient(#a7f7b8,#709ff7);\n"
                        + "      color: black;\n"
                        + "      border: 1px solid black;\n"
                        + "    }\n"
                        + "    \n"
                        + "  </style>\n"
                        + "</head>\n"
                        + "<body>\n"
                        + "  <header>\n"
                        + "    <nav>\n"
                        + "      <ul>\n"
                        + "        <li><a href=\"#\">Home</a></li>\n"
                        + "        <li><a href=\"about.html\">About</a></li>\n"
                        + "        <li><a href=\"contact.html\">Contact</a></li>\n"
                        + "        <li><a href=\"home.html\">Logout</a></li>\n"
                        + "      </ul>\n"
                        + "    </nav>\n"
                        + "  </header>\n"
                        + "  \n"
                        + "  <div class=\"content\">\n"
                        + "    <h1>SRM Bank</h1>\n"
                        + "    <div class=\"actions\">\n"
                        + "      <a href=\"deposit-money.html\" class=\"btn-deposit\">Deposit Money</a>\n"
                        + "      <a href=\"withdraw-money.html\" class=\"btn-withdraw\">Withdraw Money</a>\n"
                        + "<a href=\"view-account.html\" class=\"btn-withdraw\">Account Detail</a>\n"
                        + "\n"
                        + "    </div>\n"
                        + "  </div>\n"
                        + "</body>\n"
                        + "</html>");
            } else {
                pw1.println("<!DOCTYPE html>\n"
                        + "<html lang=\"en\">\n"
                        + "<head>\n"
                        + "  <meta charset=\"UTF-8\">\n"
                        + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                        + "  <title>UnSuccess</title>\n"
                        + "  <link rel=\"stylesheet\" href=\"styles.css\">\n"
                        + "  <style>\n"
                        + "    body {\n"
                        + "        margin: 0;\n"
                        + "        padding: 0;\n"
                        + "        display: flex;\n"
                        + "        justify-content: center;\n"
                        + "        align-items: center;\n"
                        + "        height: 100vh;\n"
                        + "        background-image: url(7.png);\n"
                        + "        background-size: cover;\n"
                        + "      }\n"
                        + "      \n"
                        + "      .container {\n"
                        + "        text-align: center;\n"
                        + "      }\n"
                        + "      \n"
                        + "      h1 {\n"
                        + "        font-size: 60px;\n"
                        + "        margin-bottom: 20px;\n"
                        + "      }\n"
                        + "      \n"
                        + "      button {\n"
                        + "        padding: 10px 20px;\n"
                        + "        font-size: 18px;\n"
                        + "        color:black;\n"
                        + "        text-decoration: none;\n"
                        + "        border: none;\n"
                        + "        border-radius: 4px;\n"
                        + "        cursor: pointer;\n"
                        + "      }\n"
                        + "      \n"
                        + "      button:hover {\n"
                        + "background: linear-gradient(#a7f7b8,#709ff7);;\n"
                        + "      }\n"
                        + "      \n"
                        + "  </style>\n"
                        + "</head>\n"
                        + "<body>\n"
                        + "  <div class=\"container\">\n"
                        + "    <h1>Not Found!</h1>\n"
                        + "    \n"
                        + "    <a href=\"log-in.html\"><button class=\"button\">Back</button></a>\n"
                        + "  </div>\n"
                        + "  <script>\n"
                        + "    function goToNextPage() {\n"
                        + "      // Replace \"next-page.html\" with the URL of the next page you want to navigate to\n"
                        + "      window.location.href = \"next-page.html\";\n"
                        + "    }\n"
                        + "  </script>\n"
                        + "</body>\n"
                        + "</html>");
                con.close();
            }

        } catch (Exception e) {
            pw1.println(e);
        }
    }
}
