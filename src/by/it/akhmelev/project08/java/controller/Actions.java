package by.it.akhmelev.project08.java.controller;

import javax.servlet.http.HttpServletRequest;

public enum Actions {

    INDEX(new CmdIndex()),
    EDITUSERS(new CmdEditUsers()),
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
        String nameCommand = req.getParameter("command");
        if (nameCommand==null)
            return Actions.INDEX.command;
        try {
            return Actions.valueOf(nameCommand.toUpperCase()).command;
        } catch (IllegalArgumentException e) {
            return Actions.ERROR.command;
        }
    }

}
