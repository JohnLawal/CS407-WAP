package controllers.servlets;


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
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.Utility.AppStrings;

@WebServlet(name = "CartServlet", urlPatterns = {"/getCart"})
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Cart Servlet");

        HttpSession session = request.getSession();
        boolean hasPickedCart = (session.getAttribute("cart") != null);

        Map<String, Object> result = new HashMap<>();

        //set cart
        if (hasPickedCart) {
            result.put("status", AppStrings.SUCCESS.asStr());
            result.put("cart", session.getAttribute("cart"));
            //serialize and send
        } else {
            result.put("status", AppStrings.SUCCESS.asStr());
            result.put("cart", new ArrayList<>());
        }

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);

        response.getWriter().print(jsonString);

    }
}
