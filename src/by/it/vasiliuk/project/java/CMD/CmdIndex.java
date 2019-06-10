package by.it.vasiliuk.project.java.CMD;

import by.it.vasiliuk.project.java.beans.Task;
import by.it.vasiliuk.project.java.beans.User;
import by.it.vasiliuk.project.java.dao.Dao;
import by.it.vasiliuk.project.java.utils.FormHelper;
import by.it.vasiliuk.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();


        List<Task> tasks = dao.task.getAll();
        req.setAttribute("tasksSize", tasks.size());
        int start = 0;
        if (FormHelper.contains(req, "start"))
            start = Validator.getInt(req, "start");
        String limit = String.format(" LIMIT %s,15", start);
        tasks = dao.task.getAll(limit);
        req.setAttribute("tasks", tasks);
        List<User> users = dao.user.getAll();
        req.setAttribute("users", users);
        return null;
    }
}

