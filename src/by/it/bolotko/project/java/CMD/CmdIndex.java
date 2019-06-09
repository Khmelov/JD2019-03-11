package by.it.bolotko.project.java.CMD;

import by.it.bolotko.project.java.beans.Car;
import by.it.bolotko.project.java.beans.User;
import by.it.bolotko.project.java.dao.Dao;
import by.it.bolotko.project.java.utils.FormHelper;
import by.it.bolotko.project.java.utils.Tools;
import by.it.bolotko.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdIndex extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        HttpSession session = req.getSession();

        if (FormHelper.isPost(req)) {

            if (FormHelper.contains(req, "details")) {

                if (session.getAttribute("user") == null) {
                    return Actions.LOGIN.command;
                }

//                String login = Validator.getString(req, "login", "[a-zA-Z0-9]{4,30}");
//                String password = Validator.getString(req, "password", "[a-zA-Z0-9@#$%]{4,20}");
//                String email = Validator.getString(req, "email", "[a-z0-9._%+-]+@[a-z0-9.-]+");
//                String phone = Validator.getString(req, "phone", "[0-9+]{13,13}");
//                user.setLogin(login);
//                user.setPassword(password);
//                user.setEmail(email);
//                user.setPhone(phone);
//                dao.user.update(user);
                return null;
            }
        }

        List<Car> cars = dao.car.getAll();
        req.setAttribute("carsSize", cars.size());
        int start = 0;
        if (FormHelper.contains(req, "start"))
            start = Validator.getInt(req, "start");
        String limit = String.format(" LIMIT %s,15", start);
        cars = dao.car.getAll(limit);
        req.setAttribute("cars", cars);
        List<User> users = dao.user.getAll();
        req.setAttribute("users", users);
        return null;
    }
}
