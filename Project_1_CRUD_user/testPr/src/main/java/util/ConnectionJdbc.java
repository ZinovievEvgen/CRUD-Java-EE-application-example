package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class ConnectionJdbc {
    private Properties propertiesJdbc;
    private static final String path = "C:\\User\\ODA\\IdeaProjects\\testPr\\src\\main\\resources\\jdbc_connection.properties";
    private static Logger logg = Logger.getLogger(Connection.class.getName());
    private static Connection connection;

    public synchronized Connection getConnection() throws IOException, SQLException, ClassNotFoundException {
        if (connection == null) {
            getPropertiesJdbc();
            Class.forName(propertiesJdbc.getProperty("driver"));
            connection = DriverManager.getConnection(propertiesJdbc.getProperty("url"),propertiesJdbc);
            logg.info("Connection successfully!");
        }
        return connection;
    }
    public Properties getPropertiesJdbc() throws IOException{
        propertiesJdbc = new Properties();
        FileInputStream fis = new FileInputStream(path);
        propertiesJdbc.load(fis);
        String driver = propertiesJdbc.getProperty("driver");
        String login = propertiesJdbc.getProperty("user");
        String password = propertiesJdbc.getProperty("password");
        return propertiesJdbc;
    }
}
