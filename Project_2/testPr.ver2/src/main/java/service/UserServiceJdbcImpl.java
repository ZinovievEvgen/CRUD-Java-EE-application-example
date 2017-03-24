package service;

import AbstractFactory.AbstractFactory;
import AbstractFactory.JdbcFactoryImpl;
import dao.UserDaoJdbcImpl;
import model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class UserServiceJdbcImpl implements UserService {
    private final UserDaoJdbcImpl dao;
    private static Logger logg = Logger.getLogger(UserServiceJdbcImpl.class.getName());

    public UserServiceJdbcImpl(UserDaoJdbcImpl daoJdbc) throws SQLException {
        this.dao = daoJdbc;
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
    public User getUserByLogPas(String login, String password) throws SQLException, IOException, ClassNotFoundException {
        User user = dao.getUserByLogPas(login, password);
        return user;
    }

    @Override
    public List<User> getUserList() throws SQLException, IOException, ClassNotFoundException {
        List<User> usersList = dao.getUserList();
        return usersList;
    }
}
/*
import AbstractFactory.AbstractFactory;
import AbstractFactory.JdbcFactoryImpl;
public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        AbstractFactory factory = new JdbcFactoryImpl();
        List<User> Listt = factory.getUserDao().getUserList();
        for (User p: Listt) {
            System.out.println(p);
        }
        System.out.println(factory.getDbService().getUserByLogPas("Sergo1","1"));
                }
 */