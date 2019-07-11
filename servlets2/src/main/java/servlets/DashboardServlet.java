package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder result = new StringBuilder();
        result.append("<html><head><title>WONDERLAND BY JOHN LAWAL</title>");
        result.append("<link href='https://johnlawal.github.io/WAP/hw3/style.css' rel='stylesheet'/> </head><body>");
        result.append("<h1>This is what you came for :)</h1>");
        result.append("<p>How do you love this?</p>");
        result.append("<a href='logout'>Click here to Logout</a>");
        result.append("</body></html>");

        PrintWriter out = response.getWriter();
        out.print(result);

    }
}
