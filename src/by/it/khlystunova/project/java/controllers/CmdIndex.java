package by.it.khlystunova.project.java.controllers;



import by.it.khlystunova.project.java.beans.Coffemachine;
import by.it.khlystunova.project.java.dao.Dao;
import by.it.khlystunova.project.java.util.FormHelper;
import by.it.khlystunova.project.java.util.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        List<Coffemachine> coffemachines = dao.coffemachine.getAll();
        req.setAttribute("coffemachinesSize", coffemachines.size());
        int start = 0;
        if (FormHelper.contains(req,"start"))
            start = Validator.getInt(req,"start");
        String limit = String.format(" LIMIT %s,10",start);
        coffemachines = dao.coffemachine.getAll(limit);
        req.setAttribute("coffemachines",coffemachines);
        return null;
    }
}
