package by.it.khlystunova.project.java.controllers;

import by.it.khlystunova.project.java.beans.User;
import by.it.khlystunova.project.java.dao.Dao;
import by.it.khlystunova.project.java.util.Patterns;
import by.it.khlystunova.project.java.util.Validator;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        if(req.getMethod().equals("POST")) {
            User user = new User();
            user.setId(0);
            user.setLogin(Validator.getString(req,"Login", Patterns.LOGIN));
            user.setPassword(Validator.getString(req,"Password",Patterns.PASSWORD));
            user.setEmail(Validator.getString(req,"Email",Patterns.EMAIL));
            user.setRoles_ID(2);
            Dao dao = Dao.getDao();
            if(dao.user.create(user)) {
                return Actions.LOGIN.command;
            }
        }
        return null;
    }

}
