package by.it.bildziuh.projectBackup.java.controller;

import by.it.bildziuh.project.java.beans.Message;
import by.it.bildziuh.project.java.beans.User;
import by.it.bildziuh.project.java.controller.Actions;
import by.it.bildziuh.project.java.dao.Dao;
import by.it.bildziuh.project.java.utils.FormHelper;
import by.it.bildziuh.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;

public class CmdAddMessage extends by.it.bildziuh.project.java.controller.Cmd {
    @Override
    public by.it.bildziuh.project.java.controller.Cmd execute(HttpServletRequest req) throws Exception {

        Object oUser = req.getSession().getAttribute("user");
        if (oUser == null)
            return by.it.bildziuh.project.java.controller.Actions.LOGIN.command;
        User user = (User) oUser;

        if (FormHelper.isPost(req)) {
            Message message = new Message(
                    0,
                    user.getId(),
                    Validator.getString(req, "message"),
                    1
            );

            Dao dao = Dao.getDao();
            if (dao.message.create(message)) {
                return Actions.INDEX.command;
            }
        }
        return null;
    }
}
