package controllers.servlets;

import controllers.Utility.AppStrings;
import models.Order;
import dataaccesslayer.Productbase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "WelcomeServlet", urlPatterns = {"/welcome"})
public class WelcomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Welcome Servlet");

        HttpSession session = request.getSession();
        boolean isLoggedIn = (session.getAttribute(AppStrings.USERNAME.asStr()) != null);
        boolean hasPickedCart = (session.getAttribute(AppStrings.CART.asStr()) != null);

       //set cart
        if (hasPickedCart) {
            request.setAttribute(AppStrings.CART.asStr(), session.getAttribute(AppStrings.CART.asStr()));
        } else {
            ArrayList<Order> cart = new ArrayList<>();
            request.getSession().setAttribute(AppStrings.CART.asStr(), cart);
            request.setAttribute(AppStrings.CART.asStr(), cart);
        }
        String username = "";
        if(isLoggedIn){
            username = session.getAttribute(AppStrings.USERNAME.asStr()).toString();
        }

        String pageScript = "<script src='./views/assets/js/sign_in.js'></script>";

        //set request attributes
        request.setAttribute("pageTitle", "Welcome");
        request.setAttribute("pageStyle", "");
        request.setAttribute("isloggedIn", isLoggedIn);
        request.setAttribute("products", Productbase.getDb());
        request.setAttribute("username", username);
        request.setAttribute("pageScript", pageScript);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
