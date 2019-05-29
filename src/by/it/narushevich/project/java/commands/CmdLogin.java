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


public class CmdLogin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) {

        if (FormHelper.isPost(req)){
            try {
                String login = Validator.getString(req, "login", Patterns.LOGIN);

                String where = String.format("WHERE login='%s'",login);
                User user = Dao.getDao().user.getAll(where).get(0);

                String passwordForm = DigestUtils.md5Hex(
                        Validator.getString(req, "password", Patterns.PASSWORD));
                String passwordBase = user.getPassword();
                if (passwordBase.equals(passwordForm)){
                    HttpSession session = req.getSession(true);
                    session.setAttribute("user",user);
                    return Actions.PROFILE.command;
                }
            } catch (SQLException e) {
                System.out.println("Wrong data, repeat entering");
            }

        }
        return Actions.LOGIN.command;
    }
}
