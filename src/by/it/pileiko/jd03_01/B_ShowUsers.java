package by.it.pileiko.jd03_01;

import java.sql.*;

public class B_ShowUsers {

    public static void main(String[] args) throws SQLException {

        try (Connection connection= DriverManager.getConnection(ConnectPath.URL, ConnectPath.USER, ConnectPath.PASSWORD);
             Statement statement = connection.createStatement()
        ) {

            ResultSet resultSet = statement.executeQuery( "SELECT * FROM `pileiko`.`users`;");

            while (resultSet.next()){
                String out = resultSet.getString("Login") + ", " + resultSet.getString("roles_ID");
                System.out.println(out);

            }

        }

    }
}
