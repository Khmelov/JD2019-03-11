package by.it.narushevich.project.java.commands;

import javax.servlet.http.HttpServletRequest;

public class CmdSearch extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) {
        return Actions.SEARCH.command;
    }
}
