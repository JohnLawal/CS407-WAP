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

@WebServlet(name = "RemoveFromCartServlet", urlPatterns = {"/removeFromCart"})
public class RemoveFromCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Remove From Cart Servlet");

        int product_id = Integer.parseInt(request.getParameter(AppStrings.PRODUCT_ID.asStr()));

        HttpSession session = request.getSession();
        boolean hasPickedCart = (session.getAttribute(AppStrings.CART.asStr()) != null);

        Map<String, Object> result = new HashMap<>();

        //remove from cart
        if (hasPickedCart) {
            ArrayList<Map<String, Object>> current_cart = (ArrayList<Map<String, Object>>) session.getAttribute(AppStrings.CART.asStr());
            ArrayList<Map<String, Object>> newCart = new ArrayList<>();
            for (Map<String, Object> cartItem : current_cart) {
                int prod_id = Integer.parseInt(cartItem.get(AppStrings.PRODUCT_ID.asStr()).toString());
                if (prod_id == product_id) {
                   continue;
                }
                newCart.add(cartItem);
            }
            session.setAttribute(AppStrings.CART.asStr(), newCart);
            result.put("status", AppStrings.SUCCESS.asStr());
        } else {
            result.put("status", AppStrings.FAILURE.asStr());
            result.put("message", "This item was not found in your cart");
        }

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);

        response.getWriter().print(jsonString);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
