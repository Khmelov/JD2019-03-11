package by.it.bolotko.project.java.utils;

import by.it.bolotko.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;

public class Tools {
    public static User findUserInSession(HttpServletRequest req) {
        Object oUser = req.getSession().getAttribute("user");
        if (oUser == null)
            return null;
        return (User) oUser;
    }

}
