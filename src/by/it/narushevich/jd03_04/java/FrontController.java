package by.it.narushevich.jd03_04.java;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Cmd cmd = Actions.defineCommand(req);
            Cmd next = cmd.execute(req);
            resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

            if (next==cmd || next==null){
                getServletContext()
                        .getRequestDispatcher(cmd.getJsp())
                        .forward(req, resp);
            }
            else {
                resp.getWriter().print(next+" redirect");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
