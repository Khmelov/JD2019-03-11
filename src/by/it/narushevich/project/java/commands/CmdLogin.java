package by.it.narushevich.project.java.commands;

import by.it.narushevich.project.java.beans.User;
import by.it.narushevich.project.java.dao.Dao;
import by.it.narushevich.project.java.util.FormHelper;
import by.it.narushevich.project.java.util.Patterns;
import by.it.narushevich.project.java.util.Validator;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;


public class CmdLogin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws SQLException {

        if (FormHelper.isPost(req)) {
            String login = Validator.getString(req, "login", Patterns.LOGIN);

            String where = String.format("WHERE login='%s'", login);
            List<User> users = Dao.getDao().user.getAll(where);
            Iterator<User> iterator = users.iterator();
            if (!iterator.hasNext()) {
                return Actions.SIGNUP.command;
            }
            User user = iterator.next();
            String passwordForm = DigestUtils.md5Hex(
                    Validator.getString(req, "password", Patterns.PASSWORD));
            String passwordBase = user.getPassword();
            if (passwordBase.equals(passwordForm)) {
                HttpSession session = req.getSession(true);
                session.setMaxInactiveInterval(300);
                session.setAttribute("user", user);
                return Actions.PROFILE.command;
            }
        }
        return Actions.ERROR.command;
    }
}
