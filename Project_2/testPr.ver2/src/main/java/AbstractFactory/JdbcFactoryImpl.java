package AbstractFactory;

import dao.UserDao;
import dao.UserDaoJdbcImpl;
import service.UserService;
import service.UserServiceJdbcImpl;
import util.ConnectionI;
import util.ConnectionJdbc;

import java.io.IOException;
import java.sql.SQLException;

public class JdbcFactoryImpl implements AbstractFactory{
    @Override
    public ConnectionJdbc getConnect() throws SQLException, IOException, ClassNotFoundException {
        return new ConnectionJdbc();
    }

    @Override
    public UserDaoJdbcImpl getUserDao() throws SQLException, IOException, ClassNotFoundException {
        return new UserDaoJdbcImpl(getConnect());
    }

    @Override
    public UserServiceJdbcImpl getDbService() throws SQLException, IOException, ClassNotFoundException {
        return new UserServiceJdbcImpl(getUserDao());
    }
}
