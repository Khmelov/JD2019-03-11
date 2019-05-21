package by.it.khlystunova.jd03_03;

import by.it.khlystunova.jd03_03.beans.*;
import by.it.khlystunova.jd03_03.crud.*;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        //Role
        Role role=new Role(0,"manager");
        RoleCRUD roleCRUD=new RoleCRUD();
        roleCRUD.create(role);
        role=roleCRUD.read(role.getId());
        System.out.println("Читаем из бд созданную роль");
        System.out.println(role);
        role.setRole("manager2");
        roleCRUD.update(role);
        role=roleCRUD.read(role.getId());
        System.out.println("Читаем из бд обнавленную роль");
        System.out.println(role);
        roleCRUD.delete(role);

        User user=new User(0,"Ivanov","qwerty","ivan@ya.ru",2);
        UserCRUD userCRUD=new UserCRUD();
        userCRUD.create(user);
        user=userCRUD.read(user.getId());
        System.out.println("Читаем из бд созданного пользователя");
        System.out.println(user);
        user.setLogin("LLLLLLLLLLLLLLLLLLLLL");
        userCRUD.update(user);
        user=userCRUD.read(user.getId());
        System.out.println("Читаем из бд обнавленного пользователя");
        System.out.println(user);
        userCRUD.delete(user);

        Request request=new Request(0,1,"+345 44 44 44 ","Mironova 23/34",1);
        RequestCRUD requestCRUD=new RequestCRUD();
        requestCRUD.create(request);
        request=requestCRUD.read(request.getId());
        System.out.println("Читаем из бд созданную заявку");
        System.out.println(request);
        request.setDeliveryAdress("Maiakovskogo 33/4");
        requestCRUD.update(request);
        request=requestCRUD.read(request.getId());
        System.out.println("Читаем из бд обнавленную заявку");
        System.out.println(request);
        requestCRUD.delete(request);

        Firm firm=new Firm(0,"Furla");
        FirmCRUD firmCRUD=new FirmCRUD();
        firmCRUD.create(firm);
        firm=firmCRUD.read(firm.getId());
        System.out.println("Читаем из бд созданную фирму");
        System.out.println(firm);
        firm.setFirm("Milano");
        firmCRUD.update(firm);
        firm=firmCRUD.read(firm.getId());
        System.out.println("Читаем из бд обнавленную фирму");
        System.out.println(firm);
        firmCRUD.delete(firm);

        Steam steam=new Steam(0,"Automat1");
        SteamCRUD steamCRUD=new SteamCRUD();
        steamCRUD.create(steam);
        steam=steamCRUD.read(steam.getId());
        System.out.println("Читаем из бд созданный капучинатор");
        System.out.println(steam);
        steam.setSteam("Automat2");
        steamCRUD.update(steam);
        steam=steamCRUD.read(steam.getId());
        System.out.println("Читаем из бд обнавленный капучинатор");
        System.out.println(steam);
        steamCRUD.delete(steam);

        Coffemachine coffemachine=new Coffemachine(0,"STEEL",1,230,"625x472x510 ",49,1,"13","12","Black",34.34);
        CoffemachineCRUD coffemachineCRUD=new CoffemachineCRUD();
        coffemachineCRUD.create(coffemachine);
        coffemachine=coffemachineCRUD.read(coffemachine.getId());
        System.out.println("Читаем из бд созданную кофемашину");
        System.out.println(coffemachine);
        coffemachine.setName("Lisi");
        coffemachineCRUD.update(coffemachine);
        coffemachine=coffemachineCRUD.read(coffemachine.getId());
        System.out.println("Читаем из бд обнавленную кофемашину");
        System.out.println(coffemachine);
        coffemachineCRUD.delete(coffemachine);
    }
}
