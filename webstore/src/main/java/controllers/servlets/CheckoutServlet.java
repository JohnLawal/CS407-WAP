package controllers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.Utility.AppStrings;
import dataaccesslayer.Productbase;
import dataaccesslayer.Userbase;
import models.Order;
import models.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CheckoutServlet", urlPatterns = {"/checkout"})
public class CheckoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Checkout Servlet Post");

        HttpSession session = request.getSession();
        boolean isLoggedIn = (session.getAttribute(AppStrings.USERNAME.asStr()) != null);
        boolean hasPickedCart = (session.getAttribute(AppStrings.CART.asStr()) != null);
        Map<String, Object> result = new HashMap<>();

        if (isLoggedIn) {
            if (hasPickedCart) {
                String address = request.getParameter(AppStrings.ADDRESS.asStr()).trim();
                String location = request.getParameter(AppStrings.LOCATION.asStr()).trim();
                String payment_method = request.getParameter(AppStrings.PAYMENT_METHOD.asStr()).trim();
                //those guys can be used later

                ArrayList<Map<String, Object>> current_cart = (ArrayList<Map<String, Object>>) session.getAttribute(AppStrings.CART.asStr());


                double total_amount = current_cart.
                        stream().map(item -> Double.parseDouble(item.get("selling_price").toString()) * Double.parseDouble(item.get("quantity").toString())).reduce(Double::sum).get();
                result.put("status", AppStrings.SUCCESS.asStr());
                result.put("purchases", current_cart);
                result.put("amount", total_amount);
                result.put("delivery_fee", this.getServletContext().getInitParameter("delivery-fee"));
                result.put("message", "Your order has been created.");

                session.removeAttribute(AppStrings.CART.asStr());
            } else {
                result.put("status", AppStrings.FAILURE.asStr());
                result.put("message", "You have not selected any item to purchase.");
            }
        } else {
            result.put("status", AppStrings.FAILURE.asStr());
            result.put("message", "You have to be logged in to checkout.");
        }

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);

        response.getWriter().print(jsonString);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Checkout Servlet");

        HttpSession session = request.getSession();
        boolean isLoggedIn = (session.getAttribute(AppStrings.USERNAME.asStr()) != null);
        boolean hasPickedCart = (session.getAttribute(AppStrings.CART.asStr()) != null);

        if (hasPickedCart) {
            //for view
            request.setAttribute(AppStrings.CART.asStr(), session.getAttribute(AppStrings.CART.asStr()));
        } else {

        }

        String pageScript = "";
        if (isLoggedIn) {
            String username = session.getAttribute(AppStrings.USERNAME.asStr()).toString().trim();
            request.setAttribute("user", Userbase.getUser(username));

        } else {
            pageScript = "<script src='./views/assets/js/sign_in.js'></script>";
            request.setAttribute("user", null);

        }

        pageScript += "<script src='./views/assets/js/checkout.js'></script>";

        //set request attributes
        request.setAttribute("pageTitle", "Checkout");
        request.setAttribute("pageStyle", "");
        request.setAttribute("isloggedIn", isLoggedIn);
//        request.setAttribute("product", requestedProduct);
        request.setAttribute("locations", AppStrings.getLocations());
        request.setAttribute("pageScript", pageScript);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/pages/checkout.jsp");
        dispatcher.forward(request, response);
    }
}
