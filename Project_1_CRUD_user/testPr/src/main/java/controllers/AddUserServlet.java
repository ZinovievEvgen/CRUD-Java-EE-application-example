package controllers;

import dao.DBException;
import dao.UserDaoHibeImpl;
import service.DBserviceHibeImpl;
import service.DBserviceJdbcImpl;
import util.ConnectionHibe;
import util.ConnectionJdbc;

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
    //ConnectionJdbc conn = new ConnectionJdbc();
    //DBserviceJdbcImpl db = new DBserviceJdbcImpl(conn);
    //******************HIBE*****************************
    ConnectionHibe cona = new ConnectionHibe();
    UserDaoHibeImpl daoHibe = new UserDaoHibeImpl(cona);
    DBserviceHibeImpl dh = new DBserviceHibeImpl(daoHibe);

    public AddUserServlet() throws SQLException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        try {
            //db.addUser(login, password, name, role);
            dh.addUser(login,password,name,role);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Exception");
            e.printStackTrace();
        }
        response.sendRedirect("/index");
    }
}
