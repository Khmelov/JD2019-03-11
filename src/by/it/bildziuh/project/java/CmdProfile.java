package by.it.bildziuh.project.java;

import by.it.bildziuh.project.java.beans.Mod;
import by.it.bildziuh.project.java.beans.User;
import by.it.bildziuh.project.java.dao.Dao;
import by.it.bildziuh.project.java.utils.FormHelper;
import by.it.bildziuh.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdProfile extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();

        if (session.getAttribute("user") == null) {
            return Actions.LOGIN.command;
        }

        if (FormHelper.isPost(req)) {
            if (Validator.getString(req, "logout").equals("ok")) {
                session.invalidate();
                return Actions.LOGIN.command;
            }
        }

        Dao dao = Dao.getDao();
        User user = (User) session.getAttribute("user");
        List<Mod> mods = dao.mod.getAll("WHERE users_id=" + user.getId());
        req.setAttribute("mods", mods);


        return null;
    }
}
