package by.it.narushevich.project.java;

import javax.servlet.http.HttpServletRequest;

public class CmdLogout extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req)  {
        return Actions.LOGOUT.command;
    }
}
