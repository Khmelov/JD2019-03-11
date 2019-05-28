package by.it.narushevich.project.java.commands;

import by.it.narushevich.project.java.beans.User;
import by.it.narushevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdProfile extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();

        if (session.getAttribute("user") != null){
            User user = (User) session.getAttribute("user");
            req.setAttribute("Login",user.getLogin());
            req.setAttribute("Email",user.getEmail());

            List<String> usersTeatags = Dao.getDao().teatag.getSelected(user.getId());
            req.setAttribute("Teatags",usersTeatags);
            return Actions.PROFILE.command;
        }
        else
            return Actions.LOGIN.command;
    }
}
