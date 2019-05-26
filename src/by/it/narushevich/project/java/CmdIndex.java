package by.it.narushevich.project.java;

import javax.servlet.http.HttpServletRequest;

public class CmdIndex extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req)  {

        return Actions.INDEX.command;
    }
}
