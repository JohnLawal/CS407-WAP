package controllers.servlets;

import controllers.Utility.AppStrings;
import dataaccesslayer.Productbase;
import models.Order;
import models.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean isLoggedIn =  (Boolean) request.getAttribute(AppStrings.IS_LOGGED_IN.asStr());
        boolean hasPickedCart = (session.getAttribute(AppStrings.CART.asStr()) != null);

        String searchQuery = request.getParameter(AppStrings.PRODUCT.asStr()).trim();
        List<Product> requestedProducts = Productbase.searchProducts(searchQuery);
        //set cart
        if (hasPickedCart) {
            //for view
            request.setAttribute(AppStrings.CART.asStr(), session.getAttribute(AppStrings.CART.asStr()));
        } else {
            ArrayList<Order> cart = new ArrayList<>();
            request.getSession().setAttribute(AppStrings.CART.asStr(), cart);
            request.setAttribute(AppStrings.CART.asStr(), cart);
        }
        String username = "";
        String pageScript= "";
        if(isLoggedIn){
            username = session.getAttribute(AppStrings.USERNAME.asStr()).toString();
        }else{
            pageScript = "<script src='./views/assets/js/sign_in.js'></script>";
        }


        //set request attributes
        request.setAttribute("pageTitle", "Search For Products");
        request.setAttribute("pageStyle", "");
        request.setAttribute("products", requestedProducts);
        request.setAttribute("advertisedproducts", Productbase.getAdverts());
        request.setAttribute("username", username);
        request.setAttribute("pageScript", pageScript);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/pages/search.jsp");
        dispatcher.forward(request, response);
    }
}
