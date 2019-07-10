import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/support")
public class SupportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String support_ticket_id = UUID.randomUUID().toString();
        ServletContext sc = this.getServletContext();
        String support_email = sc.getInitParameter("support-email");

        StringBuilder result = new StringBuilder();
        result.append("<html><head><title>CSTECH SUPPORT BY JOHN LAWAL</title>");
        result.append("<link href='https://johnlawal.github.io/WAP/hw3/style.css' rel='stylesheet'/> </head><body>");
        result.append("<p>Thank you! ");
        result.append(name);
        result.append(" for contacting us.</p><p>You should receive reply from us within 24 hrs in your email address <strong>");
        result.append(email);
        result.append("</strong>.</p><p>Let us know in our support email <strong>");
        result.append(support_email);
        result.append("</strong> if you don\'t receive reply within 24 hrs.</p><p>Please be sure to attach your reference <strong>");
        result.append(support_ticket_id);
        result.append("</strong> in your email.</p>");
        result.append("</body></html>");

        PrintWriter out = response.getWriter();
        out.print(result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder result = new StringBuilder();
        result.append("<html><head><title>CSTECH SUPPORT BY JOHN LAWAL</title>");
        result.append("<link href='https://johnlawal.github.io/WAP/hw3/style.css' rel='stylesheet'/> </head><body>");
        result.append("<h1>Feel Free To Contact Us</h1><form method='post' action='support'>");
        result.append("<fieldset><legend>Kindly fill this form</legend><div><input type='text' name='name' placeholder='Enter your name' required /></div>");
        result.append("<div><input type='email' name='email' placeholder='Enter your email address' required /></div>");
        result.append("<div><input type='text' name='problem' placeholder='Enter your problem' required /></div>");
        result.append("<div><textarea rows='10' name='description' placeholder='Describe your problem' required></textarea></div>");
        result.append("<div><input type='submit' value='Help'/></div></fieldset></form></body></html>");

        PrintWriter out = response.getWriter();
        out.print(result);
    }
}
