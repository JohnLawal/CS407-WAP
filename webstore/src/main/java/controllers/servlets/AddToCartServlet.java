package controllers.servlets;


import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.Utility.AppStrings;
import dataaccesslayer.Productbase;
import models.Order;
import models.Product;

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
import java.util.UUID;

@WebServlet(name = "AddToCartServlet", urlPatterns = {"/addToCart"})
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Add To Cart Servlet");

        int product_id = Integer.parseInt(request.getParameter(AppStrings.PRODUCT_ID.asStr()));
        int quantity = Integer.parseInt(request.getParameter(AppStrings.QUANTITY.asStr()));

        Product requestedProduct = Productbase.getProduct(product_id);

        HttpSession session = request.getSession();
        boolean hasPickedCart = (session.getAttribute(AppStrings.CART.asStr()) != null);

        Map<String, Object> result = new HashMap<>();

        Map<String, Object> item = new HashMap<>();
        item.put("product_id", product_id);
        item.put("product_name", requestedProduct.getName());
        item.put("selling_price", requestedProduct.getPrice());
        item.put("quantity", quantity);
        //add cart
        if (hasPickedCart) {
            ArrayList<Map<String, Object>> current_cart = (ArrayList<Map<String, Object>>) session.getAttribute(AppStrings.CART.asStr());
            ArrayList<Map<String, Object>> newCart = new ArrayList<>();
            boolean is_update = false;
            for (Map<String, Object> cartItem : current_cart) {
                int prod_id = Integer.parseInt(cartItem.get(AppStrings.PRODUCT_ID.asStr()).toString());
                if (prod_id == product_id) {
                    int former_quantity = Integer.parseInt(cartItem.get(AppStrings.QUANTITY.asStr()).toString());
                    int new_quantity = former_quantity + quantity;
                    cartItem.put("quantity", new_quantity);
                    is_update = true;
                }
                newCart.add(cartItem);
            }
            if (is_update) {
                session.setAttribute(AppStrings.CART.asStr(), newCart);
            } else {
                current_cart.add(item);
                session.setAttribute(AppStrings.CART.asStr(), current_cart);
            }


            result.put("status", AppStrings.SUCCESS.asStr());
        } else {
            ArrayList<Map<String, Object>> cart = new ArrayList<>();
            cart.add(item);
            session.setAttribute(AppStrings.CART.asStr(), cart);

            result.put("status", AppStrings.SUCCESS.asStr());
        }

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);

        response.getWriter().print(jsonString);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
