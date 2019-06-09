package by.it.bildziuh.project.java.controller;

import by.it.bildziuh.project.java.beans.Mod;
import by.it.bildziuh.project.java.dao.Dao;
import by.it.bildziuh.project.java.utils.FormHelper;
import by.it.bildziuh.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        List<Mod> mods = dao.mod.getAll();
        req.setAttribute("modsSize",mods.size());
        int start=0;
        if (FormHelper.contains(req,"start"))
            start= Validator.getInt(req,"start");
        String limit=String.format(" LIMIT %s,10",start);
        mods = dao.mod.getAll(limit);
        req.setAttribute("mods",mods);
        return null;
    }
}
