package by.it.khlystunova.jd03_02.crud;

import by.it.khlystunova.jd03_02.beans.Firm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class FirmCRUD {

    public boolean create(Firm firm) throws SQLException {
        //Возвращает отформатированную строку, используя указанную строку формата и аргументы.
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO " +
                        "`firm`(`firm`) " +
                        "VALUES ('%s')",
                firm.getFirm()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);//RETURN_GENERATED_KEYS указывает что автоматически сгенерированные ключи должны быть дотсупны для поиска
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    firm.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }
    public Firm read(long id) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `firm` WHERE `id`=%d", id
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {

                return new Firm(
                        resultSet.getLong("id"),
                        resultSet.getString("firm")
                );
            }
        }
        return null;
    }
    public boolean update(Firm firm) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `firm` " +
                        "SET `firm`='%s' WHERE `id`=%d",
                firm.getFirm(), firm.getId()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }
    public boolean delete(Firm firm) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `firm` WHERE `id`=%d", firm.getId());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }
}
