package by.it.akhmelev.project08.java.controller;

import by.it.akhmelev.project08.java.beans.Ad;
import by.it.akhmelev.project08.java.beans.User;
import by.it.akhmelev.project08.java.dao.Dao;
import by.it.akhmelev.project08.java.utils.FormHelper;
import by.it.akhmelev.project08.java.utils.Tools;
import by.it.akhmelev.project08.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateAd extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        User user = Tools.findUserInSession(req);
        if (user == null)
            return Actions.LOGIN.command;
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
            Tools.createImage(req,"img"+ad.getId());
            return Actions.PROFILE.command;
        }
        return null;
    }
}
