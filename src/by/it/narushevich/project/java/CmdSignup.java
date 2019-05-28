package by.it.narushevich.project.java;

import by.it.narushevich.project.java.beans.User;
import by.it.narushevich.project.java.dao.Dao;
import by.it.narushevich.project.java.util.FormHelper;
import by.it.narushevich.project.java.util.Patterns;
import by.it.narushevich.project.java.util.Validator;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {

        if (FormHelper.isPost(req)){
            User user = new User(0,
                    Validator.getString(req, "login", Patterns.LOGIN),
                    Validator.getString(req,"password",Patterns.PASSWORD),
                    Validator.getString(req,"email",Patterns.EMAIL),
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
