package controllers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.Utility.AppStrings;
import dataaccesslayer.Userbase;
import models.User;


import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter(AppStrings.USERNAME.asStr());
        String password = request.getParameter(AppStrings.PASSWORD.asStr());

        Map<String, Object> result = new HashMap<>();


        if (Userbase.userExists(new User(username, password))) {
                       //if remember me is checked
            if (request.getParameter(AppStrings.REMEMBER.asStr()) != null) {
                Cookie usernameCookie = new Cookie(AppStrings.USERNAME.asStr(), username);
                usernameCookie.setMaxAge(60 * 60 * 24 * 30);//30 days
                response.addCookie(usernameCookie);
            } else {
                //delete the cookie if it exists
                for (Cookie cookie : request.getCookies()) {
                    if (cookie.getName().equals(AppStrings.USERNAME.asStr())) {
                        cookie.setMaxAge(-1);
                        response.addCookie(cookie);
                        break;
                    }
                }
            }
            Cookie promoCookie = new Cookie(AppStrings.PROMO.asStr(), "$100");
            promoCookie.setMaxAge(60 * 60 * 24 * 30);//30 days
            response.addCookie(promoCookie);

            HttpSession session = request.getSession();
            session.setAttribute(AppStrings.USERNAME.asStr(), username);
//            session.setMaxInactiveInterval(3600);

            result.put(AppStrings.STATUS.asStr(), AppStrings.SUCCESS.asStr());
            result.put(AppStrings.MESSAGE.asStr(), AppStrings.returnAlert("success","Access Granted. ","You have been logged in."));
        } else {
            result.put(AppStrings.STATUS.asStr(), AppStrings.FAILURE.asStr());
            result.put(AppStrings.MESSAGE.asStr(), AppStrings.returnAlert("warning","Access Denied. ","You have provided invalid login details. Please try again."));
        }

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);

        response.getWriter().print(jsonString);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
