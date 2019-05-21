package by.it.khlystunova.jd03_03.crud;

import by.it.khlystunova.jd03_03.CN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {

    private ConnectionCreator() {
    }

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            // handle the error
        }
    }


    public static Connection get() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (ConnectionCreator.class) {
                if (connection == null || connection.isClosed()) {
                    connection= DriverManager.getConnection(CN.URL_FOR_CRUD, CN.USER, CN.PASSWORD);
                }
            }
        }
        return connection;
    }
}
