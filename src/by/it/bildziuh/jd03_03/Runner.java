package by.it.bildziuh.jd03_03;

import by.it.bildziuh.jd03_03.beans.Mod;
import by.it.bildziuh.jd03_03.beans.Role;
import by.it.bildziuh.jd03_03.beans.User;
import by.it.bildziuh.jd03_03.crud.ModCRUD;
import by.it.bildziuh.jd03_03.dao.Dao;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {

  /*      Mod mod=new Mod();
        mod.setGame("Skyrim");
        mod.setGroup("Global improvements");
        mod.setName("New Skyrim");
        mod.setDescription("best description ever");
        mod.setSize(400);
        mod.setLink("gdrive");
        mod.setUsers_id(3);
        ModCRUD modCRUD =new ModCRUD();
        modCRUD.create(mod);
        mod= modCRUD.read(mod.getId());
        System.out.println(mod);
        mod.setName("Newest Skyrim");
        mod.setDescription("even better description for mod");
        modCRUD.update(mod);
        mod= modCRUD.read(mod.getId());
        System.out.println(mod);
        modCRUD.delete(mod);*/


//    dao.resetDataBase();

        Dao dao = Dao.getDao();

        User user = new User(0, "TestUser", "qwerty", "test@test.com", 2);
        dao.user.create(user);
        user = dao.user.read(user.getId());
        System.out.println(user);
        user.setLogin("TestSuccess");
        dao.user.update(user);
        user = dao.user.read(user.getId());
        System.out.println(user);
        dao.user.delete(user);

        Role role = new Role(0, "Moderaptor");
        dao.role.create(role);
        role = dao.role.read(role.getId());
        System.out.println(role);
        role.setRole("Moderator");
        dao.role.update(role);
        role = dao.role.read(role.getId());
        System.out.println(role);
        dao.role.delete(role);

        Mod mod = new Mod(0,"Skyrim","Global improvements","New Skyrim","best description ever",400,"gdrive",3);
        ModCRUD modCRUD =new ModCRUD();
        modCRUD.create(mod);

        dao.mod.create(mod);
        mod = dao.mod.read(mod.getId());
        System.out.println(mod);
        mod.setName("Newest Skyrim");
        mod.setDescription("even better description for mod");
        dao.mod.update(mod);
        mod = dao.mod.read(mod.getId());
        System.out.println(mod);
        dao.mod.delete(mod);


    }
}
