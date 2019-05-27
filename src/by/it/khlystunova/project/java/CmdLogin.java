package by.it.khlystunova.project.java;

import by.it.khlystunova.project.java.Cmd;
import by.it.khlystunova.project.java.beans.User;
import by.it.khlystunova.project.java.dao.Dao;
import by.it.khlystunova.project.java.exceptions.WebsiteException;
import by.it.khlystunova.project.java.util.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdLogin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        if(req.getMethod().equals("POST")){
            String login = Validator.getString(req, "Login");
            String password = Validator.getString(req, "Password");
            String where=String.format(" WHERE Login='%s' and Password='%s'",login,password);
            List<User> users = Dao.getDao().user.getAll(where);
            if (users.size()>0){
                return Actions.CREATEREQUEST.command;
            }
            else throw new WebsiteException("no such user");
        }
        return null;
    }
}
