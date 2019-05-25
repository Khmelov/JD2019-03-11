package by.it.bolotko.project.java;

import by.it.bolotko.project.java.ActionCommand;
import by.it.bolotko.project.java.Actions;
import by.it.bolotko.project.java.CommandError;
import by.it.bolotko.project.java.Messages;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    by.it.bolotko.project.java.ActionCommand defineCommand(HttpServletRequest request) {

        //если команда не найдена, то вернем пустую.
        //иначе вернем команду для выполнения
        return null;
    }
}