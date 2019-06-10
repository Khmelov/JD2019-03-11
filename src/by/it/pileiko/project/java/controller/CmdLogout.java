package by.it.pileiko.project.java.controller;

import by.it.pileiko.project.java.beans.User;
import by.it.pileiko.project.java.utils.FormHelper;
import by.it.pileiko.project.java.utils.Tools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdLogout extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user= Tools.findUserInSession(req);

        if (user == null) {
            return Actions.LOGIN.command;
        }
        if (FormHelper.isPost(req)) {
            if (FormHelper.contains(req, "logoutY")) {
                session.invalidate();
                return Actions.LOGIN.command;
            }
            if (FormHelper.contains(req, "logoutN")) {
                return Actions.PROFILE.command;
            }
        }
        return null;
    }
}

