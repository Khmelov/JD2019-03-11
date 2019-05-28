package by.it.bildziuh.project.java;

import by.it.bildziuh.jd03_04.java.Actions;
import by.it.bildziuh.jd03_04.java.Cmd;

import javax.servlet.http.HttpServletRequest;

public class CmdError extends by.it.bildziuh.jd03_04.java.Cmd {
    @Override
    public by.it.bildziuh.jd03_04.java.Cmd execute(HttpServletRequest req) throws Exception {
        return Actions.ERROR.command;
    }
}
