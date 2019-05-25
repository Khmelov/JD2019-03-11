package by.it.narushevich.project.java;

import javax.servlet.http.HttpServletRequest;

public enum Actions {
    LOGIN (new CmdLogin()),
    LOGOUT (new CmdLogout()),
    SIGNUP (new CmdSignup()),
    ERROR (new CmdError());

    public by.it.narushevich.project.java.Cmd command;

    Actions(by.it.narushevich.project.java.Cmd command) {
        this.command = command;
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
