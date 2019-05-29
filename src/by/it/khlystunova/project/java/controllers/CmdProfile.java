package by.it.khlystunova.project.java.controllers;

import by.it.khlystunova.project.java.beans.Request;
import by.it.khlystunova.project.java.beans.User;
import by.it.khlystunova.project.java.dao.Dao;
import by.it.khlystunova.project.java.util.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdProfile extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(30);

        if(session.getAttribute("user") == null){
            return Actions.LOGIN.command;
        }

        if(req.getMethod().equals("POST")) {
        if(Validator.getString(req,"logout").equals("ok")){
            session = req.getSession();
            session.invalidate();
            return Actions.LOGIN.command;
        }
        }
        Dao dao = Dao.getDao();
        User user = (User) session.getAttribute("user");
        List<Request> requests = dao.request.getAll("WHERE users_ID=" + user.getId());
        req.setAttribute("requests", requests);
        return null;
    }
}
