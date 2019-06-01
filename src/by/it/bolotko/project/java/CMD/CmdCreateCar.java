package by.it.bolotko.project.java.CMD;

import by.it.bolotko.project.java.beans.Car;
import by.it.bolotko.project.java.beans.User;
import by.it.bolotko.project.java.dao.Dao;
import by.it.bolotko.project.java.utils.FormHelper;
import by.it.bolotko.project.java.utils.Tools;
import by.it.bolotko.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdCreateCar extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        User user = Tools.findUserInSession(req);
        if (user == null) {
            return Actions.LOGIN.command;
        }

        if (FormHelper.isPost(req)) {
            Car car = new Car(
                    0,
                    Validator.getString(req, "car_type", "[A-Za-zа-яА-Я]+"),
                    Validator.getString(req, "fuel_type", "[A-Za-zа-яА-Я]+"),
                    Validator.getString(req, "mark", "[а-яА-ЯA-Za-z0-9]+"),
                    Validator.getString(req, "model", "[а-яА-ЯA-Za-z0-9]+"),
                    Validator.getString(req, "price", "[0-9]+"),
                    Validator.getString(req, "year_of_issue", "[0-9]{4,4}"),
                    user.getId()
            );

            Dao.getDao().car.create(car);
//            Tools.CreateImage(req, "img" + car.getId());
            return Actions.PROFILE.command;
        }
        return null;
    }
}
