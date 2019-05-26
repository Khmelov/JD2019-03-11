package by.it.narushevich.project.java;

import by.it.narushevich.project.java.Actions;
import by.it.narushevich.project.java.Cmd;

import javax.servlet.http.HttpServletRequest;

public class CmdError extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req){
        return Actions.ERROR.command;
    }
}
