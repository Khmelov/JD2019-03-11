package by.it.bolotko.jd03_04.java;

import javax.servlet.http.HttpServletRequest;
public interface ActionCommand {
    String execute(HttpServletRequest request);
}