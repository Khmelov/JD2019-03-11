package by.it.khlystunova.project.java.util;

import javax.servlet.http.HttpServletRequest;

public class FormHelper {
    public static boolean isPost(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase("POST");
    }

    public static boolean contains(HttpServletRequest req, String name) {
        return req.getParameter(name)!=null;
    }


}
