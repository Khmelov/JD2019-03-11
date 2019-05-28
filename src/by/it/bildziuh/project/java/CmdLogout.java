package by.it.bildziuh.project.java;

import javax.servlet.http.HttpServletRequest;

public class CmdLogout extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        return Actions.LOGOUT.command;
    }
}
