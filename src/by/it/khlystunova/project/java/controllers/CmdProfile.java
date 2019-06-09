package by.it.khlystunova.project.java.controllers;

import by.it.khlystunova.project.java.beans.Request;
import by.it.khlystunova.project.java.beans.User;
import by.it.khlystunova.project.java.dao.Dao;
import by.it.khlystunova.project.java.util.FormHelper;
import by.it.khlystunova.project.java.util.Patterns;
import by.it.khlystunova.project.java.util.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

class CmdProfile extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(30);
        User user = (User)session.getAttribute("user");
        Dao dao = Dao.getDao();

        if(session.getAttribute("user") == null){
            return Actions.LOGIN.command;
        }

        if(FormHelper.isPost(req)) {
            if(FormHelper.contains(req, "update")) {
                String login = Validator.getString(req, "login", Patterns.LOGIN);
                String password = Validator.getString(req, "password",Patterns.PASSWORD);
                String email = Validator.getString(req, "email",Patterns.EMAIL);
                user.setLogin(login);
                user.setPassword(password);
                user.setEmail(email);
                dao.user.update(user);
            }
        if(FormHelper.contains(req, "logout")){
            session.invalidate();
            return Actions.LOGIN.command;
        }
        }
        List<Request> requests = dao.request.getAll("WHERE users_ID=" + user.getId());
        req.setAttribute("requests", requests);
        return null;
    }
}
