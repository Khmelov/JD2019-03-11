package by.it.khlystunova.project.java;



import by.it.khlystunova.project.java.beans.Coffemachine;
import by.it.khlystunova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        List<Coffemachine> coffemachines = dao.coffemachine.getAll();
        req.setAttribute("coffemachines",coffemachines);
        return null;
    }
}
