package by.it.pileiko.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class C_Reset {



    public static void main(String[] args) throws SQLException {

        try (
                Connection connection = DriverManager.getConnection(ConnectPath.URL, ConnectPath.USER, ConnectPath.PASSWORD);
                Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `pileiko`");
        }


    }
}
