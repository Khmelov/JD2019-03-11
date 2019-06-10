package by.it.pileiko.jd03_01;

import java.sql.*;


public class A_AddUser {
    public static void main(String[] args) throws SQLException {
        try (Connection connection= DriverManager.getConnection(ConnectPath.URL, ConnectPath.USER, ConnectPath.PASSWORD);
             Statement statement = connection.createStatement()
        ) {

            statement.executeUpdate("INSERT INTO `pileiko`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (NULL, 'admin', 'gfhjkm', 'admin@gmail.com', '1');");

        }

    }

}
