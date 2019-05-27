package by.it.narushevich.project.java.commands;

import javax.servlet.http.HttpServletRequest;

public enum Actions {
    LOGIN (new CmdLogin()),
    LOGOUT (new CmdLogout()),
    SIGNUP (new CmdSignup()),
    ERROR (new CmdError()),
    INDEX (new CmdIndex()),
    CATALOG(new CmdCatalog()),
    SEARCH(new CmdSearch()),
    PROFILE(new CmdProfile()),
    DELETEUSER(new CmdDeleteUser()),
    CREATETAG(new CmdCreateTag()),
    USERCOLLECTION(new CmdUserCollection());

    public Cmd command;

    Actions(Cmd command) {
        this.command = command;
    }

    public static Cmd defineCommand(HttpServletRequest req) {
        String nameCommand = req.getParameter("command").toUpperCase();
        try {
            return Actions.valueOf(nameCommand).command;
        } catch (IllegalArgumentException e) {
            return Actions.ERROR.command;
        }
    }
}
