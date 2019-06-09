package by.it.bildziuh.projectBackup.java.controller;

import by.it.bildziuh.project.java.beans.Mod;
import by.it.bildziuh.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends by.it.bildziuh.project.java.controller.Cmd {
    @Override
    public by.it.bildziuh.project.java.controller.Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        List<Mod> mods = dao.mod.getAll();
        req.setAttribute("Mods",mods);
        return null;
    }
}
