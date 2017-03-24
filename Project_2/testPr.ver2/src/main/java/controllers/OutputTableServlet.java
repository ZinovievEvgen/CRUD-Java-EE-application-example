package controllers;

import AbstractFactory.AbstractFactory;
import AbstractFactory.JdbcFactoryImpl;
import model.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(
        name = "OutputTableServlet",
        urlPatterns = {"/admin/userList"}
)
public class OutputTableServlet extends HttpServlet{
    AbstractFactory factory = new JdbcFactoryImpl();
    //******************HIBE******************************
   //AbstractFactory factory = new HibeFactoryImpl();

    public OutputTableServlet() throws SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> ListN = null;
        try {
            ListN = factory.getDbService().getUserList();
        } catch (ClassNotFoundException | SQLException b) {
            System.err.println("Exception");
            b.printStackTrace();
        }
        request.setAttribute("list", ListN);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
