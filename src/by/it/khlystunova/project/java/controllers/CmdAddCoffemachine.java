package by.it.khlystunova.project.java.controllers;

import by.it.khlystunova.project.java.beans.Coffemachine;
import by.it.khlystunova.project.java.beans.User;
import by.it.khlystunova.project.java.dao.Dao;
import by.it.khlystunova.project.java.exceptions.WebsiteException;
import by.it.khlystunova.project.java.util.Validator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


class CmdAddCoffemachine extends Cmd{

    @Override
    Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null)return Actions.LOGIN.command;
        if(user.getRoles_ID() == 1) {
            if (req.getMethod().equals("POST")) {
                Coffemachine coffemachine = new Coffemachine();
                coffemachine.setId(0);
                coffemachine.setName(Validator.getString(req, "Name"));
                coffemachine.setFirm(Validator.getString(req, "Firm"));
                coffemachine.setPower(Validator.getString(req, "Power"));
                coffemachine.setSize(Validator.getString(req, "Size"));
                coffemachine.setWeight(Validator.getDouble(req, "Weight"));
                coffemachine.setWaterContainer(Validator.getString(req, "WaterContainer"));
                coffemachine.setBeansContainer(Validator.getString(req, "BeansContainer"));
                coffemachine.setColor(Validator.getString(req, "Color"));
                coffemachine.setPrice(Validator.getDouble(req, "Price"));
                if (dao.coffemachine.create(coffemachine)) {
                    return Actions.INDEX.command;
                }
            }
        }else throw new WebsiteException("to access this feature, you must have administrator rights");
            return null;
    }

}
