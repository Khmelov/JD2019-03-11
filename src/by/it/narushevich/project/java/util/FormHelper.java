package by.it.narushevich.project.java.util;

import javax.servlet.http.HttpServletRequest;

public class FormHelper {

    public static boolean isPost(HttpServletRequest req) {

        return req.getMethod().equalsIgnoreCase("POST");
    }
}
