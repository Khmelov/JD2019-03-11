package by.it.bildziuh.project.java;

import by.it.bildziuh.jd03_04.java.Cmd;
import by.it.bildziuh.jd03_04.java.CmdError;
import by.it.bildziuh.jd03_04.java.CmdLogin;
import by.it.bildziuh.jd03_04.java.CmdLogout;
import by.it.bildziuh.jd03_04.java.CmdSignup;

import javax.servlet.http.HttpServletRequest;

public enum Actions {

    LOGIN(new CmdLogin()),
    LOGOUT(new CmdLogout()),
    SIGNUP(new CmdSignup()),
    ERROR(new CmdError());

    public by.it.bildziuh.jd03_04.java.Cmd command;

    Actions(by.it.bildziuh.jd03_04.java.Cmd command) {
        this.command = command;
    }

    static by.it.bildziuh.jd03_04.java.Cmd defineCommand(HttpServletRequest req) {
        String nameCommand = req.getParameter("command").toUpperCase();
        try {
            return Actions.valueOf(nameCommand).command;
        } catch (IllegalArgumentException e) {
            return Actions.ERROR.command;
        }
    }



}
