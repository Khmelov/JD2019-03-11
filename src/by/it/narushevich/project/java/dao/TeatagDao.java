package by.it.narushevich.project.java.dao;

import by.it.narushevich.project.java.beans.Teatag;
import by.it.narushevich.project.java.beans.TeatagString;
import by.it.narushevich.project.java.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TeatagDao extends AbstractDao<Teatag> {

    @Override
    public boolean create(Teatag teatag) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `teatags`(`trademark_id`, `subtitle`, `material_id`," +
                        " `width`, `height`,`in_collection_since`," +
                        "`num_in_catalog`, `user_id`) " +
                        "VALUES (%d,'%s',%d,%f,%f,'%s','%s',%d)",
                teatag.getTrademark_id(), teatag.getSubtitle(), teatag.getMaterial_id(),
                teatag.getWidth(), teatag.getHeight(), teatag.getIn_collection_since(),
                teatag.getNum_in_catalog(), teatag.getUser_id());
        long id = executeCreate(sql);
        if (id > 0) {
            teatag.setId(id);
        }
        return id > 0;
    }

    @Override
    public boolean update(Teatag teatag) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `teatags` " +
                        "SET `trademark_id`=%d,`subtitle`='%s',`material_id`=%d," +
                        "`width`=%f, `height`=%f,`in_collection_since`='%s'," +
                        "`num_in_catalog`='%s',`user_id`=%d WHERE `id`=%d",
                teatag.getTrademark_id(), teatag.getSubtitle(), teatag.getMaterial_id(),
                teatag.getWidth(), teatag.getHeight(), teatag.getIn_collection_since(),
                teatag.getNum_in_catalog(), teatag.getUser_id(), teatag.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Teatag teatag) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `teatags` WHERE `id`=%d", teatag.getId());
        return executeUpdate(sql);
    }

    public List<TeatagString> getSelected() throws SQLException {
        List<TeatagString> teatags = new ArrayList<>();
        String sql = "SELECT `trademark`, `subtitle`, `material`, `width`, `height`, " +
                "`in_collection_since`, `num_in_catalog`, `login` " +
                "FROM `teatags` JOIN trademark ON teatags.`trademark_id`=trademark.id " +
                "JOIN material ON teatags.material_id=material.id " +
                "JOIN users ON teatags.user_id=users.id";
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                TeatagString teatag = new TeatagString(
                        resultSet.getString("trademark"),
                        resultSet.getString("subtitle"),
                        resultSet.getString("material"),
                        resultSet.getDouble("width"),
                        resultSet.getDouble("height"),
                        resultSet.getDate("in_collection_since"),
                        resultSet.getString("num_in_catalog"),
                        resultSet.getString("login")
                );
                teatags.add(teatag);
            }
        }
        return teatags;
    }

    public List<TeatagString> getSelected(long id) throws SQLException {
        List<TeatagString> teatags = new ArrayList<>();
        String sql = String.format("SELECT `trademark`, `subtitle`, `material`, `width`, `height`, " +
                "`in_collection_since`, `num_in_catalog`,`login` FROM `teatags` " +
                "JOIN trademark ON teatags.`trademark_id`=trademark.id " +
                "JOIN material ON teatags.material_id=material.id " +
                "JOIN users ON teatags.user_id=users.id" +
                " WHERE teatags.user_id=%d",id);
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                TeatagString teatag = new TeatagString(
                        resultSet.getString("trademark"),
                        resultSet.getString("subtitle"),
                        resultSet.getString("material"),
                        resultSet.getDouble("width"),
                        resultSet.getDouble("height"),
                        resultSet.getDate("in_collection_since"),
                        resultSet.getString("num_in_catalog"),
                        resultSet.getString("login")
                );
                teatags.add(teatag);
            }
        }
        return teatags;
    }


    @Override
    public List<Teatag> getAll(String where) throws SQLException {
        List<Teatag> usersTeatags = new ArrayList<>();
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `teatags` %s", where);
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Teatag teatag = new Teatag(
                        resultSet.getInt("id"),
                        resultSet.getInt("trademark_id"),
                        resultSet.getString("subtitle"),
                        resultSet.getInt("material_id"),
                        resultSet.getDouble("width"),
                        resultSet.getDouble("height"),
                        resultSet.getDate("in_collection_since"),
                        resultSet.getString("num_in_catalog"),
                        resultSet.getInt("user_id"));
                usersTeatags.add(teatag);
            }
        }
        return usersTeatags;
    }

    @Override
    public Teatag read(long id) throws SQLException {
        String where = String.format(" WHERE `id`='%d' LIMIT 0,1", id);
        List<Teatag> teatags = getAll(where);
        if (teatags.size() == 1)
            return teatags.get(0);
        else
            return null;
    }

    @Override
    public List<Teatag> getAll() throws SQLException {
        return getAll("");
    }
}
