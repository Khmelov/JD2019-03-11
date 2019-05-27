package by.it.narushevich.project.java.commands;

import by.it.narushevich.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdProfile extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();

        if (session.getAttribute("user") == null) {
            return Actions.LOGIN.command;
        }

        User user = (User) session.getAttribute("user");
        req.setAttribute("Login",user.getLogin());
        req.setAttribute("Email",user.getEmail());

        return Actions.PROFILE.command;
    }
}
