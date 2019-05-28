package by.it.bildziuh.project.java;

import by.it.bildziuh.project.java.beans.User;
import by.it.bildziuh.project.java.dao.Dao;
import by.it.bildziuh.project.java.utils.FormHelper;
import by.it.bildziuh.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
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
                return Actions.INDEX.command;
            }
        }
        return null;
    }
}
