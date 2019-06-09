package by.it.bildziuh.projectBackup.java.controller;

import javax.servlet.http.HttpServletRequest;

public enum Actions {

    EDITUSERS(new CmdEditUsers()),
    PROFILE(new CmdProfile()),
    ADDMESSAGE(new CmdAddMessage()),
    ADDMOD(new CmdAddMod()),
    INDEX(new CmdIndex()),
    RESETDB(new CmdResetDB()),
    LOGIN(new CmdLogin()),
    LOGOUT(new CmdLogout()),
    SIGNUP(new CmdSignup()),
    ERROR(new CmdError());

    public by.it.bildziuh.project.java.controller.Cmd command;

    Actions(by.it.bildziuh.project.java.controller.Cmd command) {
        this.command = command;
    }

    static by.it.bildziuh.project.java.controller.Cmd defineCommand(HttpServletRequest req) {
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
