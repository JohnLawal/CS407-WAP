package controllers.servlets;

import models.Order;
import models.Product;
import models.Productbase;
import models.User;

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
        HttpSession session = request.getSession();
        boolean isLoggedIn = (session.getAttribute("username") != null);
        boolean hasPickedCart = (session.getAttribute("cart") != null);

       //set cart
        if (hasPickedCart) {
            request.setAttribute("cart", session.getAttribute("cart"));
        } else {
            ArrayList<Order> cart = new ArrayList<>();
            request.getSession().setAttribute("cart", cart);
            request.setAttribute("cart", cart);
        }
        String username = "";
        if(isLoggedIn){
            username = session.getAttribute("username").toString();
        }


        //set request attributes
        request.setAttribute("pageTitle", "Welcome");
        request.setAttribute("pageStyle", "");
        request.setAttribute("isloggedIn", isLoggedIn);
        request.setAttribute("products", Productbase.getDb());
        request.setAttribute("username", username);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
