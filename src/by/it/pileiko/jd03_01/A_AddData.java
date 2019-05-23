package by.it.pileiko.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class A_AddData {
    public static void main(String[] args)  throws SQLException {
        try (Connection connection= DriverManager.getConnection(ConnectPath.URL, ConnectPath.USER, ConnectPath.PASSWORD);
            Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("INSERT INTO `pileiko`.`cars` (`ID`, `brand`, `model`, `engine`, `price`, `year`, `description`, `users_ID`) VALUES (NULL, 'Audi', 'A6', '1800', '5500', '2001', 'norm avto', '2');");
            statement.executeUpdate("INSERT INTO `pileiko`.`cars` (`ID`, `brand`, `model`, `engine`, `price`, `year`, `description`, `users_ID`) VALUES (NULL, 'Fiat', 'a500', '800', '8050', '2014', 'small and pretty', '1');");
            statement.executeUpdate("INSERT INTO `pileiko`.`cars` (`ID`, `brand`, `model`, `engine`, `price`, `year`, `description`, `users_ID`) VALUES (NULL, 'Opei', 'VectraC', '2200', '6100', '2007', 'Silver color', '1');");
        }

    }
}
