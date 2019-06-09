package by.it.khlystunova.project.java.controllers;



import javax.servlet.http.HttpServletRequest;

public enum Actions {

    LOGIN(new CmdLogin()),
    INDEX(new CmdIndex()),
    PROFILE(new CmdProfile()),
    LOGOUT(new CmdLogout()),
    SIGNUP(new CmdSignup()),
    CREATEREQUEST(new CmdCreateRequest()),
    ERROR(new CmdError()),
    ADITUSERS(new CmdAditUsers()),
    EDITCOFFEMACHINES(new CmdEditCoffemachines()),
    ADDCOFFEMACHINE(new CmdAddCoffemachine()),
    SHOWALLREQUESTS(new CmdShowAllRequests()),
    RESETDB(new CmdResetDB());


    public Cmd command;

    Actions(Cmd command){
        this.command=command;
    }

    static Cmd defineCommand(HttpServletRequest req) {
        String nameCommand = req.getParameter("command").toUpperCase();
        try {
            return Actions.valueOf(nameCommand.toUpperCase()).command;//Возвращает константу перечисления указанного типа перечисления с указанным именем.
        } catch (IllegalArgumentException e) {
            return Actions.ERROR.command;
        }
    }

}
