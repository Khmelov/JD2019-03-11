package by.it.narushevich.project.java.commands;

import by.it.narushevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdCatalog extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        List<String> teatags = dao.teatag.getSelected();
        req.setAttribute("teatags", teatags);
        return null;
    }
}
