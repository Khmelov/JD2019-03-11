package by.it.khlystunova.project.java.dao;

import by.it.khlystunova.project.java.beans.User;
import by.it.khlystunova.project.java.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class UserDao extends AbstractDao<User> {
    @Override
    public boolean create(User user) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO " +
                        "`users`(`login`, `password`, `email`, `roles_id`) " +
                        "VALUES ('%s','%s','%s',%d)",
                user.getLogin(), user.getPassword(),
                user.getEmail(), user.getRoles_ID()
        );
        long id = executeCreate(sql);
        if (id > 0)
            user.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `users` " +
                        "SET `login`='%s',`password`='%s'," +
                        "`email`='%s',`roles_id`=%d WHERE `id`=%d",
                user.getLogin(), user.getPassword(),
                user.getEmail(), user.getRoles_ID(), user.getId()
        );
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `users` WHERE `id`=%d", user.getId());
         return executeUpdate(sql);
    }

    @Override
    public List<User> getAll(String where) throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `users` %s", where
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getLong("roles_id")
                );

                users.add(user);
            }
        }
        return users;
    }

    @Override
    public List<User> getAll() throws SQLException {
        return getAll("");
    }


    public Set<String> getAllLogins() throws SQLException {
        Set<String> logins = new HashSet<String>();
        List<User> users = getAll();
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User next = iterator.next();
            String login = next.getLogin();
            logins.add(login);
        }
        return logins;
    }

    @Override
    public User read(long id) throws SQLException {
        String where=String.format(" WHERE `id`='%d' LIMIT 0,1", id);
        List<User> roles = getAll(where);
        if (roles.size() == 1)
            return roles.get(0);
        else
            return null;
    }
}
