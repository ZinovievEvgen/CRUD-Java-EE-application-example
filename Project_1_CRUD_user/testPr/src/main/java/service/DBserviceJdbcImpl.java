package service;

import dao.UserDaoJdbcImpl;
import model.User;
import util.ConnectionJdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class DBserviceJdbcImpl implements DbService {
    private final UserDaoJdbcImpl dao;
    private static Logger logg = Logger.getLogger(DBserviceJdbcImpl.class.getName());

    public DBserviceJdbcImpl(ConnectionJdbc connection) throws SQLException {
        dao = new UserDaoJdbcImpl(connection);
    }


    @Override
    public void addUser(String login, String password, String name, String role) throws SQLException, IOException,
            ClassNotFoundException {
        dao.addUser(login, password, name, role);
        logg.info("User was added!");
    }

    @Override
    public void updateUser(long id, String login, String password, String name, String role) throws SQLException, IOException,
            ClassNotFoundException {
        dao.updateUser(id, login, password, name, role);
        logg.info("User by id = " + id + " was update!");
    }

    @Override
    public void deleteUser(long id) throws SQLException, IOException, ClassNotFoundException {
        dao.deleteUser(id);
    }

    @Override
    public User getUserById(long id) throws SQLException, IOException, ClassNotFoundException {
        User user = dao.getUserById(id);
        return user;
    }

    @Override
    public List<User> getUserList() throws SQLException, IOException, ClassNotFoundException {
        List<User> usersList = dao.getUserList();
        return usersList;
    }
}