package ua.kpi.ipt.kszi.lab10.dao.factory;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import ua.kpi.ipt.kszi.lab10.dao.ObjectDao;
import ua.kpi.ipt.kszi.lab10.dao.SubjectDao;
import ua.kpi.ipt.kszi.lab10.dao.impl.ObjectDaoImpl;
import ua.kpi.ipt.kszi.lab10.dao.impl.SubjectDaoImpl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Roman Horilyi
 */
public class MySqlDaoFactory implements DaoFactory {

    private static MySqlDaoFactory instance = null;

    private static final String HOST = "jdbc:mysql://localhost:3306/kszi?useUnicode=true&characterEncoding=utf8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Romani4_HoRilyi-007";

    private static Connection connection;

    private MySqlDaoFactory() {
    }

    public static MySqlDaoFactory getInstance() {
        if (instance == null) {
            instance = new MySqlDaoFactory();
        }
        return instance;
    }

    public static void makeConnection() {
        System.out.println("\nConnecting with the DB...");
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Connection with the DB has been set.");
            }
        } catch (SQLException e) {
            System.out.println("Error! Can't download a class of driver!");
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                if (connection.isClosed()) {
                    System.out.println("Connection with the DB has been closed.");
                }

            } catch (SQLException sqle) {
                System.out.println("Error! Can't download a class of driver!");
                sqle.printStackTrace();
            }
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return connection;
    }

    @Override
    public ObjectDao getObjectDao() {
        return new ObjectDaoImpl(connection);
    }

    @Override
    public SubjectDao getSubjectDao() {
        return new SubjectDaoImpl(connection);
    }
}
