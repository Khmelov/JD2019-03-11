package by.it.bolotko.project.java.CMD;

import by.it.bolotko.project.java.beans.Car;
import by.it.bolotko.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        List<Car> cars = dao.car.getAll();
        req.setAttribute("cars", cars);
        return null;
    }
}
