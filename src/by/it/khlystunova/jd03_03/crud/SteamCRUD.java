package by.it.khlystunova.jd03_03.crud;

import by.it.khlystunova.jd03_03.beans.Steam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class SteamCRUD {

    public boolean create(Steam steam) throws SQLException {
        //Возвращает отформатированную строку, используя указанную строку формата и аргументы.
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO " +
                        "`steam`(`steam`) " +
                        "VALUES ('%s')",
                steam.getSteam()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);//RETURN_GENERATED_KEYS указывает что автоматически сгенерированные ключи должны быть дотсупны для поиска
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    steam.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Steam read(long id) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `steam` WHERE `id`=%d", id
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {

                return new Steam(
                        resultSet.getLong("id"),
                        resultSet.getString("steam")
                );
            }
        }
        return null;
    }
    public boolean update(Steam steam) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `steam` " +
                        "SET `steam`='%s' WHERE `id`=%d",
                steam.getSteam(), steam.getId()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean delete(Steam steam) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `steam` WHERE `id`=%d", steam.getId());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

}
