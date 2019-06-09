package by.it.khlystunova.project.java.controllers;

import by.it.khlystunova.project.java.beans.User;
import by.it.khlystunova.project.java.dao.Dao;
import by.it.khlystunova.project.java.exceptions.WebsiteException;
import by.it.khlystunova.project.java.util.FormHelper;
import by.it.khlystunova.project.java.util.Patterns;
import by.it.khlystunova.project.java.util.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdAditUsers extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws SQLException {
        Dao dao = Dao.getDao();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null)return Actions.LOGIN.command;
        if(user.getRoles_ID()==1){
            if (FormHelper.isPost(req)) {

                if (FormHelper.contains(req,"update")){
                    User newUser = new User(
                            Validator.getLong(req,"id"),
                            Validator.getString(req, "login", Patterns.LOGIN),
                            Validator.getString(req, "password",Patterns.PASSWORD),
                            Validator.getString(req, "email",Patterns.EMAIL),
                            Validator.getLong(req,"roles_ID")
                    );
                    dao.user.update(newUser);
                    return this;
                }
                if (FormHelper.contains(req,"delete")){
                    User user3 = new User(
                            Validator.getLong(req,"id"),
                            Validator.getString(req, "login", Patterns.LOGIN),
                            Validator.getString(req, "password",Patterns.PASSWORD),
                            Validator.getString(req, "email",Patterns.EMAIL),
                            Validator.getLong(req,"roles_ID")
                    );
                    dao.user.delete(user3);
                    return this;
                }

            }
        }else throw new WebsiteException("to access this feature, you must have administrator rights");

        //show
        List<User> users = dao.user.getAll();
        req.setAttribute("users",users);

        return null;
    }
}
