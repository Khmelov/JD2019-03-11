package by.it.khlystunova.project.java.controllers;

import by.it.khlystunova.project.java.beans.Coffemachine;
import by.it.khlystunova.project.java.beans.Request;
import by.it.khlystunova.project.java.beans.User;
import by.it.khlystunova.project.java.dao.Dao;
import by.it.khlystunova.project.java.util.Patterns;
import by.it.khlystunova.project.java.util.Validator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

class CmdCreateRequest extends  Cmd{
    @Override
    Cmd execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(req.getMethod().equals("POST")) {
            Dao dao = Dao.getDao();
            Request request = new Request();
            request.setId(0);
            request.setUsers_ID(user.getId());
            request.setContact(Validator.getString(req,"Contact", Patterns.CONTACT));
            request.setDeliveryAdress(Validator.getString(req,"Delivery address",Patterns.ADDRESS));
            request.setCoffemachines_ID(getCoffemaсhines_ID(req));
            if(dao.request.create(request)) {
                return Actions.PROFILE.command;
            }
        }
        return null;
    }

    private long getCoffemaсhines_ID(HttpServletRequest req) throws SQLException {
        Dao dao = Dao.getDao();
        String coffemachine = Validator.getString(req,"Coffemachine").trim();
        List<Coffemachine> coffemachineAll = dao.coffemachine.getAll();
        for (Coffemachine next : coffemachineAll) {
            String name = next.getName();
            if (name.equals(coffemachine)) {
                return (int)next.getId();
            }
        }
        return 0;
    }


}
