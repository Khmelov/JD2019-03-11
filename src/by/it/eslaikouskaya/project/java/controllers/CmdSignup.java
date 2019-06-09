package by.it.eslaikouskaya.project.java.controllers;

import by.it.eslaikouskaya.project.java.beans.User;
import by.it.eslaikouskaya.project.java.dao.Dao;
import by.it.eslaikouskaya.project.java.utils.FormHelper;
import by.it.eslaikouskaya.project.java.utils.Patterns;
import by.it.eslaikouskaya.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdSignup extends Cmd {
	@Override
	public Cmd execute(HttpServletRequest req) throws Exception {

		if (FormHelper.isPost(req)) {
			String login = Validator.getString(req, "login", Patterns.LOGIN);
			String password = Validator.getString(req, "password", Patterns.PASSWORD);
			String email = Validator.getString(req, "email", Patterns.EMAIL);
			String where = String.format(" WHERE Login='%s' and Password='%s' and Email='%s'", login, password, email);

			List<User> users = Dao.getDao().user.getAll(where);
			if (users.size() < 1) {
				User user = new User(
						0,
						Validator.getString(req, "login", Patterns.LOGIN),
						Validator.getString(req, "password", Patterns.PASSWORD),
						Validator.getString(req, "email", Patterns.EMAIL),
						2
				);

				Dao dao = Dao.getDao();
				if (dao.user.create(user)) {
					return Actions.PROFILE.command;
				}
			}
			req.setAttribute("exist", "Такой пользователь уже существует!");
		}
		return null;
	}
}
