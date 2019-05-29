package by.it.narushevich.project.java.commands;

import by.it.narushevich.project.java.beans.User;
import by.it.narushevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CmdEditUsers extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws SQLException {
        Dao dao = Dao.getDao();
        List<User> users = dao.user.getAll();

        return Actions.EDITUSERS.command;
    }
}
