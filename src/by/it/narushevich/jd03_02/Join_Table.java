package by.it.narushevich.jd03_02;

import java.sql.*;

public class Join_Table {

    public static void main(String[] args) throws SQLException {
        try (Connection connection = ConnectionCreator.get();
             Statement statement = connection.createStatement()) {

            String sql = "SELECT login,password,email,role FROM users INNER JOIN roles ON users.roles_id=roles.id";
            String sql2 = "SELECT COUNT(*) FROM users INNER JOIN roles ON users.roles_id=roles.id";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i < columnCount+1; i++) {
                    System.out.printf("%8s = %-20s",
                            metaData.getColumnLabel(i),
                            resultSet.getString(i));
                }
                System.out.println();
            }
            ResultSet resultSet2 = statement.executeQuery(sql2);
            if (resultSet2.next()){
                System.out.println("Всего записей: "+resultSet2.getInt(1));
            }
        }
    }

}
