package by.it.bolotko.project.java;

import by.it.bolotko.project.java.utils.FormHelper;
import by.it.bolotko.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdLogout extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();

        if (session.getAttribute("user") == null) {
            return Actions.LOGIN.command;
        }

        if (FormHelper.isPost(req)) {
            if (Validator.getString(req, "logouta").equals("agree")) {
                session.invalidate();
                return Actions.LOGIN.command;
            }

            if (Validator.getString(req, "logoutd").equals("disagree")) {
                return Actions.PROFILE.command;
            } //todo
        }
        return null;
    }
}
