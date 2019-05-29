package by.it.akhmelev.project07.java.controller;

import by.it.akhmelev.project07.java.beans.Ad;
import by.it.akhmelev.project07.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        List<Ad> ads = dao.ad.getAll();
        req.setAttribute("ads",ads);
        return null;
    }
}
