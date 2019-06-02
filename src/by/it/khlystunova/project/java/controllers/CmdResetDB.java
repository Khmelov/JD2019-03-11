package by.it.khlystunova.project.java.controllers;

import by.it.khlystunova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

class CmdResetDB extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        dao.resetDataBase();
        return Actions.INDEX.command;
    }
}
