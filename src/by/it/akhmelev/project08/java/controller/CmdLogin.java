package by.it.akhmelev.project08.java.controller;

import by.it.akhmelev.project08.java.beans.User;
import by.it.akhmelev.project08.java.dao.Dao;
import by.it.akhmelev.project08.java.utils.FormHelper;
import by.it.akhmelev.project08.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        if (FormHelper.isPost(req)){
            String login = Validator.getString(req, "login");
            String password = Validator.getString(req, "password");
            String where=String.format(" WHERE Login='%s' and Password='%s'",login,password);
            List<User> users = Dao.getDao().user.getAll(where);
            if (users.size()>0){
                HttpSession session = req.getSession();
                User user = users.get(0);
                session.setAttribute("user",user);
                return Actions.PROFILE.command;
            }
        }
        return null;
    }
}
