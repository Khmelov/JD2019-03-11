package by.it.khlystunova.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public abstract class Cmd {

    abstract Cmd execute(HttpServletRequest req) throws Exception;

    @Override
    public String toString() {
        return "Cmd{}";
    }
    public String getJsp(){
        return "/"+this.toString()+".jsp";
    }
}