package by.it.bildziuh.projectBackup.java.controller;

import by.it.bildziuh.project.java.controller.Actions;
import by.it.bildziuh.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdResetDB extends by.it.bildziuh.project.java.controller.Cmd {
    @Override
    public by.it.bildziuh.project.java.controller.Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        dao.resetDataBase();
        return Actions.INDEX.command;
    }
}
