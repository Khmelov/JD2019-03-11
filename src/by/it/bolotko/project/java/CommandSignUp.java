package by.it.bolotko.project.java;

import by.it.bolotko.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CommandSignUp implements ActionCommand {
    @Override
    public ActionCommand execute(HttpServletRequest request) {

        if (request.getMethod().equalsIgnoreCase("POST")){
            User user = new User();
            user.setLogin(request.getParameter("login"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            user.setPhone(request.getParameter("phone"));
            user.setRoles_id(2);


        }

        return null;
    }
}