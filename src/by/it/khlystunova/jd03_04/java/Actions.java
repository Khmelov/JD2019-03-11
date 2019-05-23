package by.it.khlystunova.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public enum Actions {

    LOGIN(new CmdLogin()),
    LOGOUT(new CmdLogout()),
    SIGNUP(new CmdSignup());

    public Cmd command;

    Actions(Cmd command){
        this.command=command;
    }

    static Cmd defineCommand(HttpServletRequest req){
        String nameCommand = req.getParameter("command").toUpperCase();
        return Actions.valueOf(nameCommand).command;
    }

}
