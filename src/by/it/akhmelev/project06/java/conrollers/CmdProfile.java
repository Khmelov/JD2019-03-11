package by.it.akhmelev.project06.java.conrollers;

import by.it.akhmelev.project06.java.beans.Ad;
import by.it.akhmelev.project06.java.beans.User;
import by.it.akhmelev.project06.java.dao.Dao;
import by.it.akhmelev.project06.java.utils.FormHelper;
import by.it.akhmelev.project06.java.utils.Validator;

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
        List<Ad> ads = dao.ad.getAll("WHERE users_id=" + user.getId());
        req.setAttribute("ads", ads);


        return null;
    }
}
