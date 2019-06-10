package by.it.vasiliuk.project.java.CMD;

import javax.servlet.http.HttpServletRequest;

public enum Actions {

    INDEX(new CmdIndex()),
    EDITUSERS(new CmdEditUsers()),
    RESETDB(new CmdResetDB()),
    LOGIN(new CmdLogin()),
    LOGOUT(new CmdLogout()),
    SIGNUP(new CmdSignup()),
    ERROR(new CmdError()),
    CREATETASK(new CmdCreateTask()),
    PROFILE(new CmdProfile());

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
