package by.it.bildziuh.project.java.controller;

import by.it.bildziuh.project.java.beans.Mod;
import by.it.bildziuh.project.java.beans.User;
import by.it.bildziuh.project.java.dao.Dao;
import by.it.bildziuh.project.java.utils.FormHelper;
import by.it.bildziuh.project.java.utils.Tools;
import by.it.bildziuh.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;

public class CmdAddMod extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        User user = Tools.findUserInSession(req);
        if (user == null)
            return Actions.LOGIN.command;

        if (FormHelper.isPost(req)) {
            Mod mod = new Mod(
                    0,
                    Validator.getString(req, "game"),
                    Validator.getString(req, "group"),
                    Validator.getString(req, "name"),
                    Validator.getString(req, "description"),
                    Validator.getInt(req, "size"),
                    Validator.getString(req, "link"),
                    user.getId()
            );

            Dao dao = Dao.getDao();
            if (dao.mod.create(mod)) {
                return Actions.INDEX.command;
            }
        }
        return null;
    }
}
