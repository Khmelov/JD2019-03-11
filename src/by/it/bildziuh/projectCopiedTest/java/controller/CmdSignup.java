package by.it.bildziuh.projectCopiedTest.java.controller;

import by.it.bildziuh.projectCopiedTest.java.beans.User;
import by.it.bildziuh.projectCopiedTest.java.dao.Dao;
import by.it.bildziuh.projectCopiedTest.java.utils.FormHelper;
import by.it.bildziuh.projectCopiedTest.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {

        if (FormHelper.isPost(req)) {
            User user = new User(
                    0,
                    Validator.getString(req, "login", "[a-zA-Z0-9]{4,}"),
                    Validator.getString(req, "password"),
                    Validator.getString(req, "email"),
                    2
            );

            Dao dao = Dao.getDao();
            if (dao.user.create(user)) {
                return Actions.LOGIN.command;
            }
        }
        return null;
    }
}
