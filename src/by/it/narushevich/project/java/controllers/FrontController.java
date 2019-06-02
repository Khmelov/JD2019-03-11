package by.it.narushevich.project.java.controllers;

import by.it.narushevich.project.java.beans.Role;
import by.it.narushevich.project.java.commands.Actions;
import by.it.narushevich.project.java.commands.Cmd;
import by.it.narushevich.project.java.dao.Dao;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class FrontController extends HttpServlet {

    @Override
    public void init() {
        Dao dao = Dao.getDao();
        List<Role> roles = null;
        try {
            roles = dao.role.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("roles",roles);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            process(req, resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        try {
            process(req, resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Cmd cmd = Actions.defineCommand(req);
            Cmd next = cmd.execute(req);

            if (next==null){
                getServletContext()
                        .getRequestDispatcher(cmd.getJsp())
                        .forward(req, resp);
            }
            else {
                resp.sendRedirect("do?command="+next.toString());
            }

        } catch (Exception e) {
            getServletContext().setAttribute("Error", getErrorTxt(e));
            resp.sendRedirect("do?command=Error");
        }
    }

    public static String getErrorTxt(Exception e) {
        StringBuilder error = new StringBuilder("<b>"+e.toString()+"</b><br><br>");
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            if (element.toString().contains(".HttpServlet.")){
                break;
            }
            error.append(element.toString()).append("<br>\n");
        }
        return error.toString();
    }
}
