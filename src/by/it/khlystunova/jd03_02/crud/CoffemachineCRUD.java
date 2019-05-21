package by.it.khlystunova.jd03_02.crud;

import by.it.khlystunova.jd03_02.beans.Coffemachine;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CoffemachineCRUD {

    public boolean create(Coffemachine coffemachine) throws SQLException {
        String sql;
        sql = String.format(Locale.ENGLISH,
                "INSERT INTO `coffemachines`( `Name`, `firm_ID`, `Power`, `Size`, `Weight`," +
                        " `steam_ID`, `WaterContainer`, `BeansContainer`, `Color`, `Price`)" +
                        " VALUES ('%s',%d,%d,'%s',%f,"
                        + "%d,"
                        + "'%s','%s','%s',%f)",
                coffemachine.getName(), coffemachine.getFirm_ID(),
                coffemachine.getPower(), coffemachine.getSize(),
                coffemachine.getWeight(),coffemachine.getSteam_ID(),
                coffemachine.getWaterContainer(),
                coffemachine.getBeansContainer(),coffemachine.getColor(),
                coffemachine.getPrice()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    coffemachine.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }
    public Coffemachine read(long id) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `coffemachines` WHERE `id`=%d", id
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Coffemachine(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getLong("firm_ID"),
                        resultSet.getInt("power"),
                        resultSet.getString("size"),
                        resultSet.getDouble("weight"),
                        resultSet.getLong("steam_ID"),
                        resultSet.getString("waterContainer"),
                        resultSet.getString("beansContainer"),
                        resultSet.getString("color"),
                        resultSet.getDouble("price")
                        );
            }
        }
        return null;
    }
    public boolean update(Coffemachine coffemachine) throws SQLException {
        String sql;
        sql = String.format(Locale.ENGLISH,
                "UPDATE `coffemachines` SET `Name`='%s'," +
                        "`firm_ID`='%d',`Power`='%d',`Size`='%s'," +
                        "`Weight`='%f',`steam_ID`='%d',`WaterContainer`='%s'," +
                        "`BeansContainer`='%s'," +
                        "`Color`='%s',`Price`='%f' WHERE 1",
                coffemachine.getName(), coffemachine.getFirm_ID(),
                coffemachine.getPower(), coffemachine.getSize(), coffemachine.getWeight(),
                coffemachine.getSteam_ID(),coffemachine.getWaterContainer(),
                coffemachine.getBeansContainer(),coffemachine.getColor(),
                coffemachine.getPrice()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }
    public boolean delete(Coffemachine coffemachine) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `coffemachines` WHERE `id`=%d", coffemachine.getId());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }
}
