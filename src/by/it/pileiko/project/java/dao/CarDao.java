package by.it.pileiko.project.java.dao;

import by.it.pileiko.project.java.beans.Car;

@SuppressWarnings("all")

public class CarDao extends UniversalDAO<Car> {
    public CarDao() {
        super(new Car(), "cars");
    }

    }



