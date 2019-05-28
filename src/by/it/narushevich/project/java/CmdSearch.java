package by.it.narushevich.project.java;

import javax.servlet.http.HttpServletRequest;

public class CmdSearch extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req) throws Exception {
        return Actions.SEARCH.command;
    }
}
