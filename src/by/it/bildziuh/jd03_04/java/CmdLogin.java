package by.it.bildziuh.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class CmdLogin extends Cmd{
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        return Actions.LOGIN.command;
    }
}
