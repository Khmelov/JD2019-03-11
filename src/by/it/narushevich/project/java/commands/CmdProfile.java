package by.it.narushevich.project.java.commands;

import by.it.narushevich.project.java.beans.TeatagString;
import by.it.narushevich.project.java.beans.User;
import by.it.narushevich.project.java.dao.Dao;
import by.it.narushevich.project.java.util.FormHelper;
import by.it.narushevich.project.java.util.IsThereUser;
import by.it.narushevich.project.java.util.Patterns;
import by.it.narushevich.project.java.util.Validator;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

import static org.apache.commons.codec.digest.DigestUtils.md5Hex;

public class CmdProfile extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req) throws SQLException {

        Dao dao = Dao.getDao();
        User user = IsThereUser.isUserInSession(req);

        if (user == null) {
            return Actions.LOGIN.command;
        }

        if (FormHelper.isPost(req)) {

            if (FormHelper.pressedButton(req, "update")) {
                String login = Validator.getString(req, "login", Patterns.LOGIN);
                String password = md5Hex(Validator.getString(req, "password", Patterns.PASSWORD));
                String email = Validator.getString(req, "email", Patterns.EMAIL);
                user.setLogin(login);
                user.setPassword(password);
                user.setEmail(email);
                dao.user.update(user);
                return this;
            }

            if (FormHelper.pressedButton(req, "delete")) {
                dao.user.delete(user);
                return Actions.INDEX.command;
            }

            if (FormHelper.pressedButton(req,"create")) {
                return Actions.CREATETAG.command;
            }
        }

        List<TeatagString> usersTeatags = Dao.getDao().teatag.getSelected(user.getId());
        req.setAttribute("usersTeatags", usersTeatags);

        return null;
    }
}
