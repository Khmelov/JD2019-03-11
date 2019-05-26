package by.it.bolotko.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

class CommandSignUp implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Actions.SIGNUP.jsp;
    }
}