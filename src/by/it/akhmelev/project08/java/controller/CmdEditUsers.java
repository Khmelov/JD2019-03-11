package by.it.akhmelev.project08.java.controller;

import by.it.akhmelev.project08.java.beans.User;
import by.it.akhmelev.project08.java.dao.Dao;
import by.it.akhmelev.project08.java.utils.FormHelper;
import by.it.akhmelev.project08.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdEditUsers extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        if (FormHelper.isPost(req)){

            if (FormHelper.contains(req,"update")){
                User user = new User(
                        Validator.getLong(req,"id"),
                        Validator.getString(req, "login", "[a-zA-Z0-9]{4,}"),
                        Validator.getString(req, "password"),
                        Validator.getString(req, "email"),
                        Validator.getLong(req,"roles_id")
                );
                dao.user.update(user);
                return this;
            }

            if (FormHelper.contains(req,"delete")){
                User user = new User(
                        Validator.getLong(req,"id"),
                        Validator.getString(req, "login", "[a-zA-Z0-9]{4,}"),
                        Validator.getString(req, "password"),
                        Validator.getString(req, "email"),
                        Validator.getLong(req,"roles_id")
                );
                dao.user.delete(user);
                return this;
            }
        }



        //show
        List<User> users = dao.user.getAll();
        req.setAttribute("users",users);
        //roles - see FrontController init()
        return null;
    }
}
