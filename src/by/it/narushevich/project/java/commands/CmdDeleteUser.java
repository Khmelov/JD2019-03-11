package by.it.narushevich.project.java.commands;

import by.it.narushevich.project.java.beans.User;
import by.it.narushevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdDeleteUser extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {

        Dao dao = Dao.getDao();

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        dao.user.delete(user);

            return Actions.INDEX.command;
    }
}
