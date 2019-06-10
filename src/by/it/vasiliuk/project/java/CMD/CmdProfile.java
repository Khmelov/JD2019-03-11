package by.it.vasiliuk.project.java.CMD;

import by.it.vasiliuk.project.java.beans.Task;
import by.it.vasiliuk.project.java.beans.User;
import by.it.vasiliuk.project.java.dao.Dao;
import by.it.vasiliuk.project.java.utils.FormHelper;
import by.it.vasiliuk.project.java.utils.Tools;
import by.it.vasiliuk.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdProfile extends Cmd {
    @Override
   public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        User user = Tools.findUserInSession(req);

        if (user == null) {
            return Actions.LOGIN.command;
        }

        if (FormHelper.isPost(req)) {

            if (FormHelper.contains(req, "update")) {
                String login = Validator.getString(req, "login", "[a-zA-Z0-9]{4,30}");
                String password = Validator.getString(req, "password", "[a-zA-Z0-9@#$%]{4,20}");
                String email = Validator.getString(req, "email", "[a-z0-9._%+-]+@[a-z0-9.-]+");
                String phone = Validator.getString(req, "phone", "[0-9+]{13,13}");
                user.setLogin(login);
                user.setPassword(password);
                user.setEmail(email);
                user.setPhone(phone);
                dao.user.update(user);
                return this;
            }

            if (FormHelper.contains(req, "logout")) {
                return Actions.LOGOUT.command;
            }

            if (FormHelper.contains(req, "edit")) {
                Task task = new Task(
                        Validator.getLong(req, "id"),
                        Validator.getString(req, "task_type", "[A-Za-z]+"),
                        Validator.getString(req, "stask_type", "[A-Za-z]+"),
                        Validator.getString(req, "tag", "[а-яА-ЯA-Za-z0-9]+"),
                        Validator.getString(req, "grp_project", "[а-яА-ЯA-Za-z0-9]+"),
                        Validator.getString(req, "sallary", "[0-9]+"),
                        Validator.getString(req, "date_year", "[0-9]{4,4}"),
                        Validator.getLong(req, "users_id")
                );
                dao.task.update(task);
                return this;
            }

            if (FormHelper.contains(req, "deletetask")) {
                Task task = new Task(
                        Validator.getLong(req, "id"),
                        Validator.getString(req, "task_type", "[A-Za-z]+"),
                        Validator.getString(req, "stask_type", "[A-Za-z]+"),
                        Validator.getString(req, "tag", "[а-яА-ЯA-Za-z0-9]+"),
                        Validator.getString(req, "grp_project", "[а-яА-ЯA-Za-z0-9]+"),
                        Validator.getString(req, "sallary", "[0-9]+"),
                        Validator.getString(req, "date_year", "[0-9]{4,4}"),
                        Validator.getLong(req, "users_id")
                );
                dao.task.delete(task);
                return this;
            }
        }





        List<Task> tasks = dao.task.getAll("WHERE users_id=" + user.getId());
        req.setAttribute("tasks", tasks);

        return null;
    }
}
