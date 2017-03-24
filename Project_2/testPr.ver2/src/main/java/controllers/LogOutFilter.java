package controllers;


import AbstractFactory.AbstractFactory;
import AbstractFactory.AbstractFactory;
import AbstractFactory.JdbcFactoryImpl;
import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

@WebFilter(urlPatterns = "/action")
public class LogOutFilter implements Filter {

    private ServletContext context;
    private static Logger logg = Logger.getLogger(LogOutFilter.class.getName());
    AbstractFactory factory = new JdbcFactoryImpl();
    //******************HIBE******************************
    //AbstractFactory factory = new HibeFactoryImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
        this.context.log("RequestLoggingFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String login = servletRequest.getParameter("login");
        String password = servletRequest.getParameter("password");
        User user = null;
        HttpSession session = req.getSession();
        try {
            user = factory.getDbService().getUserByLogPas(login, password);
        } catch (SQLException | ClassNotFoundException | NullPointerException e) {
            e.printStackTrace();
        }
        if (user != null) {
            if (!login.equals(user.getLogin()) || !password.equals(user.getName())) {
                session.setAttribute("user", user);
                res.sendRedirect("/admin");
            }
        }
        else {
            logg.info("User not found");
            String error = "User not Found. Please write correct username or password another complit registration on system";
            req.setAttribute("err", error);
            req.getRequestDispatcher("/login.jsp").forward(req,res);
        }
    }

    @Override
    public void destroy() {
        //destroy
    }
}
