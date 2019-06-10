package by.it.vasiliuk.project.java.CMD;

import by.it.vasiliuk.project.java.beans.Task;
import by.it.vasiliuk.project.java.beans.User;
import by.it.vasiliuk.project.java.dao.Dao;
import by.it.vasiliuk.project.java.utils.FormHelper;
import by.it.vasiliuk.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdCreateTask extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (session.getAttribute("user") == null) {
            return Actions.LOGIN.command;
        }

        if (FormHelper.isPost(req)) {
            Task task = new Task(
                    0,
                    Validator.getString(req, "task_type", "[A-Za-z]+"),
                    Validator.getString(req, "stask_type", "[A-Za-z]+"),
                    Validator.getString(req, "tag", "[а-яА-ЯA-Za-z0-9]+"),
                    Validator.getString(req, "grp_project", "[а-яА-ЯA-Za-z0-9]+"),
                    Validator.getString(req, "sallary", "[0-9]+"),
                    Validator.getString(req, "date_year", "[0-9]{4,4}"),
                    user.getId()
            );

            Dao.getDao().task.create(task);
            return Actions.PROFILE.command;
        }
        return null;
    }
}
