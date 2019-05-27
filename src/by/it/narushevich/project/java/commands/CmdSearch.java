package by.it.narushevich.project.java.commands;

import javax.servlet.http.HttpServletRequest;

public class CmdSearch extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        return Actions.SEARCH.command;
    }
}
