package by.it.pileiko.project.java.controller;

import by.it.pileiko.project.java.beans.User;
import by.it.pileiko.project.java.dao.Dao;
import by.it.pileiko.project.java.utils.FormHelper;
import by.it.pileiko.project.java.utils.Tools;
import by.it.pileiko.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdResetDB extends Cmd{

    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
            HttpSession session = req.getSession();
            User user= Tools.findUserInSession(req);

            if (FormHelper.isPost(req)) {
                if (Validator.getString(req, "resetdb").equals("yes")) {
                    if (user != null) {
                        session.invalidate();
                    }
                    Dao dao = Dao.getDao();
                    dao.resetDataBase();
                    return Actions.LOGIN.command;
                }
            }
            return null;
        }
    }