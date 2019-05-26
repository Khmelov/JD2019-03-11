package by.it.pileiko.jd03_02.crud;

import by.it.pileiko.jd03_02.beans.Car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CarCRUD {

    public boolean create(Car car) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `cars`(" +
                        " `brand`, `model`, " +
                        "`engine`, `price`, `year`, " +
                        "`description`, `users_ID`) " +
                        "VALUES ('%s','%s',%d,%f,%d,'%s',%d)", car.getBrand(), car.getModel(), car.getEngine(),
                car.getPrice(), car.getYear(), car.getDescription(), car.getUsersId());

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    car.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Car read(long id) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `cars` WHERE  `id`= %d", id);
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Car car = new Car(
                        resultSet.getLong("id"),
                        resultSet.getString("brand"),
                        resultSet.getString("model"),
                        resultSet.getInt("engine"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("year"),
                        resultSet.getString("description"),
                        resultSet.getLong("userId")
                );
                return car;
            }
        }
        return null;
    }

    public boolean update (Car car) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `cars` SET" +
                        " `brand`='%s', `model`='%s', " +
                        "`engine`=%d, `price`=%f, `year`=%d, " +
                        "`description`='%s', `users_ID`=%d WHERE id=%d",
                car.getBrand(), car.getModel(), car.getEngine(),
                car.getPrice(), car.getYear(), car.getDescription(), car.getUsersId());

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));

        }
    }

    public boolean delete (Car car) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "DELETE FROM `cars` WHERE  `id`= %d", car.getId());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));

        }
    }

}




