package by.it.pileiko.project.java.controller;

import by.it.pileiko.project.java.beans.Car;
import by.it.pileiko.project.java.beans.User;
import by.it.pileiko.project.java.dao.Dao;
import by.it.pileiko.project.java.utils.FormHelper;
import by.it.pileiko.project.java.utils.Tools;
import by.it.pileiko.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdProfile extends Cmd {


    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        Dao dao = Dao.getDao();
        User user= Tools.findUserInSession(req);
        if (user == null) {
            return Actions.LOGIN.command;
        }

        if (FormHelper.isPost(req)) {

            if (FormHelper.contains(req, "update")) {
                String login = Validator.getString(req, "login", "[a-zA-Z0-9]{4,}");
                String password = Validator.getString(req, "password");
                String email = Validator.getString(req, "email");
                user.setLogin(login);
                user.setPassword(password);
                user.setEmail(email);
                dao.user.update(user);
                return this;
            }

            if (FormHelper.contains(req, "logout")) {
                session.invalidate();
                return Actions.LOGIN.command;
            }
        }
        List<Car> cars = dao.car.getAll("WHERE users_id=" + user.getId());
        req.setAttribute("adsSize",cars.size());
        int start=0;
        if (FormHelper.contains(req,"start"))
            start= Validator.getInt(req,"start");
        String limit=String.format(" WHERE users_id=%d LIMIT %s,5",user.getId(),start);
        cars = dao.car.getAll(limit);
        req.setAttribute("cars",cars);
        return null;
    }

}

