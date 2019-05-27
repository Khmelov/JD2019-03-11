package by.it.narushevich.project.java.commands;

import javax.servlet.http.HttpServletRequest;

public abstract class Cmd {
    public abstract Cmd execute(HttpServletRequest req) throws Exception;

    @Override
    public String toString() {
        return this
                .getClass()
                .getSimpleName()
                .toLowerCase()
                .replace("cmd","");
    }

    public String getJsp(){
        return "/"+this.toString()+".jsp";
    }
}
