package by.it.bildziuh.project.java;

import by.it.bildziuh.jd03_04.java.Actions;
import by.it.bildziuh.jd03_04.java.Cmd;

import javax.servlet.http.HttpServletRequest;

public class CmdLogout extends by.it.bildziuh.jd03_04.java.Cmd {
    @Override
    public by.it.bildziuh.jd03_04.java.Cmd execute(HttpServletRequest req) throws Exception {
        return Actions.LOGOUT.command;
    }
}
