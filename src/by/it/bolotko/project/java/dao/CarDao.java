package by.it.bolotko.project.java.dao;


import by.it.bolotko.project.java.beans.Car;
import by.it.bolotko.project.java.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CarDao extends AbstractDao<Car>{
    @Override
    public boolean create(Car car) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO " +
                        "`cars`(`car_type`, `fuel_type`, `mark`, `model`, `price`, `year_of_issue`, `users_id`) " +
                        "VALUES ('%s','%s','%s','%s','%s','%s',%d)",
                car.getCar_type(), car.getFuel_type(), car.getMark(), car.getModel(), car.getPrice(), car.getYear_of_issue(), car.getUsers_id()
        );
        long id = executeCreate(sql);
        if (id > 0)
            car.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Car car) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `cars` " +
                        "SET `car_type`='%s',`fuel_type`='%s'," +
                        "`mark`='%s',`model`='%s',`price`='%s',`year_of_issue`='%s',`users_id`=%d WHERE `id`=%d",
                car.getCar_type(), car.getFuel_type(),
                car.getMark(), car.getModel(),
                car.getPrice(), car.getYear_of_issue(),
                car.getUsers_id(), car.getId()
        );
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Car car) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `cars` WHERE `id`=%d", car.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Car> getAll(String where) throws SQLException {
        List<Car> cars = new ArrayList<>();
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `cars` %s", where
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Car car = new Car(
                        resultSet.getLong("id"),
                        resultSet.getString("car_type"),
                        resultSet.getString("fuel_type"),
                        resultSet.getString("mark"),
                        resultSet.getString("model"),
                        resultSet.getString("price"),
                        resultSet.getString("year_of_issue"),
                        resultSet.getLong("users_id")
                );
                cars.add(car);
            }
        }
        return cars;
    }

    @Override
    public Car read(long id) throws SQLException {
        String where = String.format(" WHERE `id`=%d LIMIT 0,1", id);
        List<Car> cars = getAll(where);
        if (cars.size() == 1)
            return cars.get(0);
        else
            return null;
    }

    @Override
    public List<Car> getAll() throws SQLException {
        return getAll("");
    }
}

