package by.it.eslaikouskaya.project.java.controllers;

import by.it.eslaikouskaya.project.java.beans.User;
import by.it.eslaikouskaya.project.java.dao.Dao;
import by.it.eslaikouskaya.project.java.utils.FormHelper;
import by.it.eslaikouskaya.project.java.utils.Patterns;
import by.it.eslaikouskaya.project.java.utils.Tools;
import by.it.eslaikouskaya.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;

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
				String login = Validator.getString(req, "login", Patterns.LOGIN);
				String password = Validator.getString(req, "password", Patterns.PASSWORD);
				String email = Validator.getString(req, "email", Patterns.EMAIL);
				user.setLogin(login);
				user.setPassword(password);
				user.setEmail(email);
				if (dao.user.update(user))
					req.setAttribute("success", "Информация обновлена!");
			}


		}
		return null;
	}
}
