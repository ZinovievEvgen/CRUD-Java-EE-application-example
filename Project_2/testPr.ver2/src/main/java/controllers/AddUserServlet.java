package controllers;

import AbstractFactory.AbstractFactory;
import AbstractFactory.JdbcFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(
        name = "AddUserServlet",
        urlPatterns = {"/add"}
)
public class  AddUserServlet extends HttpServlet {
    AbstractFactory factory = new JdbcFactoryImpl();
    //******************HIBE*****************************
    //AbstractFactory factory = new HibeFactoryImpl();

    public AddUserServlet() throws SQLException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        try {
            factory.getDbService().addUser(login, password, name, role);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Exception");
            e.printStackTrace();
        }
        response.sendRedirect("/admin/userList");
    }
}
