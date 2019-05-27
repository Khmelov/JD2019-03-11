package by.it.narushevich.project.java.commands;

import by.it.narushevich.project.java.beans.Teatag;
import by.it.narushevich.project.java.beans.User;
import by.it.narushevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdUserCollection extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String where = "WHERE user_id='"+user.getId()+"'";
        List<Teatag> usersTeatags = Dao.getDao().teatag.getAll(where);
        req.setAttribute("Teatags",usersTeatags.toString());
        return Actions.USERCOLLECTION.command;
    }
}
