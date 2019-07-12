package servlets;

import entities.User;
import entities.Userbase;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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

            //if remember me is checked
            if (request.getParameter("remember") != null) {
                Cookie usernameCookie = new Cookie("Username", username);
                usernameCookie.setMaxAge(60 * 60 * 24 * 30);//30 days
                response.addCookie(usernameCookie);
            } else {
                //delete the cookie if it exists
                for (Cookie cookie : request.getCookies()) {
                    if (cookie.getName().equals("Username")) {
                        cookie.setMaxAge(-1);
                        response.addCookie(cookie);
                        break;
                    }
                }
            }
            Cookie promoCookie = new Cookie("Promo", "$100");
            promoCookie.setMaxAge(60 * 60 * 24 * 30);//30 days
            response.addCookie(promoCookie);


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
        String savedName = null;
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("Username")) {
                savedName = cookie.getValue();
                break;
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("<html><head><title>WONDERLAND BY JOHN LAWAL</title>");
        result.append("<link href='https://johnlawal.github.io/WAP/hw3/style.css' rel='stylesheet'/> </head><body>");
        result.append("<h1>Welcome</h1><form method='post' action='login'>");
        result.append("<fieldset><legend>Kindly provide your login details</legend>");
        if (savedName != null) {
            result.append("<div><input type='text' name='username' value='" + savedName + "' required /></div>");
        } else {
            result.append("<div><input type='text' name='username' placeholder='Enter your Username' required /></div>");
        }
        result.append("<div><input type='password' name='password' placeholder='Enter your Password' required /></div>");
        if (savedName != null) {
            result.append("<div><label><input name='remember' type='checkbox' checked /> <span>Remember Me</span></label></div>");
        } else {
            result.append("<div><label><input name='remember' type='checkbox' /> <span>Remember Me</span></label></div>");
        }

        result.append("<div><input type='submit' value='Login'/></div></fieldset></form></body></html>");

        PrintWriter out = response.getWriter();
        out.print(result);
    }
}
