package by.it.pileiko.jd03_02;

import by.it.pileiko.jd03_02.beans.Car;
import by.it.pileiko.jd03_02.beans.Role;
import by.it.pileiko.jd03_02.beans.User;
import by.it.pileiko.jd03_02.crud.CarCRUD;
import by.it.pileiko.jd03_02.crud.RoleCRUD;
import by.it.pileiko.jd03_02.crud.UserCRUD;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        User user = new User(0, "Perviy", "parol", "pervy@mail.by", 2);
        UserCRUD userCRUD = new UserCRUD();
        userCRUD.create(user);
        user=userCRUD.read(user.getId());

        System.out.println(user);

        user.setLogin("Good User");
        userCRUD.update(user);
        user=userCRUD.read(user.getId());
        System.out.println(user);

        Role role=new Role(0,"Admin");
        RoleCRUD roleCRUD=new RoleCRUD();
        roleCRUD.create(role);
        role=roleCRUD.read(role.getId());
        System.out.println(role);
        role.setRole(" not good admin");
        roleCRUD.update(role);
        role=roleCRUD.read(role.getId());
        System.out.println(role);
        roleCRUD.delete(role);

        Car car = new Car();
        car.setDescription("very good small car");
        car.setUsersId(2);
        car.setBrand("VW");
        car.setEngine(1600);
        car.setModel("polo");
        car.setPrice(6500.5);
        car.setYear(2015);
        CarCRUD carCRUD = new CarCRUD();
        carCRUD.create(car);
        car=carCRUD.read(car.getId());
        System.out.println(car);
        car.setDescription("expensive old car");
        carCRUD.update(car);
        car=carCRUD.read(car.getId());
        System.out.println(car);
        carCRUD.delete(car);



    }

}
