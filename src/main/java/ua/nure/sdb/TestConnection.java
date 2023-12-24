package ua.nure.sdb;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestConnection {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL)) {
            System.out.println("Ok.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
}
