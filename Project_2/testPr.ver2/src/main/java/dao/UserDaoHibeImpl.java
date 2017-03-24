package dao;


import model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.ConnectionHibe;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class UserDaoHibeImpl implements UserDao{
    private ConnectionHibe connectionHibe;

    public UserDaoHibeImpl(ConnectionHibe connectionHibe) {
        this.connectionHibe = connectionHibe;
    }


    @Override
    public void addUser(String login, String password, String name, String role) throws SQLException, IOException,
            ClassNotFoundException {
        Session session = connectionHibe.getSession();
        session.beginTransaction();
        session.save(new User(login, password,name,role));
        session.getTransaction().commit();
        session.close();
        System.out.println("куку епта");
    }

    @Override
    public void updateUser(long id, String login, String password, String name, String role) throws SQLException, IOException,
            ClassNotFoundException {
        Session session = connectionHibe.getSession();
        session.beginTransaction();
        User user = (User) session.get(User.class, id);
        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        user.setRole(role);
        session.getTransaction().commit();
    }

    @Override
    public void deleteUser(long id) throws SQLException, IOException, ClassNotFoundException {
        Session session = connectionHibe.getSession();
        Transaction trantran = session.beginTransaction();
        User usa = getUserById(id);
        if (usa == null) {
            System.out.println("User not found!");
        }
        session.delete(usa);
        trantran.commit();
        session.close();
    }

    @Override
    public User getUserById(long id) throws SQLException, IOException, ClassNotFoundException {
        Session session = connectionHibe.getSession();
        User user = (User) session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public User getUserByLogPas(String login, String password) throws SQLException, IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<User> getUserList() throws SQLException, IOException, ClassNotFoundException {
        Session session = connectionHibe.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        List usersHib = null;
        usersHib = (List<User>) criteria.list();
        session.getTransaction().commit();
        session.close();
        return usersHib;
    }
}