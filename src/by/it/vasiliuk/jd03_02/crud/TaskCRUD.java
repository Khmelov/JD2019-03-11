package by.it.vasiliuk.jd03_02.crud;


import by.it.vasiliuk.jd03_02.beans.Task;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class TaskCRUD {

    public boolean create(Task mod) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `mods`(`game`, `group`, `name`, `description`, `size`, `link`, `users_id`) "
                        + "VALUES ('%s', '%s', '%s', '%s', '%d', '%s', '%d')",
                mod.getGame(), mod.getGroup(),
                mod.getName(), mod.getDescription(), mod.getSize(),
                mod.getLink(), mod.getUsers_id()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    mod.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Task read(long id) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `mods` WHERE `id`=%d", id
        );
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Task task = new Task(
                        resultSet.getLong("id"),
                        resultSet.getString("game"),
                        resultSet.getString("group"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getInt("size"),
                        resultSet.getString("link"),
                        resultSet.getInt("users_id")
                );
                return task;
            }
        }
        return null;
    }

    public boolean update(Task mod) throws SQLException {

        String sql = String.format(Locale.ENGLISH,
                "UPDATE `mods` SET `game`='%s', `group`='%s', `name`='%s', `description`='%s',"
                        + "`size`='%d', `link`='%s', `users_id`='%d' WHERE `id`='%d'",
                mod.getGame(), mod.getGroup(),
                mod.getName(), mod.getDescription(), mod.getSize(),
                mod.getLink(), mod.getUsers_id(), mod.getId()
        );
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean delete(Task mod) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `mods` WHERE `id`=%d", mod.getId());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

}