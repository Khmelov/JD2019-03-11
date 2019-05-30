package by.it.bolotko.project.java.CMD;

import by.it.bolotko.project.java.beans.User;
import by.it.bolotko.project.java.utils.FormHelper;
import by.it.bolotko.project.java.utils.Tools;

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

            if (FormHelper.contains(req, "logouta")) {
                session.invalidate();
                return Actions.LOGIN.command;
            }

            if (FormHelper.contains(req, "logoutd")) {
                return Actions.PROFILE.command;
            }
        }

        return null;
    }
}
