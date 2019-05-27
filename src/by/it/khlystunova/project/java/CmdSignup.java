package by.it.khlystunova.project.java;

import by.it.khlystunova.project.java.beans.User;
import by.it.khlystunova.project.java.dao.Dao;
import by.it.khlystunova.project.java.util.Validator;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        if(req.getMethod().equals("POST")) {
            User user = new User();
            user.setId(0);
            user.setLogin(Validator.getString(req,"Login","[a-zA-Z0-9]{4,}"));
            user.setPassword(Validator.getString(req,"Password","[a-zA-Z0-9]{5,}"));
            user.setEmail(Validator.getString(req,"Email","[@.A-Za-z]{1,}"));
            user.setRoles_ID(2);
            Dao dao = Dao.getDao();
            if(dao.user.create(user)) {
                return Actions.LOGIN.command;
            }
        }
        return null;
    }

}
