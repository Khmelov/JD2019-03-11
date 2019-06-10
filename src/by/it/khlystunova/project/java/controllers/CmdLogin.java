package by.it.khlystunova.project.java.controllers;
import by.it.khlystunova.project.java.beans.User;
import by.it.khlystunova.project.java.dao.Dao;
import by.it.khlystunova.project.java.exceptions.WebsiteException;
import by.it.khlystunova.project.java.util.Patterns;
import by.it.khlystunova.project.java.util.Validator;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        if(req.getMethod().equals("POST")){
            String login = Validator.getString(req, "Login", Patterns.LOGIN);
            String password = Validator.getString(req, "Password",Patterns.PASSWORD);
            String where=String.format(" WHERE Login='%s' and Password='%s'",login,password);
            List<User> users = Dao.getDao().user.getAll(where);
            if (users.size()>0){
                HttpSession session = req.getSession();
                //session.setMaxInactiveInterval(30);
                User user = users.get(0);
                session.setAttribute("user",user);

                //Cookie cookie = new Cookie("Login","Login");
                //cookie.setMaxAge(60);
                //resp.addCookie(cookie);

                return Actions.PROFILE.command;
            }
            else throw new WebsiteException("no such user");
        }
        return null;
    }
}
