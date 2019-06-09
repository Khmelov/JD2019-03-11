package by.it.eslaikouskaya.project.java.controllers;

import by.it.eslaikouskaya.project.java.beans.User;
import by.it.eslaikouskaya.project.java.dao.Dao;
import by.it.eslaikouskaya.project.java.utils.FormHelper;
import by.it.eslaikouskaya.project.java.utils.Patterns;
import by.it.eslaikouskaya.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin extends Cmd {
	@Override
	public Cmd execute(HttpServletRequest req) throws Exception {
		if (FormHelper.isPost(req)) {
			String login = Validator.getString(req, "login", Patterns.LOGIN);
			String password = Validator.getString(req, "password", Patterns.PASSWORD);
			String where = String.format(" WHERE Login='%s' and Password='%s'", login, password);
			List<User> users = Dao.getDao().user.getAll(where);
			if (users.size() < 1) {
				req.setAttribute("incorrect",
						"Аккаунта с таким логином и паролем не существует");
				return null;
			}
			if (users.size() > 0) {
				HttpSession session = req.getSession();
				User user = users.get(0);
				session.setAttribute("user", user);
				return Actions.INDEX.command;
			}
		}
		return null;
	}
}
