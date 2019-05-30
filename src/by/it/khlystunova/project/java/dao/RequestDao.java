package by.it.khlystunova.project.java.dao;

import by.it.khlystunova.project.java.beans.Request;
import by.it.khlystunova.project.java.connect.ConnectionCreator;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RequestDao extends AbstractDao<Request> {
    @Override
    public boolean create(Request request) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `requests`( `users_ID`, `Contact`," +
                        " `DeliveryAddress`, `coffemachines_ID`) " +
                        "VALUES (%d,'%s','%s',%d)",
                request.getUsers_ID(), request.getContact(), request.getDeliveryAddress(), request.getCoffemachines_ID()
        );
        long id = executeCreate(sql);
        if (id > 0)
            request.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Request request) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `requests` " +
                        "SET `users_ID`='%d',`Contact`='%s'," +
                        "`DeliveryAddress`='%s',`coffemachines_ID`=%d WHERE `id`=%d",
                request.getUsers_ID(), request.getContact(),
                request.getDeliveryAddress(), request.getCoffemachines_ID(), request.getId()
        );
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Request request) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "DELETE FROM `requests` WHERE `id`=%d",
                request.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Request> getAll(String where) throws SQLException {
        List<Request> roles = new ArrayList<>();
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `requests` %s", where
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Request request = new Request(
                        resultSet.getLong("id"),
                        resultSet.getLong("users_ID"),
                        resultSet.getString("contact"),
                        resultSet.getString("deliveryAddress"),
                        resultSet.getLong("coffemachines_ID")
                );
                roles.add(request);
            }
        }
        return roles;
    }

    @Override
    public List<Request> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public Request read(long id) throws SQLException {
        String where=String.format(" WHERE `id`='%d' LIMIT 0,1", id);
        List<Request> requests = getAll(where);
        if (requests.size() == 1)
            return requests.get(0);
        else
            return null;
    }

}
