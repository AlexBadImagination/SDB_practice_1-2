package ua.nure.sdb.dao.mysql;

import ua.nure.sdb.dao.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlDAOFactory extends DAOFactory {

    private UserDAO userDAO;
    private OrderDAO orderDAO;
    private DishDAO dishDAO;
    private OrderDishesDAO orderDishesDAO;
    private static MySqlDAOFactory mySqlDAOFactory = null;
    public static synchronized MySqlDAOFactory getMySqlDAOFactory() {
        if (mySqlDAOFactory == null) {
            mySqlDAOFactory = new MySqlDAOFactory();
        }
        return mySqlDAOFactory;
    }
    @Override
    public UserDAO getUserDAO() {
        if (userDAO == null) {
            userDAO = new MySqlUserDAO();
        }
        return userDAO;
    }

    @Override
    public OrderDAO getOrderDAO() {
        if (orderDAO == null) {
            orderDAO = new MySqlOrderDAO();
        }
        return orderDAO;
    }

    @Override
    public DishDAO getDishDAO() {
        if (dishDAO == null) {
            dishDAO = new MySqlDishDAO();
        }
        return dishDAO;
    }

    @Override
    public OrderDishesDAO getOrderDishesDAO() {
        if (orderDishesDAO == null) {
            orderDishesDAO = new MySQLOrderDishesDAO();
        }
        return orderDishesDAO;
    }


    public static String getURL() {
        FileInputStream fis;
        Properties property = new Properties();
        String host = null, login = null, password = null;
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);

            host = property.getProperty("db.host");
            login = property.getProperty("db.login");
            password = property.getProperty("db.password");

        } catch (IOException e) {
            System.err.println("ERROR: there is no properties file!");
        }
        return host + "?sslMode=DISABLED&serverTimzone=UTC&user=" + login + "&password=" + password;
    }
    static final String URL = getURL();

    static Connection getConnection() throws SQLException {
        return getConnection(true);
    }

    static Connection getConnection(boolean autoCommit) throws SQLException {
        Connection con = DriverManager.getConnection(URL);
        con.setAutoCommit(autoCommit);
        if (!autoCommit) {
            con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        }
        return con;
    }


    static void close(Connection con) throws SQLException {
        if (con != null) {
            con.close();
        }
    }

    static void rollback(Connection con) throws SQLException {
        if (con != null) {
            con.rollback();
        }
    }
}
