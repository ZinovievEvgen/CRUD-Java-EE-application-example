package service;


import dao.UserDaoHibeImpl;
import model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class DBserviceHibeImpl implements DbService{
    private final UserDaoHibeImpl daoHibe;
    private static Logger logg = Logger.getLogger(DBserviceJdbcImpl.class.getName());

    public DBserviceHibeImpl(UserDaoHibeImpl daoHibe) {
        this.daoHibe = daoHibe;
    }

    @Override
    public void addUser(String login, String password, String name, String role) throws SQLException, IOException, ClassNotFoundException {
            daoHibe.addUser(login,password,name,role);
            logg.info("User was added!");
    }

    @Override
    public void updateUser(long id, String login, String password, String name, String role) throws SQLException, IOException,
            ClassNotFoundException {
        daoHibe.updateUser(id,login,password,name,role);
        logg.info("User was updated!");
    }

    @Override
    public void deleteUser(long id) throws SQLException, IOException, ClassNotFoundException {
        daoHibe.deleteUser(id);
        logg.info("User was deleted!");
    }

    @Override
    public User getUserById(long id) throws SQLException, IOException, ClassNotFoundException {
        User user = daoHibe.getUserById(id);
        return user;
    }

    @Override
    public List<User> getUserList() throws SQLException, IOException, ClassNotFoundException {
        List newListUser = daoHibe.getUserList();
        return newListUser;
    }
}