package by.it.narushevich.project.java;

import by.it.narushevich.project.java.beans.User;
import by.it.narushevich.project.java.dao.Dao;
import by.it.narushevich.project.java.util.Validator;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {

        if (req.getMethod().equalsIgnoreCase("POST")){
            User user = new User();
            user.setLogin(Validator.getString(req, "login", "[a-zA-Z0-9]{4,}"));
            user.setEmail(req.getParameter("email"));
            user.setPassword(req.getParameter("password"));
            user.setRoles_id(2);

            Dao dao = Dao.getDao();
            if (dao.user.create(user)) {
                return Actions.LOGIN.command;
            }
        }
        return null;
    }
}
