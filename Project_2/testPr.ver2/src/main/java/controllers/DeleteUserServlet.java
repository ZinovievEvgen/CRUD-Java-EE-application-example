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
        name = "DeleteUserServlet",
        urlPatterns = {"/delete"}
)
public class DeleteUserServlet extends HttpServlet {
    AbstractFactory factory = new JdbcFactoryImpl();
    //******************HIBE*****************************
    //AbstractFactory factory = new HibeFactoryImpl();

    public DeleteUserServlet() throws SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            factory.getDbService().deleteUser(id);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Exception");
            e.printStackTrace();
        }
        resp.sendRedirect("/admin/userList");
    }
}
