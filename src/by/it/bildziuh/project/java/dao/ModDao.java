package by.it.bildziuh.project.java.dao;

import by.it.bildziuh.project.java.beans.Mod;
import by.it.bildziuh.project.java.connect.ConnectionCreator;
import by.it.bildziuh.project.java.dao.AbstractDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ModDao extends AbstractDao<Mod> {

    @Override
    public boolean create(Mod mod) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `mods`(`game`, `group`, `name`, `description`, `size`, `link`, `users_id`) "
                        + "VALUES ('%s', '%s', '%s', '%s', '%d', '%s', '%d')",
                mod.getGame(), mod.getGroup(),
                mod.getName(), mod.getDescription(), mod.getSize(),
                mod.getLink(), mod.getUsers_id()
        );
        long id = executeCreate(sql);
        if (id > 0)
            mod.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Mod mod) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `mods` SET `game`='%s', `group`='%s', `name`='%s', `description`='%s',"
                        + "`size`='%d', `link`='%s', `users_id`='%d' WHERE `id`='%d'",
                mod.getGame(), mod.getGroup(),
                mod.getName(), mod.getDescription(), mod.getSize(),
                mod.getLink(), mod.getUsers_id(), mod.getId()
        );
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Mod mod) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `mods` WHERE `id`=%d", mod.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Mod> getAll(String where) throws SQLException {
        List<Mod> mods = new ArrayList<>();
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `mods` %s", where
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Mod mod = new Mod(
                        resultSet.getLong("id"),
                        resultSet.getString("game"),
                        resultSet.getString("group"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getInt("size"),
                        resultSet.getString("link"),
                        resultSet.getInt("users_id")
                );

                mods.add(mod);
            }
        }
        return mods;
    }

    @Override
    public Mod read(long id) throws SQLException {
        String where=String.format(" WHERE `id`='%d' LIMIT 0,1", id);
        List<Mod> mods = getAll(where);
        if (mods.size() == 1)
            return mods.get(0);
        else
            return null;
    }

    @Override
    public List<Mod> getAll() throws SQLException {
        return getAll("");
    }
}