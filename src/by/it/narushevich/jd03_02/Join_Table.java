package by.it.narushevich.jd03_02;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Join_Table {

    public static void join(Statement statement) throws SQLException {
        String sql = "SELECT * FROM users INNER JOIN roles ON users.roles_id=roles.id";
        String sql2 = "SELECT COUNT(*) FROM users INNER JOIN roles ON users.roles_id=roles.id";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
             ResultSetMetaData metaData = resultSet.getMetaData();
             int columnCount = metaData.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                System.out.print(
                        metaData.getColumnLabel(i)+"="+
                                resultSet.getString(i) + '\t'
                );
                System.out.println();
            }
        }
        ResultSet resultSet2 = statement.executeQuery(sql2);
        if (resultSet2.next()){
            System.out.println("Всего записей: "+resultSet2.getInt(1));
        }
    }
}
