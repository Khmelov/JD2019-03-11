package by.it.khlystunova.project.java;

import by.it.khlystunova.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        if(req.getMethod().equals("POST")) {
            User user = new User();
            user.setLogin(req.getParameter("login"));
            user.setEmail(req.getParameter("email"));
            user.setPassword(req.getParameter("password"));
            user.setRoles_ID(2);
            return Actions.LOGIN.command;
        }
        return null;
    }

}
