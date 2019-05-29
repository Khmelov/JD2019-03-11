package by.it.khlystunova.project.java.controllers;

import javax.servlet.http.HttpServletRequest;

public class CmdHome extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req) throws Exception {
        return Actions.INDEX.command;
    }
}
