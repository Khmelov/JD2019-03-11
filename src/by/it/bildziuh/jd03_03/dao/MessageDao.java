package by.it.bildziuh.jd03_03.dao;

import by.it.bildziuh.jd03_03.beans.Message;
import by.it.bildziuh.jd03_03.connect.ConnectionCreator;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class MessageDao extends AbstractDao<Message> {

    @Override
    public boolean create(Message message) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `messages`(`id`, `users_id`, `text`, `mods_id`) "
                        + "VALUES ('%d', '%d', '%s', '%d')",
                message.getId(), message.getUsers_id(), message.getText(), message.getMods_id()
        );
        long id = executeCreate(sql);
        if (id > 0)
            message.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Message message) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `messages` SET `users_id`='%d', `text`='%s', `mods_id`='%d' WHERE `id`='%d'",
                message.getUsers_id(), message.getText(), message.getMods_id(), message.getId()
        );
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Message message) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `messages` WHERE `id`=%d", message.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Message> getAll(String where) throws SQLException {
        List<Message> messages = new ArrayList<>();
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `messages` %s", where
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Message message = new Message(
                        resultSet.getLong("id"),
                        resultSet.getLong("users_id"),
                        resultSet.getString("text"),
                        resultSet.getLong("mods_id")
                );
                messages.add(message);
            }
        }
        return messages;
    }

    @Override
    public Message read(long id) throws SQLException {
        String where = String.format(" WHERE `id`='%d' LIMIT 0,1", id);
        List<Message> messages = getAll(where);
        if (messages.size() == 1)
            return messages.get(0);
        else
            return null;
    }

    @Override
    public List<Message> getAll() throws SQLException {
        return getAll("");
    }
}