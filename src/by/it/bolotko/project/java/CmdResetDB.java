package by.it.bolotko.project.java;

import by.it.bolotko.project.java.dao.Dao;
import by.it.bolotko.project.java.utils.FormHelper;
import by.it.bolotko.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdResetDB extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();

        if (FormHelper.isPost(req)) {
            if (Validator.getString(req, "resetdb").equals("agree")) {
                Dao dao = Dao.getDao();
                dao.resetDataBase();
                return Actions.INDEX.command;
            }
        }
        return null;
    }
}
