package by.it.bildziuh.project.java;

import by.it.bildziuh.project.java.beans.Message;
import by.it.bildziuh.project.java.dao.Dao;
import by.it.bildziuh.project.java.utils.FormHelper;
import by.it.bildziuh.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;

public class CmdAddMessage extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {

        if (FormHelper.isPost(req)) {
            Message message = new Message(
                    0,
                    2,
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
