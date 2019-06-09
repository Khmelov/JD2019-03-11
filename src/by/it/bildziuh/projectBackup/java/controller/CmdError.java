package by.it.bildziuh.projectBackup.java.controller;

import by.it.bildziuh.project.java.controller.Actions;

import javax.servlet.http.HttpServletRequest;

public class CmdError extends by.it.bildziuh.project.java.controller.Cmd {
    @Override
    public by.it.bildziuh.project.java.controller.Cmd execute(HttpServletRequest req) throws Exception {
        return Actions.ERROR.command;
    }
}
