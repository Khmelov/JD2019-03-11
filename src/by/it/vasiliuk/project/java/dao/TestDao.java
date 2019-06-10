package by.it.vasiliuk.project.java.dao;

import by.it.vasiliuk.project.java.beans.Task;
import by.it.vasiliuk.project.java.beans.Role;
import by.it.vasiliuk.project.java.beans.User;

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

        //а теперь Task
        Task task =new Task(0,"classic","fine","hh","two","15430","2015",2);
        dao.task.create(task);
        task =dao.task.read(task.getId());
        System.out.println(task);
        task.settag("test description after update");
        dao.task.update(task);
        task =dao.task.read(task.getId());
        System.out.println(task);
        dao.task.delete(task);
        System.out.println();
    }
}
