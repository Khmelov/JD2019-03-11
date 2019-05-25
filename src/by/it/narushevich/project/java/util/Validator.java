package by.it.narushevich.project.java.util;

import by.it.narushevich.project.java.exceptions.SiteException;

import javax.servlet.http.HttpServletRequest;

public class Validator {

    public static String getString (HttpServletRequest req, String name, String pattern) {
        String value = req.getParameter(name);
        if (value.matches(pattern))
            return  value;
        return value;
    }

    public static int getInt(HttpServletRequest req, String name) {
        try {
            return Integer.parseInt(req.getParameter(name));
        } catch (Exception e) {
            throw new SiteException();
        }
    }
}
