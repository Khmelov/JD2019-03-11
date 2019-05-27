package by.it.akhmelev.project06.java.conrollers;

import javax.servlet.http.HttpServletRequest;

public enum Actions {

    INDEX(new CmdIndex()),
    CREATEAD(new CmdCreateAd()),
    RESETDB(new CmdResetDB()),
    LOGIN(new CmdLogin()),
    PROFILE(new CmdProfile()),
    SIGNUP(new CmdSignup()),
    ERROR(new CmdError());

    public Cmd command;

    Actions(Cmd command) {
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
