package by.it.narushevich.project.java.util;

import by.it.narushevich.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;

public class IsThereUser {

    public static User isUserInSession(HttpServletRequest req) {
        Object objUser = req.getSession().getAttribute("user");
        if (objUser == null)
            return null;
        return (User) objUser;
    }
}
