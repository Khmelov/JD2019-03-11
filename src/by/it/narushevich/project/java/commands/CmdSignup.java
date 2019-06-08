package by.it.narushevich.project.java.commands;

import by.it.narushevich.project.java.beans.User;
import by.it.narushevich.project.java.dao.Dao;
import by.it.narushevich.project.java.exceptions.SiteException;
import by.it.narushevich.project.java.util.FormHelper;
import by.it.narushevich.project.java.util.Patterns;
import by.it.narushevich.project.java.util.Validator;

import javax.servlet.http.HttpServletRequest;

import java.sql.SQLException;

import static org.apache.commons.codec.digest.DigestUtils.md5Hex;

public class CmdSignup extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req) {

        Dao dao = Dao.getDao();

        if (FormHelper.isPost(req)) {
            User user = new User(0,
                    Validator.getString(req, "login", Patterns.LOGIN),
                    md5Hex(Validator.getString(req, "password", Patterns.PASSWORD)),
                    Validator.getString(req, "email", Patterns.EMAIL),
                    2);
            try {
                if (dao.user.create(user))
                    return Actions.PROFILE.command;
            }
            catch (SQLException e) {
                throw new SiteException("This login is busy");
            }
        }
        return null;
    }
}
