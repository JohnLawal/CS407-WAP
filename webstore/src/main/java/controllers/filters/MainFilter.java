package controllers.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.Utility.AppStrings;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter(filterName = "MainFilter", urlPatterns = {"/*"})
public class MainFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();
        boolean isLoggedIn = (session.getAttribute(AppStrings.USERNAME.asStr()) != null);
        boolean hasPickedCart = (session.getAttribute(AppStrings.CART.asStr()) != null);

        String servletPath = request.getServletPath();
        switch (servletPath) {
            case "/index.jsp": //landing page
                if (request.getAttribute("pageTitle") != null) {
                    chain.doFilter(request, response);
                } else {
                    response.sendRedirect("welcome");
                }
                break;
            case "/search":
                request.setAttribute(AppStrings.IS_LOGGED_IN.asStr(), isLoggedIn);
                if (request.getParameter(AppStrings.PRODUCT.asStr()) != null) {
                    chain.doFilter(request, response);
                } else {
                    response.sendRedirect("welcome");
                }
                break;
            case "/welcome":
            case "/viewProduct":
            case "/checkout":
                request.setAttribute(AppStrings.IS_LOGGED_IN.asStr(), isLoggedIn);
                chain.doFilter(request, response);
                break;
            case "/getCart":
            case "/login":
            case "/logout":
            case "/addToCart":
                chain.doFilter(request, response);
                break;
            case "/updateItemInCart":
            case "/removeFromCart":
                if (!hasPickedCart) {
                    Map<String, Object> result = new HashMap<>();
                    result.put("status", AppStrings.FAILURE.asStr());
                    result.put("message", "This item was not found in your cart");
                    ObjectMapper mapper = new ObjectMapper();
                    String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
                    response.getWriter().print(jsonString);
                } else {
                    chain.doFilter(request, response);
                }
                break;
            default:
                chain.doFilter(req, resp);
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
