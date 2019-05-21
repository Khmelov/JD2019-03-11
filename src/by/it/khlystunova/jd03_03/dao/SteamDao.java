package by.it.khlystunova.jd03_03.dao;

import by.it.khlystunova.jd03_03.beans.Steam;
import by.it.khlystunova.jd03_03.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SteamDao extends AbstractDao<Steam> {
    @Override
    public boolean create(Steam steam) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO " +
                        "`steam`(`steam`) " +
                        "VALUES ('%s')",
                steam.getSteam()
        );
        long id = executeCreate(sql);
        if (id > 0)
            steam.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Steam steam) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `steam` " +
                        "SET `steam`='%s' WHERE `id`=%d",
                steam.getSteam(), steam.getId()
        );
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Steam steam) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "DELETE FROM `steam` WHERE `id`=%d",
                steam.getId());

        return executeUpdate(sql);
    }

    @Override
    public List<Steam> getAll(String where) throws SQLException {
        List<Steam> steams = new ArrayList<>();
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `steam` %s", where
        );
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Steam steam = new Steam(
                        resultSet.getLong("id"),
                        resultSet.getString("steam")
                );

                steams.add(steam);
            }
        }
        return steams;
    }

    @Override
    public List<Steam> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public Steam read(long id) throws SQLException {
        String where=String.format(" WHERE `id`='%d' LIMIT 0,1", id);
        List<Steam> steams = getAll(where);
        if (steams.size() == 1)
            return steams.get(0);
        else
            return null;
    }

}
