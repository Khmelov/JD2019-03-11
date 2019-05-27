package by.it.khlystunova.project.java;



import javax.servlet.http.HttpServletRequest;

public enum Actions {

    LOGIN(new CmdLogin()),
    INDEX(new CmdIndex()),
    LOGOUT(new CmdLogout()),
    SIGNUP(new CmdSignup()),
    CREATEREQUEST(new CmdCreateRequest()),
    ERROR(new CmdError()),
    RESETDB(new CmdResetDB());


    public Cmd command;

    Actions(Cmd command){
        this.command=command;
    }

    static Cmd defineCommand(HttpServletRequest req) {
        String nameCommand = req.getParameter("command").toUpperCase();
        try {
            return Actions.valueOf(nameCommand).command;//Возвращает константу перечисления указанного типа перечисления с указанным именем.
        } catch (IllegalArgumentException e) {
            return Actions.ERROR.command;
        }
    }

}
