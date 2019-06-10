package by.it.vasiliuk.project.java.CMD;

import by.it.vasiliuk.project.java.beans.User;
import by.it.vasiliuk.project.java.dao.Dao;
import by.it.vasiliuk.project.java.utils.FormHelper;
import by.it.vasiliuk.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {

        if (FormHelper.isPost(req)) {
            User user = new User(
                    0,
                    Validator.getString(req, "login", "[a-zA-Z0-9]{4,30}"),
                    Validator.getString(req, "password", "[a-zA-Z0-9@#$%]{4,20}"),
                    Validator.getString(req, "email", "[a-z0-9._%+-]+@[a-z0-9.-]+"),
                    Validator.getString(req, "phone", "[0-9+]{13,13}"),
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
