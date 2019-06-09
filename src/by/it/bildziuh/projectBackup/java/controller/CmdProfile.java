package by.it.bildziuh.projectBackup.java.controller;

import by.it.bildziuh.project.java.beans.Mod;
import by.it.bildziuh.project.java.beans.User;
import by.it.bildziuh.project.java.controller.Actions;
import by.it.bildziuh.project.java.dao.Dao;
import by.it.bildziuh.project.java.utils.FormHelper;
import by.it.bildziuh.project.java.utils.Tools;
import by.it.bildziuh.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdProfile extends by.it.bildziuh.project.java.controller.Cmd {
    @Override
    public by.it.bildziuh.project.java.controller.Cmd execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        Dao dao = Dao.getDao();

        User user = Tools.findUserInSession(req);
        if (user == null) {
            return by.it.bildziuh.project.java.controller.Actions.LOGIN.command;
        }

        if (FormHelper.isPost(req)) {

            if (FormHelper.contains(req, "update")) {
                String login = Validator.getString(req, "login", "[a-zA-Z0-9]{4,}");
                String password = Validator.getString(req, "password");
                String email = Validator.getString(req, "email");
                user.setLogin(login);
                user.setPassword(password);
                user.setEmail(email);
                dao.user.update(user);
                return this;
            }

            if (FormHelper.contains(req, "logout")) {
                session.invalidate();
                return Actions.LOGIN.command;
            }
        }


        List<Mod> mods = dao.mod.getAll("WHERE users_id=" + user.getId());
   /*     List<String> mods = new ArrayList<>();
        mods.add("1");
        mods.add("2");
        mods.add("3");*/
        req.setAttribute("mods", mods);
        return null;

    }
}
/*
        List<Mod> mods = dao.mod.getAll("WHERE users_id=" + user.getId());
        req.setAttribute("modsSiz", mods.size());
        int start = 0;
        if (FormHelper.contains(req, "start"))
            start = Validator.getInt(req, "start");
        String limit = String.format(" WHERE users_id=%d LIMIT %s,5", user.getId(), start);
        mods = dao.mod.getAll(limit);
        req.setAttribute("mods", mods);
        return null;
    }*/

