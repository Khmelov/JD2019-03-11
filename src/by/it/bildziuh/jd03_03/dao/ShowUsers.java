package by.it.bildziuh.jd03_03.dao;


import by.it.bildziuh.jd03_03.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ShowUsers {

    public static void main(String[] args) {
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement())
        {

            int countUsers = 0;
            int countRoles = 0;
            ResultSet resultSet = statement.executeQuery("SELECT login,roles.role FROM users LEFT JOIN roles ON users.roles_ID=roles.ID");
            while (resultSet.next()) {
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                resultSet.getMetaData().getColumnCount();
                int columnCount = resultSetMetaData.getColumnCount();
                for (int i = 1; i < columnCount + 1; i++)
                    System.out.print(
                            resultSetMetaData.getColumnLabel(i) + "=" +
                                    resultSet.getString(i) + "\t\t"
                    );
                System.out.println();
                countUsers++;
            }
            ResultSet result = statement.executeQuery("SELECT * FROM roles");
            while (result.next()) {
                countRoles++;
            }
            System.out.println("Всего пользователей: " + countUsers);
            System.out.println("Всего возможных ролей: " + countRoles);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
