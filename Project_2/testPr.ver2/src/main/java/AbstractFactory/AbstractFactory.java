package AbstractFactory;

import dao.UserDao;
import service.UserService;
import util.ConnectionI;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface AbstractFactory {
        public ConnectionI getConnect() throws SQLException, IOException, ClassNotFoundException;
        public UserDao getUserDao() throws SQLException, IOException, ClassNotFoundException;
        public UserService getDbService() throws SQLException, IOException, ClassNotFoundException;
}
