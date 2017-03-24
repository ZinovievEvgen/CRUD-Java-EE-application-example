package controllers;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/admin/*")
public class RoleAccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        String path = req.getRequestURI().substring(req.getContextPath().length());
        User usa = (User)session.getAttribute("user");
        if ((usa.getRole()).equals("admin")){
            req.getRequestDispatcher("/admin/userList").forward(req, res);
        }
        else if ((usa.getRole()).equals("user") && path.equals("/admin/userList")){
            req.getRequestDispatcher("/error.jsp").forward(req, res);
        }
        else {
            res.sendRedirect("/userIn.jsp");
        }


    }

    @Override
    public void destroy() {

    }
}
