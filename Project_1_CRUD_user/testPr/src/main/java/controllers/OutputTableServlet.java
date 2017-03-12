package controllers;

import dao.UserDaoHibeImpl;
import model.User;
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
import java.util.List;

@WebServlet(
        name = "OutputTableServlet",
        urlPatterns = {"/index"}
)
public class OutputTableServlet extends HttpServlet{
    //ConnectionJdbc conn = new ConnectionJdbc();
    //DBserviceJdbcImpl db = new DBserviceJdbcImpl(conn);
    //******************HIBE******************************
    ConnectionHibe cona = new ConnectionHibe();
    UserDaoHibeImpl daoHibe = new UserDaoHibeImpl(cona);
    DBserviceHibeImpl dh = new DBserviceHibeImpl(daoHibe);

    public OutputTableServlet() throws SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> ListN = null;
        try {
            //ListN = db.getUserList();
            ListN = dh.getUserList();
        } catch (ClassNotFoundException | SQLException b) {
            System.err.println("Exception");
            b.printStackTrace();
        }
        request.setAttribute("list", ListN);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
