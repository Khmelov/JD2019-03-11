package by.it.bildziuh.jd03_03.dao;

import by.it.bildziuh.jd03_03.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset {

    public static void main(String[] args) throws SQLException {
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ){
            statement.executeUpdate("DROP SCHEMA IF EXISTS `bildziuh`");
        }

    }
}
