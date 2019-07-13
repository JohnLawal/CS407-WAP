package controllers.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "MainFilter", urlPatterns = {"/*"})
public class MainFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String servletPath = request.getServletPath();
        switch (servletPath) {
            case "/index.jsp": //landing page
                if (request.getAttribute("pageTitle") != null){
                    chain.doFilter(req, resp);
                }else{
                    response.sendRedirect("welcome");
                }
                break;
            case "/welcome":
            case "/getCart":
            case "/login":
            case "/logout":
                chain.doFilter(req, resp);
                break;
            default:
                System.out.println(request.getServletPath() + "-d"); // /index/jsp
//                System.out.println(request.getContextPath()); // /webstore
//                System.out.println(request.getRequestURI()); // /webstore/
                chain.doFilter(req, resp);

        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
