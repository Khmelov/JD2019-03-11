package by.it.pileiko.jd03_03;

import by.it.pileiko.jd03_03.beans.Car;
import by.it.pileiko.jd03_03.beans.Role;
import by.it.pileiko.jd03_03.beans.User;
import by.it.pileiko.jd03_03.crud.CarCRUD;
import by.it.pileiko.jd03_03.crud.RoleCRUD;
import by.it.pileiko.jd03_03.crud.UserCRUD;
import by.it.pileiko.jd03_03.dao.Dao;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {

        Dao dao = Dao.getDao();

       User user = new User (0, "Perviy", "parol", "pervy@mail.by", 2);
        dao.user.create(user);
        user = dao.user.read(user.getId());
        System.out.println(user);
        user.setLogin("Good User");
        dao.user.update(user);
        user=dao.user.read(user.getId());
        System.out.println(user);
        dao.user.delete(user);

        Role role=new Role(0,"Admin");
        dao.role.create(role);
        role=dao.role.read(role.getId());
        System.out.println(role);
        role.setRole("not good admin");
        dao.role.update(role);
        role = dao.role.read(role.getId());
        System.out.println(role);
        dao.role.delete(role);

        Car car = new Car(2,"VW", "polo", 1600, 6500.5, 2015, "very good small car", 2);
        dao.car.create(car);
        car=dao.car.read(car.getId());
        System.out.println(car);
        car.setDescription("expensive old car");
        dao.car.update(car);
        car=dao.car.read(car.getId());
        System.out.println(car);
        // dao.car.delete(car);

    }

}
