package by.it.khlystunova.project.java.dao;


import by.it.khlystunova.project.java.beans.*;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao= Dao.getDao();
        Role role=new Role(0,"Manager");
        dao.role.create(role);
        role=dao.role.read(role.getId());
        System.out.println(role);
        role.setRole("Middle_Manager");
        dao.role.update(role);
        role=dao.role.read(role.getId());
        System.out.println(role);
        dao.role.delete(role);

        User user=new User(0,"Ivanov","qwerty","ivan@ya.ru",2);
        dao.user.create(user);
        user=dao.user.read(user.getId());
        System.out.println(user);
        user.setLogin("Mihalkov");
        dao.user.update(user);
        user=dao.user.read(user.getId());
        System.out.println(user);
        dao.user.delete(user);

        Request request=new Request(0,1,"+345 44 44 44 ","Mironova 23/34",1);
        dao.request.create(request);
        request=dao.request.read(request.getId());
        System.out.println(request);
        request.setContact("+ 375 23 23 33");
        dao.request.update(request);
        request=dao.request.read(request.getId());
        System.out.println(request);
        dao.request.delete(request);

        Coffemachine coffemachine=new Coffemachine(0,"STEEL","Steal","454","625x472x510 ",49,"13","12","Black",34.34);
        dao.coffemachine.create(coffemachine);
        coffemachine = dao.coffemachine.read(coffemachine.getId());
        System.out.println(coffemachine);
        coffemachine.setColor("white");
        dao.coffemachine.update(coffemachine);
        coffemachine = dao.coffemachine.read(coffemachine.getId());
        System.out.println(coffemachine);
        dao.coffemachine.delete(coffemachine);

    }
}
