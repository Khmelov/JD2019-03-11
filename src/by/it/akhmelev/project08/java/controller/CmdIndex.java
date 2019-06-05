package by.it.akhmelev.project08.java.controller;

import by.it.akhmelev.project08.java.beans.Ad;
import by.it.akhmelev.project08.java.dao.Dao;
import by.it.akhmelev.project08.java.utils.FormHelper;
import by.it.akhmelev.project08.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        List<Ad> ads = dao.ad.getAll();
        req.setAttribute("adsSize",ads.size());
        int start=0;
        if (FormHelper.contains(req,"start"))
            start= Validator.getInt(req,"start");
        String limit=String.format(" LIMIT %s,10",start);
        ads = dao.ad.getAll(limit);
        req.setAttribute("ads",ads);
        return null;
    }
}
