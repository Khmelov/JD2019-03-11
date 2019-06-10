package by.it.vasiliuk.project.java.CMD;

import by.it.vasiliuk.project.java.beans.User;
import by.it.vasiliuk.project.java.dao.Dao;
import by.it.vasiliuk.project.java.utils.FormHelper;
import by.it.vasiliuk.project.java.utils.Tools;
import by.it.vasiliuk.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdResetDB extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        User user= Tools.findUserInSession(req);

        if (FormHelper.isPost(req)) {
            if (Validator.getString(req, "resetdb").equals("agree")) {
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
