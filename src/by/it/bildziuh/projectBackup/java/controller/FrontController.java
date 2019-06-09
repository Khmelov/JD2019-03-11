package by.it.bildziuh.projectBackup.java.controller;

import by.it.bildziuh.project.java.beans.Mod;
import by.it.bildziuh.project.java.beans.Role;
import by.it.bildziuh.project.java.controller.Actions;
import by.it.bildziuh.project.java.dao.Dao;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class FrontController extends HttpServlet {

    @Override
    public void init() throws ServletException {
        Dao dao = Dao.getDao();
        List<Role> roles = null;
        List<Mod> mods = null;
        try {
            roles = dao.role.getAll();
            mods = dao.mod.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("Roles", roles);
        servletContext.setAttribute("Mods", mods);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            by.it.bildziuh.project.java.controller.Cmd cmd = Actions.defineCommand(req);
            by.it.bildziuh.project.java.controller.Cmd next = cmd.execute(req);
            if (next == cmd || next == null) {
                getServletContext().
                        getRequestDispatcher(cmd.getJsp()).
                        forward(req, resp);
            } else {
                resp.sendRedirect("do?command=" + next.toString());
            }
        } catch (Exception e) {
            getServletContext().setAttribute("Error", getErrorTxt(e));
            resp.sendRedirect("do?command=Error");
        }
    }

    private static String getErrorTxt(Exception e) {
        StringBuilder error = new StringBuilder("<b>" + e.toString() + "</b><br><br>");
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            if (element.toString().contains(".HttpServlet."))
                break;
            error.append(element.toString()).append("<br>\n");
        }
        return error.toString();
    }

}
