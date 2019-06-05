package by.it.pileiko.project.java.utils;

import javax.servlet.http.HttpServletRequest;

public class FormHelper {
    public static boolean isPost(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase("POST");
    }
}
