package by.it.khlystunova.project.java.controllers;


import by.it.khlystunova.project.java.beans.Request;
import by.it.khlystunova.project.java.beans.User;
import by.it.khlystunova.project.java.dao.Dao;
import by.it.khlystunova.project.java.exceptions.WebsiteException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdShowAllRequests extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws SQLException {
        Dao dao = Dao.getDao();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null)return Actions.LOGIN.command;
        if(user.getRoles_ID()==1){
            List<Request> all = dao.request.getAll();
            req.setAttribute("requests",all);
        }else throw new WebsiteException("to access this feature, you must have administrator rights");
        return null;
    }
}
