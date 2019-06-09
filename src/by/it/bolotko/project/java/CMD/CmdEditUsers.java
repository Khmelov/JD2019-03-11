package by.it.bolotko.project.java.CMD;

import by.it.bolotko.project.java.beans.User;
import by.it.bolotko.project.java.dao.Dao;
import by.it.bolotko.project.java.utils.FormHelper;
import by.it.bolotko.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdEditUsers extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        if (FormHelper.isPost(req)) {

            if (FormHelper.contains(req, "update")) {
                User user = new User(
                        Validator.getLong(req, "id"),
                        Validator.getString(req, "login", "[a-zA-Z0-9]{4,30}"),
                        Validator.getString(req, "password", "[a-zA-Z0-9@#$%]{4,20}"),
                        Validator.getString(req, "email", "[a-z0-9._%+-]+@[a-z0-9.-]+"),
                        Validator.getString(req, "phone", "[0-9+]{13,13}"),
                        Validator.getLong(req, "roles_id")
                );
                dao.user.update(user);
                return this;
            }

            if (FormHelper.contains(req, "delete")) {
                User user = new User(
                        Validator.getLong(req, "id"),
                        Validator.getString(req, "login", "[a-zA-Z0-9]{4,30}"),
                        Validator.getString(req, "password", "[a-zA-Z0-9@#$%]{4,20}"),
                        Validator.getString(req, "email", "[a-z0-9._%+-]+@[a-z0-9.-]+"),
                        Validator.getString(req, "phone", "[0-9+]{13,13}"),
                        Validator.getLong(req, "roles_id")
                );
                dao.user.delete(user);
                return this;
            }
        }

        List<User> users = dao.user.getAll();
        req.setAttribute("usersSize", users.size());
        int start = 0;
        if (FormHelper.contains(req, "start"))
            start = Validator.getInt(req, "start");
        String limit = String.format(" LIMIT %s,10", start);
        users = dao.user.getAll(limit);
        req.setAttribute("users", users);
        return null;
    }
}
