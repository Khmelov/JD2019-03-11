package by.it.bildziuh.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup extends Cmd{
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        return Actions.SIGNUP.command;
    }
}
