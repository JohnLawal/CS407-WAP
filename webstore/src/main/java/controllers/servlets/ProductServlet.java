package controllers.servlets;

import controllers.Utility.AppStrings;
import dataaccesslayer.Productbase;
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

public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean isLoggedIn =  (Boolean) request.getAttribute(AppStrings.IS_LOGGED_IN.asStr());
        boolean hasPickedCart = (session.getAttribute(AppStrings.CART.asStr()) != null);

        String productId = request.getParameter(AppStrings.PRODUCT.asStr());
        Product requestedProduct = Productbase.getProduct(Integer.parseInt(productId));
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
        request.setAttribute("pageTitle", "View Product -" + requestedProduct.getName());
        request.setAttribute("pageStyle", "");
        request.setAttribute("product", requestedProduct);
        request.setAttribute("advertisedproducts", Productbase.getAdverts());
        request.setAttribute("username", username);
        request.setAttribute("pageScript", pageScript);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/pages/viewproduct.jsp");
        dispatcher.forward(request, response);
    }
}
