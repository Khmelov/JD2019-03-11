package by.it.narushevich.jd03_02;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {

    static final String URL = "jdbc:mysql://127.0.0.1:2016/narushevich?" +
            "useUnicode=true&" +
            "characterEncoding=UTF-8&"+
            "useJDBCCompliantTimezoneShift=true&" +
            "useLegacyDatetimeCode=false&" +
            "serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static volatile Connection connection = null;

    public static Connection get() throws SQLException {
        if (connection == null || connection.isClosed()) {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            synchronized (URL) {
                if (connection == null || connection.isClosed()) {
                    connection= DriverManager.getConnection(URL,USER,PASSWORD);
                }
            }
        }
        return connection;
    }
}
