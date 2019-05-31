package by.it.bolotko.project.java.CMD;

import by.it.bolotko.project.java.beans.Car;
import by.it.bolotko.project.java.beans.User;
import by.it.bolotko.project.java.dao.Dao;
import by.it.bolotko.project.java.utils.FormHelper;
import by.it.bolotko.project.java.utils.Tools;
import by.it.bolotko.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdProfile extends Cmd {
    @Override
   public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        User user = Tools.findUserInSession(req);

        if (user == null) {
            return Actions.LOGIN.command;
        }

        if (FormHelper.isPost(req)) {

            if (FormHelper.contains(req, "update")) {
                String login = Validator.getString(req, "login", "[a-zA-Z0-9]{4,}");
                String password = Validator.getString(req, "password");
                String email = Validator.getString(req, "email");
                String phone = Validator.getString(req, "phone");
                user.setLogin(login);
                user.setPassword(password);
                user.setEmail(email);
                user.setPhone(phone);
                dao.user.update(user);
                return this;
            }

            if (FormHelper.contains(req, "logout")) {
                return Actions.LOGOUT.command;
            }
        }





        List<Car> cars = dao.car.getAll("WHERE users_id=" + user.getId());
        req.setAttribute("cars", cars);

        return null;
    }
}
