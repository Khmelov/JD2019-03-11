package by.it.khlystunova.project.java;

import javax.servlet.http.HttpServletRequest;

public abstract class Cmd {

    abstract Cmd execute(HttpServletRequest req) throws Exception;

    @Override
    public String toString() {
        String nameCommand = this
                .getClass()
                .getSimpleName()
                .replace("Cmd", "")
                .toLowerCase();
        return nameCommand;
    }
    public String getJsp(){
        return "/"+this.toString()+".jsp";
    }
}