package by.it.bolotko.project.java.dao;

import by.it.bolotko.project.java.beans.Car;
import by.it.bolotko.project.java.beans.Role;
import by.it.bolotko.project.java.beans.User;
import by.it.bolotko.project.java.dao.Dao;

import java.sql.SQLException;

public class TestDao {
    public static void main(String[] args) throws SQLException {
        Dao dao=Dao.getDao();
//        dao.resetDataBase();
//        System.out.println("RESET DB!\n");

        //проверка User
        User user=new User(0,"сlient","tneilс","сlient@yandex.ru","+375334537781",2);
        dao.user.create(user);
        user=dao.user.read(user.getId());
        System.out.println(user);
        user.setLogin("PROVEROCHKA");
        dao.user.update(user);
        user=dao.user.read(user.getId());
        System.out.println(user);
        dao.user.delete(user);
        System.out.println();

        //а теперь Role
        Role role=new Role(0,"cleaner");
        dao.role.create(role);
        role=dao.role.read(role.getId());
        System.out.println(role);
        role.setRole("batman");
        dao.role.update(role);
        role=dao.role.read(role.getId());
        System.out.println(role);
        dao.role.delete(role);
        System.out.println();

        //а теперь Car
        Car car=new Car(0,"passagir","benzin","Audi","A3","15430","1994",2);
        dao.car.create(car);
        car=dao.car.read(car.getId());
        System.out.println(car);
        car.setMark("test description after update");
        dao.car.update(car);
        car=dao.car.read(car.getId());
        System.out.println(car);
        dao.car.delete(car);
        System.out.println();
    }
}
