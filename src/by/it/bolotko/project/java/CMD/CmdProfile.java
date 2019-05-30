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
                String login = Validator.getString(req, "login", "[a-zA-Z0-9]{4,30}");
                String password = Validator.getString(req, "password", "[a-zA-Z0-9@#$%]{4,20}");
                String email = Validator.getString(req, "email", "[a-z0-9._%+-]+@[a-z0-9.-]+");
                String phone = Validator.getString(req, "phone", "[0-9+]{13,13}");
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

            if (FormHelper.contains(req, "edit")) {
                Car car = new Car(
                        Validator.getLong(req, "id"),
                        Validator.getString(req, "car_type", "[A-Za-z]+"),
                        Validator.getString(req, "fuel_type", "[A-Za-z]+"),
                        Validator.getString(req, "mark", "[а-яА-ЯA-Za-z0-9]+"),
                        Validator.getString(req, "model", "[а-яА-ЯA-Za-z0-9]+"),
                        Validator.getString(req, "price", "[0-9]+"),
                        Validator.getString(req, "year_of_issue", "[0-9]{4,4}"),
                        Validator.getLong(req, "users_id")
                );
                dao.car.update(car);
                return this;
            }

            if (FormHelper.contains(req, "deletecar")) {
                Car car = new Car(
                        Validator.getLong(req, "id"),
                        Validator.getString(req, "car_type", "[A-Za-z]+"),
                        Validator.getString(req, "fuel_type", "[A-Za-z]+"),
                        Validator.getString(req, "mark", "[а-яА-ЯA-Za-z0-9]+"),
                        Validator.getString(req, "model", "[а-яА-ЯA-Za-z0-9]+"),
                        Validator.getString(req, "price", "[0-9]+"),
                        Validator.getString(req, "year_of_issue", "[0-9]{4,4}"),
                        Validator.getLong(req, "users_id")
                );
                dao.car.delete(car);
                return this;
            }
        }





        List<Car> cars = dao.car.getAll("WHERE users_id=" + user.getId());
        req.setAttribute("cars", cars);

        return null;
    }
}
