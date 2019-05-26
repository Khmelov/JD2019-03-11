package by.it.narushevich.project.java;

import by.it.narushevich.project.java.beans.User;
import by.it.narushevich.project.java.dao.Dao;
import by.it.narushevich.project.java.util.FormHelper;
import by.it.narushevich.project.java.util.Patterns;
import by.it.narushevich.project.java.util.Validator;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CmdLogin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws SQLException {
        if (FormHelper.isPost(req)){
            String login = Validator.getString(req, "login", Patterns.LOGIN);
            String password = Validator.getString(req, "password", Patterns.PASSWORD);
            String where = String.format("WHERE login='%s' and password='%s' ",login,password);
            List<User> users = Dao.getDao().user.getAll(where);
            if (users.size()>0)
                return Actions.PROFILE.command;
        }
        return null;
    }
}
