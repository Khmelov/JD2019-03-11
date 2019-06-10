package by.it.pileiko.jd03_03.dao;

import by.it.pileiko.jd03_03.beans.Car;

import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("all")

public class CarDao extends UniversalDAO<Car> {
    public CarDao() {
        super(new Car(), "cars");
    }

    }



