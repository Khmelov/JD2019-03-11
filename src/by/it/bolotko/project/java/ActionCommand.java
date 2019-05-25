package by.it.bolotko.project.java;

import javax.servlet.http.HttpServletRequest;
public interface ActionCommand {
    ActionCommand execute(HttpServletRequest request);
}