package by.it.narushevich.jd03_02.crud;

import by.it.narushevich.jd03_02.ConnectionCreator;
import by.it.narushevich.jd03_02.beans.Teatag;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class TeatagCRUD {

    public boolean create(Teatag teatag) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `teatags`(`trademark_id`, `subtitle`, `material_id`,"  +
                        " `width`, `height`,`in_collection_since`,"  +
                        "`num_in_catalog`, `users_id`) " +
                        "VALUES (%d,'%s',%d,%f,%f,'%tF','%s',%d)",
                teatag.getTrademark_id(),teatag.getSubtitle(),teatag.getMaterial_id(),
                teatag.getWidth(),teatag.getHeight(),teatag.getIn_collection_since(),
                teatag.getNum_in_catalog(),teatag.getUsers_id());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    teatag.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Teatag read(long id) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `teatags` WHERE `id`=%d", id);
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Teatag(
                        resultSet.getInt("id"),
                        resultSet.getInt("trademark_id"),
                        resultSet.getString("subtitle"),
                        resultSet.getInt("material_id"),
                        resultSet.getDouble("width"),
                        resultSet.getDouble("height"),
                        resultSet.getDate("in_collection_since"),
                        resultSet.getString("num_in_catalog"),
                        resultSet.getInt("users_id"));
            }
        }
        return null;
    }

    public boolean update(Teatag teatag) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `teatags` " +
                        "SET `trademark_id`=%d,`subtitle`='%s',`material_id`=%d," +
                        "`width`=%f, `height`=%f,`in_collection_since`='%s'," +
                        "`num_in_catalog`='%s',`users_id`=%d WHERE `id`=%d",
                teatag.getTrademark_id(),teatag.getSubtitle(),teatag.getMaterial_id(),
                teatag.getWidth(),teatag.getHeight(),teatag.getIn_collection_since(),
                teatag.getNum_in_catalog(),teatag.getUsers_id(),teatag.getId());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean delete(Teatag teatag) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `teatags` WHERE `id`=%d", teatag.getId());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }
}
