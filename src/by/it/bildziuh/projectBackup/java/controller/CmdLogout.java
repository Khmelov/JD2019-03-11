package by.it.bildziuh.projectBackup.java.controller;

import by.it.bildziuh.project.java.controller.Actions;

import javax.servlet.http.HttpServletRequest;

public class CmdLogout extends by.it.bildziuh.project.java.controller.Cmd {
    @Override
    public by.it.bildziuh.project.java.controller.Cmd execute(HttpServletRequest req) throws Exception {
        return Actions.LOGOUT.command;
    }
}
