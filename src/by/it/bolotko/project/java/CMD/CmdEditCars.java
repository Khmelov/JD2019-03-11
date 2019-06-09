package by.it.bolotko.project.java.CMD;

import by.it.bolotko.project.java.beans.Car;
import by.it.bolotko.project.java.beans.User;
import by.it.bolotko.project.java.dao.Dao;
import by.it.bolotko.project.java.utils.FormHelper;
import by.it.bolotko.project.java.utils.Tools;
import by.it.bolotko.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdEditCars extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        User user = Tools.findUserInSession(req);
        if (FormHelper.isPost(req)) {

            if (FormHelper.contains(req, "update")) {
                Car car = new Car(
                        Validator.getLong(req, "id"),
                        Validator.getString(req, "car_type", "[A-Za-zа-яА-Я]+"),
                        Validator.getString(req, "fuel_type", "[A-Za-zа-яА-Я]+"),
                        Validator.getString(req, "mark", "[а-яА-ЯA-Za-z0-9]+"),
                        Validator.getString(req, "model", "[а-яА-ЯA-Za-z0-9]+"),
                        Validator.getString(req, "price", "[0-9]+"),
                        Validator.getString(req, "year_of_issue", "[0-9]{4,4}"),
                        Validator.getLong(req, "users_id")
                );
                dao.car.update(car);
                return this;
            }

            if (FormHelper.contains(req, "delete")) {
                Car car = new Car(
                        Validator.getLong(req, "id"),
                        Validator.getString(req, "car_type", "[A-Za-zа-яА-Я]+"),
                        Validator.getString(req, "fuel_type", "[A-Za-zа-яА-Я]+"),
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

        List<User> users = dao.user.getAll();
        req.setAttribute("users", users);
        List<Car> cars = dao.car.getAll();
        req.setAttribute("carsSize", cars.size());
        int start = 0;
        if (FormHelper.contains(req, "start"))
            start = Validator.getInt(req, "start");
        String limit = String.format(" LIMIT %s,10", start);
        cars = dao.car.getAll(limit);
        req.setAttribute("cars", cars);

        return null;
    }
}
