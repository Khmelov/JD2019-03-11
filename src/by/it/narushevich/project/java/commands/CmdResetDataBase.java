package by.it.narushevich.project.java.commands;

import by.it.narushevich.project.java.dao.Dao;
import javax.servlet.http.HttpServletRequest;

public class CmdResetDataBase extends Cmd{
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao.resetDataBase();
        return null;
    }
}
