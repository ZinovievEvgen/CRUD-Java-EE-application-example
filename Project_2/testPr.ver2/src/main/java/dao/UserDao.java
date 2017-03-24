package dao;

import model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserDao{

    public void addUser(String login, String password, String name, String role) throws SQLException,
            IOException, ClassNotFoundException;
    public void updateUser(long id, String login, String password, String name, String role) throws SQLException,
            IOException, ClassNotFoundException;
    public void deleteUser(long id) throws SQLException, IOException, ClassNotFoundException;
    public User getUserById(long id) throws SQLException, IOException, ClassNotFoundException;
    public User getUserByLogPas(String login, String password) throws SQLException, IOException, ClassNotFoundException;
    public List getUserList() throws SQLException, IOException, ClassNotFoundException;
}
