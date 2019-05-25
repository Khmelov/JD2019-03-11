package by.it.khlystunova.project.java.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validator {
    public static String getString(HttpServletRequest req, String name, String pattern) throws Exception {
    String value = req.getParameter(name);
    if(value.matches(pattern))
        return value;
    throw new Exception("Incorrect name" + name);
    }
}
