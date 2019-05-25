package by.it.khlystunova.project.java.dao;

import by.it.khlystunova.project.java.beans.Firm;
import by.it.khlystunova.project.java.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FirmDao extends AbstractDao<Firm> {
    @Override
    public boolean create(Firm firm) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO " +
                        "`firm`(`firm`) " +
                        "VALUES ('%s')",
                firm.getFirm()
        );
        long id = executeCreate(sql);
        if (id > 0)
            firm.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Firm firm) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `firm` " +
                        "SET `firm`='%s' WHERE `id`=%d",
                firm.getFirm(), firm.getId()
        );
       return executeUpdate(sql);
    }

    @Override
    public boolean delete(Firm firm) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `firm`" +
                        " WHERE `id`=%d",
                firm.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Firm> getAll(String where) throws SQLException {
        List<Firm> firms = new ArrayList<>();
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `firm` %s", where
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Firm firm = new Firm(
                        resultSet.getLong("id"),
                        resultSet.getString("firm")
                );

                firms.add(firm);
            }
        }
        return firms;
    }

    @Override
    public List<Firm> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public Firm read(long id) throws SQLException {
        String where=String.format(" WHERE `id`='%d' LIMIT 0,1", id);
        List<Firm> firms = getAll(where);
        if (firms.size() == 1)
            return firms.get(0);
        else
            return null;
    }

}
