package by.it.narushevich.project.java.commands;

import javax.servlet.http.HttpServletRequest;

public class CmdError extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req){
        return Actions.ERROR.command;
    }
}
