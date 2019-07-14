package controllers.servlets;


import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.Utility.AppStrings;

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

@WebServlet(name = "ClearCartServlet", urlPatterns = {"/clearCart"})
public class ClearCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Clear Cart Servlet");

        HttpSession session = request.getSession();
        boolean hasPickedCart = (session.getAttribute(AppStrings.CART.asStr()) != null);

        Map<String, Object> result = new HashMap<>();

        //remove from cart
        if (hasPickedCart) {
            session.removeAttribute(AppStrings.CART.asStr());
            result.put("status", AppStrings.SUCCESS.asStr());
        } else {
            result.put("status", AppStrings.FAILURE.asStr());
            result.put("message", "No item was found in your cart");
        }

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);

        response.getWriter().print(jsonString);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
