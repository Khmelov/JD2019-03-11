package by.it.vasiliuk.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddData {

    private static final String URL = "jdbc:mysql://127.0.0.1:2016/";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws SQLException {
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("INSERT `vasiliuk`.`tasks` (`ID`, `Task`, `Group`, `Creation`, `Description`, `Size`, `Link`, `users_ID`) VALUES (DEFAULT, 'Task_name_1', 'UI', 'Task_cr_1', 'Description_for_t1', 123, 'gdisk', 4);\n");
            statement.executeUpdate("INSERT `vasiliuk`.`tasks` (`ID`, `Task`, `Group`, `Creation`, `Description`, `Size`, `Link`, `users_ID`) VALUES (DEFAULT, 'Task_name_1', 'UI', 'Task_cr_1', 'Description_for_t1', 45, 'gdisk', 4);\n");
            statement.executeUpdate("INSERT `vasiliuk`.`tasks` (`ID`, `Task`, `Group`, `Creation`, `Description`, `Size`, `Link`, `users_ID`) VALUES (DEFAULT, 'Task_name_1', 'UI', 'Task_cr_1', 'Description_for_t1', 56, 'gdisk', 4);\n");
        }
    }
}