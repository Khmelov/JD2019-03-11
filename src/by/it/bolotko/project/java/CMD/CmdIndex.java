package by.it.bolotko.project.java.CMD;

import by.it.bolotko.project.java.beans.Car;
import by.it.bolotko.project.java.dao.Dao;
import by.it.bolotko.project.java.utils.FormHelper;
import by.it.bolotko.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
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
