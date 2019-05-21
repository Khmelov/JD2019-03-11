package by.it.narushevich.jd03_03;

import by.it.narushevich.jd03_03.connect.ConnectionCreator;

import java.sql.*;

public class Lisa_refactoring {

        public static void main(String[] args) throws SQLException {
            try (Connection connection = ConnectionCreator.get();
                 Statement statement = connection.createStatement())
            {
                ResultSet resultSet = statement.executeQuery("SELECT login,roles.role FROM users LEFT JOIN roles ON users.roles_id=roles.id");
                while(resultSet.next()){
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.printf("%8s = %-10s\t",
                                metaData.getColumnLabel(i),
                                resultSet.getString(i)
                        );
                    }
                    System.out.println();
                }
                ResultSet result = statement.executeQuery("SELECT COUNT(*) FROM users");
                if (result.next()) {
                    System.out.println("\nВсего пользователей: " + result.getInt(1));
                }

                ResultSet result2 = statement.executeQuery("SELECT COUNT(*) FROM roles");
                if (result2.next()) {
                    System.out.println("Всего возможных ролей: " + result2.getInt(1));
                }

            }
        }
    }
