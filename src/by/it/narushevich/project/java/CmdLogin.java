package by.it.narushevich.project.java;

import javax.servlet.http.HttpServletRequest;

public class CmdLogin extends by.it.narushevich.project.java.Cmd {
    @Override
    public Cmd execute(HttpServletRequest req)  {

        return Actions.LOGIN.command;
    }
}
