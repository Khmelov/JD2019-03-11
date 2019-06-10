package by.it.vasiliuk.project.java.utils;

import by.it.vasiliuk.project.java.beans.Task;
import by.it.vasiliuk.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;

public class Tools {
    public static User findUserInSession(HttpServletRequest req) {
        Object oUser = req.getSession().getAttribute("user");
        if (oUser == null)
            return null;
        return (User) oUser;
    }

    public static Task findtaskInSession(HttpServletRequest req) {
        Object otask = req.getSession().getAttribute("task");
        if (otask == null)
            return null;
        return (Task) otask;
    }

}
