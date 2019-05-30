package by.it.akhmelev.project07.java.controller;

import by.it.akhmelev.project07.java.beans.Ad;
import by.it.akhmelev.project07.java.beans.User;
import by.it.akhmelev.project07.java.dao.Dao;
import by.it.akhmelev.project07.java.utils.FormHelper;
import by.it.akhmelev.project07.java.utils.Tools;
import by.it.akhmelev.project07.java.utils.Validator;

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
                return this; //PRG go to Get
            }


            if (FormHelper.contains(req, "logout")) {
                session.invalidate();
                return Actions.LOGIN.command;
            }
        }

        List<Ad> ads = dao.ad.getAll("WHERE users_id=" + user.getId());
        req.setAttribute("ads", ads);


        return null;
    }
}
