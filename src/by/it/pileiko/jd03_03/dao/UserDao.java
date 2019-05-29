package by.it.pileiko.jd03_03.dao;

import by.it.pileiko.jd03_03.beans.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

public class UserDao extends AbstractDao <User> {


    @Override
    public boolean create(User user) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO " +
                        "`users`(`login`, `password`, `email`, `roles_id`) " +
                        "VALUES ('%s','%s','%s',%d)",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getRolesId());
        long id = executeCreate("sql");
        if (id>0);
            user.setId(id);
        return id>0;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `users` " +
                        "SET `login`='%s',`password`='%s'," +
                        "`email`='%s',`roles_id`=%d WHERE `id`=%d",
                user.getLogin(), user.getPassword(),
                user.getEmail(), user.getRolesId(), user.getId()
        );
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "DELETE FROM `users` WHERE  `id`= %d", user.getId());
        return executeUpdate(sql);
    }

    @Override
    public User read(long id) throws SQLException {
        return null;
    }

    @Override
    public List<User> getALL() throws SQLException {
        return null;
    }

    @Override
    public List<User> getALL(String where) throws SQLException {
        return null;
    }
}
