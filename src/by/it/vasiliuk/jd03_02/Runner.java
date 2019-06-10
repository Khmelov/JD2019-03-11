package by.it.vasiliuk.jd03_02;

import by.it.vasiliuk.jd03_02.beans.Task;
import by.it.vasiliuk.jd03_02.beans.Role;
import by.it.vasiliuk.jd03_02.beans.User;
import by.it.vasiliuk.jd03_02.crud.TaskCRUD;
import by.it.vasiliuk.jd03_02.crud.RoleCRUD;
import by.it.vasiliuk.jd03_02.crud.UserCRUD;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {

        User user=new User(0,"user_1","qwerty","user@user.com",2);
        UserCRUD userCRUD=new UserCRUD();
        userCRUD.create(user);
        user=userCRUD.read(user.getId());
        System.out.println(user);
        user.setLogin("TestSuccess");
        userCRUD.update(user);
        user=userCRUD.read(user.getId());
        System.out.println(user);
        userCRUD.delete(user);

        Role role=new Role(0,"Moderator");
        RoleCRUD roleCRUD=new RoleCRUD();
        roleCRUD.create(role);
        role=roleCRUD.read(role.getId());
        System.out.println(role);
        role.setRole("Moderator");
        roleCRUD.update(role);
        role=roleCRUD.read(role.getId());
        System.out.println(role);
        roleCRUD.delete(role);

        Task task=new Task();
        task.setTask("Task_1");
        task.setGroup("Global improvements");
        task.setName("New Skyrim");
        task.setDescription("description");
        task.setSize(400);
        task.setLink("gdrive");
        task.setUsers_id(3);
        TaskCRUD taskCRUD =new TaskCRUD();
        taskCRUD.create(task);
        task= taskCRUD.read(task.getId());
        System.out.println(task);
        task.setName("New Task");
        task.setDescription("description");
        taskCRUD.update(task);
        task= taskCRUD.read(task.getId());
        System.out.println(task);
        taskCRUD.delete(task);
    }
}