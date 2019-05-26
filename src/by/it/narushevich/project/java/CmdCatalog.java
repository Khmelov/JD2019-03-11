package by.it.narushevich.project.java;

import by.it.narushevich.project.java.beans.Teatag;
import by.it.narushevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdCatalog extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        List<Teatag> teatags = dao.teatag.getAll();
        req.setAttribute("teatags", teatags);
        return null;
    }
}
