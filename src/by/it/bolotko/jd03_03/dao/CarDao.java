package by.it.bolotko.jd03_03.dao;


import by.it.bolotko.jd03_03.beans.Car;

public class CarDao extends UniversalDAO<Car>{
    public CarDao() { super(new Car(), "cars"); }
}
