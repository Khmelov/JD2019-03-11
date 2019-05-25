package by.it.khlystunova.project.java;

import by.it.khlystunova.project.java.Cmd;
import by.it.khlystunova.project.java.CmdError;
import by.it.khlystunova.project.java.CmdLogin;
import by.it.khlystunova.project.java.CmdLogout;
import by.it.khlystunova.project.java.CmdSignup;

import javax.servlet.http.HttpServletRequest;

public enum Actions {

    LOGIN(new CmdLogin()),
    LOGOUT(new CmdLogout()),
    SIGNUP(new CmdSignup()),
    ERROR(new CmdError());


    public Cmd command;

    Actions(by.it.khlystunova.project.java.Cmd command){
        this.command=command;
    }
    static Cmd defineCommand(HttpServletRequest req) {
        String nameCommand = req.getParameter("command").toUpperCase();
        try {
            return Actions.valueOf(nameCommand).command;
        } catch (IllegalArgumentException e) {
            return Actions.ERROR.command;
        }
    }

}
