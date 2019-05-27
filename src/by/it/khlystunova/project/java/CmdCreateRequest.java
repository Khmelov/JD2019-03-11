package by.it.khlystunova.project.java;

import by.it.khlystunova.project.java.beans.Request;
import by.it.khlystunova.project.java.dao.Dao;
import by.it.khlystunova.project.java.util.Validator;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateRequest extends  Cmd{
    @Override
    Cmd execute(HttpServletRequest req) throws Exception {
        if(req.getMethod().equals("POST")) {
            Request request = new Request();
            request.setId(0);
            request.setUsers_ID(1);//todo
            request.setContact(Validator.getString(req,"Contact"));
            request.setDeliveryAdress(Validator.getString(req,"Delivery address"));
            request.setCoffemachines_ID(1);//todo
            Dao dao = Dao.getDao();
            if(dao.request.create(request)) {
                return Actions.INDEX.command;
            }
        }
        return null;
    }
}
