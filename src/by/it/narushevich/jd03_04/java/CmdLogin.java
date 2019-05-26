package by.it.narushevich.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class CmdLogin extends Cmd{
    @Override
    public Cmd execute(HttpServletRequest req)  {
        return Actions.LOGIN.command;
    }
}
