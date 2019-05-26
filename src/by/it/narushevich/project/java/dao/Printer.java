package by.it.narushevich.project.java.dao;

import by.it.narushevich.project.java.beans.*;
import by.it.narushevich.project.java.util.Patterns;
import by.it.narushevich.project.java.util.Validator;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class Printer {

    public static void print_user_dao(Dao dao) throws SQLException {
        List<User> users = dao.user.getAll();
        System.out.println("Все пользователи:");
        for (User current : users) System.out.println(current);
        User user=new User(0,"Shashkov","qwerty","petya_rus@ya.ru",2);
        dao.user.create(user);
        user=dao.user.read(user.getId());
        System.out.println("\nНовый пользователь:");
        System.out.println(user);
        user.setLogin("Merry Rodger");
        dao.user.update(user);
        user=dao.user.read(user.getId());
        System.out.println("\nЗамена логина:");
        System.out.println(user);
        dao.user.delete(user);
        users = dao.user.getAll();
        System.out.println("\nВсе пользователи:");
        for (User current : users) System.out.println(current);
    }

    public static void print_role_dao(Dao dao) throws SQLException {
        List<Role> roles = dao.role.getAll();
        System.out.println("\nВсе роли:");
        for (Role current : roles) System.out.println(current);
        Role role = new Role(0,"Head department");
        dao.role.create(role);
        role=dao.role.read(role.getId());
        System.out.println("\nНовая роль:");
        System.out.println(role);
        role.setRole("Laboratory assistant");
        dao.role.update(role);
        role=dao.role.read(role.getId());
        System.out.println("\nЗамена роли:");
        System.out.println(role);
        dao.role.delete(role);
        roles = dao.role.getAll();
        System.out.println("\nВсе роли:");
        for (Role current : roles) System.out.println(current);
    }

    public static void print_material_dao(Dao dao) throws SQLException {
        List<Material> materials = dao.material.getAll();
        System.out.println("\nВсе материалы:");
        for (Material current : materials) System.out.println(current);
        Material material = new Material(0,"Aluminium");
        dao.material.create(material);
        material=dao.material.read(material.getId());
        System.out.println("\nНовый материал:");
        System.out.println(material);
        material.setMaterial("Wood");
        dao.material.update(material);
        material=dao.material.read(material.getId());
        System.out.println("\nЗамена названия:");
        System.out.println(material);
        dao.material.delete(material);
        materials = dao.material.getAll();
        System.out.println("\nВсе материалы:");
        for (Material current : materials) System.out.println(current);
    }

    public static void print_trademark_dao(Dao dao) throws SQLException {
        List<Trademark> trademarks = dao.trademark.getAll();
        System.out.println("\nВсе торговые марки:");
        for (Trademark current : trademarks) System.out.println(current);
        Trademark trademark = new Trademark(0,"Impra");
        dao.trademark.create(trademark);
        trademark=dao.trademark.read(trademark.getId());
        System.out.println("\nНовый торговая марка:");
        System.out.println(trademark);
        trademark.setTrademark("Monarch");
        dao.trademark.update(trademark);
        trademark=dao.trademark.read(trademark.getId());
        System.out.println("\nЗамена названия:");
        System.out.println(trademark);
        dao.trademark.delete(trademark);
        trademarks = dao.trademark.getAll();
        System.out.println("\nВсе торговые марки:");
        for (Trademark current : trademarks) System.out.println(current);
    }

    public static void print_teatag_dao(Dao dao) throws SQLException {
        long trademark_id = 0;
        long material_id = 0;

        List<Teatag> teatags = dao.teatag.getAll();
        System.out.println("\nВсе экземпляры коллекции:");
        for (Teatag current : teatags) System.out.println(current);
        Teatag teatag = new Teatag();

        List<Trademark> trademarks = dao.trademark.getAll(
                "WHERE trademark='Wisotzky tea'");
        Iterator<Trademark> it = trademarks.iterator();
        if (it.hasNext()) {
            trademark_id = it.next().getId();
        }
        teatag.setTrademark_id(trademark_id);

        List<Material> materials = dao.material.getAll(
                "WHERE material='cardboard'");
        Iterator<Material> it2 = materials.iterator();
        if (it2.hasNext()) {
            material_id = it2.next().getId();
        }

        teatag.setMaterial_id(material_id);
        teatag.setSubtitle("Subtitle");
        teatag.setWidth(25);
        teatag.setHeight(28);
        teatag.setIn_collection_since("2018-07-04");
        teatag.setNum_in_catalog("02-04-6");
        teatag.setUser_id(3);

        dao.teatag.create(teatag);
        teatag=dao.teatag.read(teatag.getId());
        System.out.println("\nНовый экземпляр:");
        System.out.println(teatag);
        teatag.setSubtitle("Very tasty tea");
        dao.teatag.update(teatag);
        teatag=dao.teatag.read(teatag.getId());
        System.out.println("\nЗамена подзаголовка:");
        System.out.println(teatag);
        dao.teatag.delete(teatag);
        teatags = dao.teatag.getAll();
        System.out.println("\nВсе экземпляры коллекции:");
        for (Teatag current : teatags) System.out.println(current);
    }


}
