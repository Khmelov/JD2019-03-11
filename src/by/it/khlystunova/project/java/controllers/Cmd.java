package by.it.khlystunova.project.java.controllers;

import javax.servlet.http.HttpServletRequest;

public abstract class Cmd {

    abstract Cmd execute(HttpServletRequest req) throws Exception;

    @Override
    public String toString() {
        return this
                .getClass()
                .getSimpleName()
                .replace("Cmd", "")
                .toLowerCase();
    }
    String getJsp(){
        return "/"+this.toString()+".jsp";
    }
}