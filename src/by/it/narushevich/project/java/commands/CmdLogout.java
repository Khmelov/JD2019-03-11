package by.it.narushevich.project.java.commands;

import by.it.narushevich.project.java.util.Patterns;
import by.it.narushevich.project.java.util.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdLogout extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) {

        HttpSession session = req.getSession();
        if ((session.getAttribute("user") != null) &&
                (Validator.getString(req, "logout", Patterns.ALL).equals("ok"))
        )
            session.invalidate();
        return Actions.INDEX.command;
    }
}
