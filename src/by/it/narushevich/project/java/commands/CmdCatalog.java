package by.it.narushevich.project.java.commands;

import by.it.narushevich.project.java.beans.TeatagString;
import by.it.narushevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CmdCatalog extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req) throws SQLException {
        Dao dao = Dao.getDao();
        List<TeatagString> teatags = dao.teatag.getSelected();
        req.setAttribute("teatags", teatags);
        return null;
    }
}
