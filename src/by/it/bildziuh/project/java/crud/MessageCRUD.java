package by.it.bildziuh.project.java.crud;

import by.it.bildziuh.project.java.beans.Message;
import by.it.bildziuh.project.java.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class MessageCRUD {
    public boolean create(Message message) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `messages`(`id`, `users_id`, `text`, `mods_id`) "
                        + "VALUES ('%d', '%d', '%s', '%d')",
               message.getId(), message.getUsers_id(), message.getText(), message.getMods_id()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    message.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Message read(long id) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `messages` WHERE `id`=%d", id
        );
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Message message = new Message(
                        resultSet.getLong("id"),
                        resultSet.getLong("users_id"),
                        resultSet.getString("text"),
                        resultSet.getLong("mods_id")
                );
                return message;
            }
        }
        return null;
    }

    public boolean update(Message message) throws SQLException {

        String sql = String.format(Locale.ENGLISH,
                "UPDATE `messages` SET `id`='%d', `users_id`='%d', `text`='%s', `mods_id`='%d',",
                message.getId(), message.getUsers_id(), message.getText(), message.getMods_id()
        );
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean delete(Message message) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `messages` WHERE `id`=%d", message.getId());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }


}
