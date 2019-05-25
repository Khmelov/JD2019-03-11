package by.it.khlystunova.project.java;

import by.it.khlystunova.project.java.Actions;
import by.it.khlystunova.project.java.Cmd;

import javax.servlet.ServletException;
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
            by.it.khlystunova.project.java.Cmd cmd = Actions.defineCommand(req);
            Cmd next = cmd.execute(req);
            if (next==cmd || next==null){
                getServletContext().
                        getRequestDispatcher(cmd.getJsp()).
                        forward(req, resp);
            }
            else
            {
                resp.getWriter().print(next+" redirect");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        try{
            throw new Exception("some");
        }catch (Exception e){
            System.out.println( e.toString());

        }
    }
}
