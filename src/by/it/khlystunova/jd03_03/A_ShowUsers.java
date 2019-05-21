package by.it.khlystunova.jd03_03;


import by.it.khlystunova.jd03_03.connect.ConnectionCreator;

import java.sql.*;

public class A_ShowUsers {

//    static {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (Exception ex) {
//            // handle the error
//        }
//    }

    public static void main(String[] args) throws SQLException {
        try (Connection connection = ConnectionCreator.get();
             Statement statement = connection.createStatement())
        {
            int countUsers = 0;
            int countRoles = 0;
           //получаем пользователей
            ResultSet resultSet = statement.executeQuery("SELECT Login,roles.Role FROM users LEFT JOIN roles ON users.roles_ID=roles.ID");
            while(resultSet.next()){
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(
                            metaData.getColumnLabel(i) + "=" +
                                    resultSet.getString(i) + "\t"
                    );
                    System.out.println();
                }
                countUsers++;
            }
            ResultSet result = statement.executeQuery("SELECT * FROM roles");
            while (result.next()) {
                countRoles++;
            }
            System.out.println("Всего пользователей: " + countUsers);
            System.out.println("Всего возможных ролей: " + countRoles);
        }
    }
}
