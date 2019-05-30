package by.it.narushevich.project.java.commands;

import by.it.narushevich.project.java.dao.InitDataBase;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CmdResetDataBase extends Cmd{
    @Override
    public Cmd execute(HttpServletRequest req) throws SQLException {
        InitDataBase.main(new String[] {});
        return Actions.INDEX.command;
    }
}
