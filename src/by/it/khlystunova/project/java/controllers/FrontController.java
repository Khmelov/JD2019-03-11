package by.it.khlystunova.project.java.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req,resp);
    }
    private void process(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{




        try {
            resp.setHeader("Cache-Control","private, no-store, no-cache, must-revalidate");
            resp.setHeader("Pragma","no-cache");
            Cmd cmd = Actions.defineCommand(req);
            Cmd next = cmd.execute(req);
            if (next==cmd || next==null){
                //показывает нужную html страницу в браузере
                getServletContext().
                        getRequestDispatcher(cmd.getJsp()).
                        forward(req, resp);//по forward отдали управления jsp странице , а она после отработки отдала управление фильтру.мы не ожидаем что управление вернется.
            }
            else {
                resp.sendRedirect("do?command="+next.toString());
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
