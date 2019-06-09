package by.it.eslaikouskaya.project.java.controllers;

import by.it.eslaikouskaya.project.java.beans.User;
import by.it.eslaikouskaya.project.java.dao.Dao;
import by.it.eslaikouskaya.project.java.utils.FormHelper;
import by.it.eslaikouskaya.project.java.utils.Patterns;
import by.it.eslaikouskaya.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdEditUsers extends Cmd {
	@Override
	public Cmd execute(HttpServletRequest req) throws Exception {
		Dao dao = Dao.getDao();
		if (FormHelper.isPost(req)) {

			if (FormHelper.contains(req, "update")) {
				User user = new User(
						Validator.getLong(req, "ID", Patterns.NUMBER),
						Validator.getString(req, "login", Patterns.LOGIN),
						Validator.getString(req, "password", Patterns.PASSWORD),
						Validator.getString(req, "email", Patterns.EMAIL),
						Validator.getLong(req, "roles_ID", Patterns.NUMBER)
				);
				dao.user.update(user);
				return this;
			}

			if (FormHelper.contains(req, "delete")) {
				User user = new User(
						Validator.getLong(req, "ID", Patterns.NUMBER),
						Validator.getString(req, "login", Patterns.LOGIN),
						Validator.getString(req, "password", Patterns.PASSWORD),
						Validator.getString(req, "email", Patterns.EMAIL),
						Validator.getLong(req, "roles_ID", Patterns.NUMBER)
				);
				dao.user.delete(user);
				return this;
			}
		}


		List<User> users = dao.user.getAll();
		req.setAttribute("users", users);
		return null;
	}
}
