package by.it.khlystunova.jd03_02.crud;

import by.it.khlystunova.jd03_02.beans.Request;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class RequestCRUD {

    public boolean create(Request request) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `requests`( `users_ID`, `Contact`," +
                        " `DeliveryAddress`, `coffemachines_ID`) " +
                        "VALUES (%d,'%s','%s',%d)",
                request.getUsers_ID(), request.getContact(), request.getDeliveryAddress(), request.getCoffemachines_ID()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    request.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }
    public Request read(long id) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `requests` WHERE `id`=%d", id
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {

                return new Request(
                        resultSet.getLong("id"),
                        resultSet.getLong("users_ID"),
                        resultSet.getString("contact"),
                        resultSet.getString("deliveryAddress"),
                        resultSet.getLong("coffemachines_ID")
                );
            }
        }
        return null;
    }
    public boolean update(Request request) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `requests` " +
                        "SET `users_ID`='%d',`Contact`='%s'," +
                        "`DeliveryAddress`='%s',`coffemachines_ID`=%d WHERE `id`=%d",
                request.getUsers_ID(), request.getContact(),
                request.getDeliveryAddress(), request.getCoffemachines_ID(), request.getId()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }
    public boolean delete(Request request) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `requests` WHERE `id`=%d", request.getId());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }
}
