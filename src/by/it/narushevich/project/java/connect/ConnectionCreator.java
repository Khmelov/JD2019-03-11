package by.it.narushevich.project.java.connect;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {

    private static volatile Connection connection = null;

    public static Connection get() throws SQLException {
        if (connection == null || connection.isClosed()) {
            DriverManager.registerDriver(new FabricMySQLDriver());
            synchronized (SetupConnection.getURL()) {
                if (connection == null || connection.isClosed()) {
                    connection= DriverManager.getConnection(
                            SetupConnection.getURL(),
                            SetupConnection.getUSER(),
                            SetupConnection.getPASSWORD());
                }
            }
        }
        return connection;
    }
}
