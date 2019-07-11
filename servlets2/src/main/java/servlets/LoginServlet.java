package servlets;

import entities.User;
import entities.Userbase;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(name = "LoginServlet",
        urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        StringBuilder result = new StringBuilder();

        if (Userbase.userExists(new User(username, password))) {
            result.append("Access Granted");
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            session.setMaxInactiveInterval(3600);
            response.sendRedirect("dashboard");
        } else {
            result.append("<html><head><title>WONDERLAND BY JOHN LAWAL</title>");
            result.append("<link href='https://johnlawal.github.io/WAP/hw3/style.css' rel='stylesheet'/> </head><body>");
            result.append("<h1>Access Denied!</h1>");
            result.append("<a href='login'>Click here to try again</a>");
            result.append("</body></html>");
        }


        PrintWriter out = response.getWriter();
        out.print(result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder result = new StringBuilder();
        result.append("<html><head><title>WONDERLAND BY JOHN LAWAL</title>");
        result.append("<link href='https://johnlawal.github.io/WAP/hw3/style.css' rel='stylesheet'/> </head><body>");
        result.append("<h1>Welcome</h1><form method='post' action='login'>");
        result.append("<fieldset><legend>Kindly provide your login details</legend><div><input type='text' name='username' placeholder='Enter your Username' required /></div>");
        result.append("<div><input type='password' name='password' placeholder='Enter your Password' required /></div>");
//        result.append("<div><input type='text' name='problem' placeholder='Enter your problem' required /></div>");

        result.append("<div><input type='submit' value='Login'/></div></fieldset></form></body></html>");

        PrintWriter out = response.getWriter();
        out.print(result);
    }
}
