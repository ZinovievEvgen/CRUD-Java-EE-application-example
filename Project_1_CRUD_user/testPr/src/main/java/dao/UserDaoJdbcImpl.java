package dao;


import dao.executor.Executor;
import model.User;
import util.ConnectionJdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao{
    private Executor executor;
    public UserDaoJdbcImpl(ConnectionJdbc connection) throws SQLException {
        this.executor = new Executor(connection);
    }

    public void addUser(String login, String password, String name, String role) throws SQLException,
            IOException, ClassNotFoundException {
       executor.execUpdate("INSERT INTO `testgerman1`.`users` (`login`, `password`, `name`, `role`) " +
          "VALUES ('" + login +"', '" + password +"', '" + name + "', '" + role +"')");
    }

    public void updateUser(long id, String login, String password, String name, String role) throws SQLException,
            IOException, ClassNotFoundException {
        executor.execUpdate("UPDATE `testgerman1`.`users` SET `login`='" + login + "'," +
                "`password`='" + password + "', `name`='" + name + "', `role`='" + role + "' WHERE `id`='" + id + "'");
    }

    public void deleteUser(long id) throws SQLException, IOException, ClassNotFoundException {
        executor.execUpdate("DELETE FROM testgerman1.users where id = '" + id + "'");
    }

    public User getUserById(long id) throws SQLException, IOException, ClassNotFoundException {
        return executor.execQuery("select * from users where id='" + id + "'", result -> {
            result.next();
            return new User(result.getInt(1), result.getString(2), result.getString(3),result.getString(4),
                    result.getString(5));
        });
    }

    public List<User> getUserList() throws SQLException, IOException, ClassNotFoundException {
        List<User> UserList = new ArrayList<>();
        return executor.execQuery("select * from users",result ->{
            while(result.next()){
                UserList.add(new User(result.getInt(1), result.getString(2), result.getString(3),
                        result.getString(4), result.getString(5)));
            }
            return UserList;
        });
    }
}
