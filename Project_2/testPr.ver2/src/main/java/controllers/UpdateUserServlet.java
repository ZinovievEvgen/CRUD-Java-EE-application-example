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

@WebServlet(
        name = "UpdateUserServlet",
        urlPatterns = {"/update"}
)
public class UpdateUserServlet extends HttpServlet {
    AbstractFactory factory = new JdbcFactoryImpl();
    //******************HIBE*****************************
    //AbstractFactory factory = new HibeFactoryImpl();

    public UpdateUserServlet() throws SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Integer.parseInt(request.getParameter("id"));
        User user = null;
        try {
            user = factory.getDbService().getUserById(id);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Exception");
            e.printStackTrace();
        }
        request.setAttribute("userById", user);
        request.getRequestDispatcher("/updateUser.jsp").forward(request, response);
    }
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Integer.parseInt(request.getParameter("id"));
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String role = request.getParameter("role");
       try {
           factory.getDbService().updateUser(id,login,password,name,role);
       } catch (SQLException | ClassNotFoundException e) {
           System.err.println("Exception");
           e.printStackTrace();
       }
       response.sendRedirect("/admin/userList");
   }
}