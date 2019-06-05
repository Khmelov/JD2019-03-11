package by.it.pileiko.project.java.controller;

import by.it.pileiko.project.java.beans.Car;
import by.it.pileiko.project.java.beans.User;
import by.it.pileiko.project.java.dao.Dao;
import by.it.pileiko.project.java.utils.FormHelper;
import by.it.pileiko.project.java.utils.Tools;
import by.it.pileiko.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateCar extends Cmd {


    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        User user= Tools.findUserInSession(req);
        if (user==null)
            return Actions.LOGIN.command;
        if (FormHelper.isPost(req)){
            Car car = new Car (
                    0,
                    Validator.getString(req, "brand", "[а-яА-Яa-zA-Z0-9._\\s']+"),
                    Validator.getString(req, "model", "[а-яА-Яa-zA-Z0-9._\\s']+"),
                    Validator.getInt(req, "engine"),
                    Validator.getInt(req, "price"),
                    Validator.getInt(req, "year"),
                    Validator.getString(req, "description","[а-яА-Яa-zA-Z0-9._\\s']+"),
                    user.getId()
            );
            Dao.getDao().car.create(car);
            Tools.createImage(req,"img"+car.getId());
            return Actions.PROFILE.command;

        }

        return null;
    }
}
