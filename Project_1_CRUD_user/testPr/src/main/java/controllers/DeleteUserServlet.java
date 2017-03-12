package controllers;

import dao.UserDaoHibeImpl;
import service.DBserviceHibeImpl;
import service.DBserviceJdbcImpl;
import service.DbService;
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
        name = "DeleteUserServlet",
        urlPatterns = {"/delete"}
)
public class DeleteUserServlet extends HttpServlet {
    //ConnectionJdbc conn = new ConnectionJdbc();
    //DBserviceJdbcImpl db = new DBserviceJdbcImpl(conn);
    //******************HIBE******************************
    ConnectionHibe cona = new ConnectionHibe();
    UserDaoHibeImpl daoHibe = new UserDaoHibeImpl(cona);
    DBserviceHibeImpl dh = new DBserviceHibeImpl(daoHibe);

    public DeleteUserServlet() throws SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            //db.deleteUser(id);
            dh.deleteUser(id);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Exception");
            e.printStackTrace();
        }
        resp.sendRedirect("/index");
    }
}
