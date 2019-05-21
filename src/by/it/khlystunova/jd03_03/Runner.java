package by.it.khlystunova.jd03_03;


import by.it.khlystunova.jd03_03.beans.*;
import by.it.khlystunova.jd03_03.dao.Dao;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao= Dao.getDao();


        //а теперь Role
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

        Firm firm=new Firm(0,"Furla");
        dao.firm.create(firm);
        firm= dao.firm.read(firm.getId());
        System.out.println(firm);
        firm.setFirm("DuDu");
        dao.firm.update(firm);
        firm=dao.firm.read(firm.getId());
        System.out.println(firm);
        dao.firm.delete(firm);

        Steam steam=new Steam(0,"Automat1");
        dao.steam.create(steam);
        steam= dao.steam.read(steam.getId());
        System.out.println(steam);
        steam.setSteam("DuDu");
        dao.steam.update(steam);
        steam=dao.steam.read(steam.getId());
        System.out.println(steam);
        dao.steam.delete(steam);

        Coffemachine coffemachine=new Coffemachine(0,"STEEL",1,230,"625x472x510 ",49,1,"13","12","Black",34.34);
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
