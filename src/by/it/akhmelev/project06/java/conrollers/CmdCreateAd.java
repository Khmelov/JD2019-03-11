package by.it.akhmelev.project06.java.conrollers;

import by.it.akhmelev.project06.java.beans.Ad;
import by.it.akhmelev.project06.java.beans.User;
import by.it.akhmelev.project06.java.dao.Dao;
import by.it.akhmelev.project06.java.utils.FormHelper;
import by.it.akhmelev.project06.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateAd extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {

        Object oUser = req.getSession().getAttribute("user");
        if (oUser == null)
            return Actions.LOGIN.command;
        User user = (User) oUser;
        if (FormHelper.isPost(req)) {
            Ad ad = new Ad(
                    0,
                    Validator.getString(req, "description"),
                    Validator.getString(req, "address"),
                    Validator.getInt(req, "rooms"),
                    Validator.getInt(req, "floor"),
                    Validator.getInt(req, "floors"),
                    Validator.getInt(req, "area"),
                    Validator.getInt(req, "price"),
                    user.getId()
            );
            Dao.getDao().ad.create(ad);
            return Actions.PROFILE.command;
        }
        return null;
    }
}
