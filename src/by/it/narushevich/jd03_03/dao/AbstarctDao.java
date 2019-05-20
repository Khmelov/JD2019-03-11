package by.it.narushevich.jd03_03.dao;

import by.it.narushevich.jd03_03.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstarctDao<TYPE> implements InterfaceDao<TYPE> {

    protected long executeCreate(String sql) throws SQLException {
        try (Connection connection = ConnectionCreator.get();
             Statement statement = connection.createStatement()) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
            }
        }
        throw new SQLException();
    }

    protected boolean executeUpdate(String sql) throws SQLException {
        try (Connection connection = ConnectionCreator.get();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }
}
