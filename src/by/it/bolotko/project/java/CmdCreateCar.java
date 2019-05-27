package by.it.bolotko.project.java;

import by.it.bolotko.project.java.beans.Car;
import by.it.bolotko.project.java.dao.Dao;
import by.it.bolotko.project.java.utils.FormHelper;
import by.it.bolotko.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateCar extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        if (FormHelper.isPost(req)) {
            Car car = new Car(
                    0,
                    Validator.getString(req, "car_type"),
                    Validator.getString(req, "fuel_type"),
                    Validator.getString(req, "mark", "[A-Za-z0-9]+"),
                    Validator.getString(req, "model", "[A-Za-z0-9]+"),
                    Validator.getString(req, "price", "[0-9]+"),
                    Validator.getString(req, "year_of_issue", "[0-9]{4,4}"),
                    2
            );

            Dao dao = Dao.getDao();
            if (dao.car.create(car)) {
                return Actions.INDEX.command;
            }
        }
        return null;
    }
}
