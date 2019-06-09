package by.it.bildziuh.projectBackup.java.controller;

import by.it.bildziuh.project.java.beans.User;
import by.it.bildziuh.project.java.controller.Actions;
import by.it.bildziuh.project.java.dao.Dao;
import by.it.bildziuh.project.java.utils.FormHelper;
import by.it.bildziuh.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup extends by.it.bildziuh.project.java.controller.Cmd {
    @Override
    public by.it.bildziuh.project.java.controller.Cmd execute(HttpServletRequest req) throws Exception {

        if (FormHelper.isPost(req)) {
            User user = new User(
                    0,
                    Validator.getString(req, "login", "[a-zA-Z0-9]{4,}"),
                    Validator.getString(req, "password"),
                    Validator.getString(req, "email"),
                    3
            );

            Dao dao = Dao.getDao();
            if (dao.user.create(user)) {
                return Actions.LOGIN.command;
            }
        }
        return null;
    }
}
