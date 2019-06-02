package by.it.khlystunova.project.java.controllers;

import javax.servlet.http.HttpServletRequest;
class CmdHome extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req){
        return Actions.INDEX.command;
    }
}
