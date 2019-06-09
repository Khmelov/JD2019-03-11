package by.it.khlystunova.project.java.controllers;

import by.it.khlystunova.project.java.beans.Coffemachine;
import by.it.khlystunova.project.java.beans.User;
import by.it.khlystunova.project.java.dao.Dao;
import by.it.khlystunova.project.java.exceptions.WebsiteException;
import by.it.khlystunova.project.java.util.FormHelper;
import by.it.khlystunova.project.java.util.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdEditCoffemachines extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws SQLException {
        Dao dao = Dao.getDao();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null)return Actions.LOGIN.command;
        if(user.getRoles_ID()==1){
            if (FormHelper.isPost(req)) {

                if (FormHelper.contains(req,"update")){
                    Coffemachine newCoffemachine = new Coffemachine(
                            Validator.getLong(req,"id"),
                            Validator.getString(req, "name"),
                            Validator.getString(req, "firm"),
                            Validator.getString(req, "power"),
                            Validator.getString(req,"size"),
                            Validator.getDouble(req,"weight"),
                            Validator.getString(req,"waterContainer"),
                            Validator.getString(req,"beansContainer"),
                            Validator.getString(req,"color"),
                            Validator.getDouble(req,"price")
                    );
                    dao.coffemachine.update(newCoffemachine);
                    return this;
                }
                if (FormHelper.contains(req,"delete")){
                    Coffemachine coffemachineDelete = new Coffemachine(
                            Validator.getLong(req,"id"),
                            Validator.getString(req, "name"),
                            Validator.getString(req, "firm"),
                            Validator.getString(req, "power"),
                            Validator.getString(req,"size"),
                            Validator.getDouble(req,"weight"),
                            Validator.getString(req,"waterContainer"),
                            Validator.getString(req,"beansContainer"),
                            Validator.getString(req,"color"),
                            Validator.getDouble(req,"price")
                    );
                    dao.coffemachine.delete(coffemachineDelete);
                    return this;
                }

            }
        }else throw new WebsiteException("to access this feature, you must have administrator rights");

        //show
        List<Coffemachine> coffemachineAll = dao.coffemachine.getAll();
        req.setAttribute("coffemachines",coffemachineAll);

        return null;
    }
}
