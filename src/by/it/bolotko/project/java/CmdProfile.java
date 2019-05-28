package by.it.bolotko.project.java;

import by.it.bolotko.project.java.beans.Car;
import by.it.bolotko.project.java.beans.User;
import by.it.bolotko.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdProfile extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();

        if (session.getAttribute("user") == null) {
            return Actions.LOGIN.command;
        }

        Dao dao = Dao.getDao();
        User user = (User) session.getAttribute("user");
        List<Car> cars = dao.car.getAll("WHERE users_id=" + user.getId());
        req.setAttribute("cars", cars);

        return null;
    }
}
