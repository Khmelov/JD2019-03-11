package by.it.eslaikouskaya.project.java.controllers;

import by.it.eslaikouskaya.project.java.beans.User;
import by.it.eslaikouskaya.project.java.dao.Dao;
import by.it.eslaikouskaya.project.java.utils.FormHelper;
import by.it.eslaikouskaya.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup extends Cmd {
	@Override
	public Cmd execute(HttpServletRequest req) throws Exception {

		if (FormHelper.isPost(req)) {
			User user = new User(
					0,
					Validator.getString(req, "login", "[a-zA-Z0-9]{2,20}"),
					Validator.getString(req, "password", "[a-zA-Z0-9]{8,20}"),
					Validator.getString(req, "email", "[\\w._]+@[a-z]+.[a-z]{2,3}"),
					2
			);

			Dao dao = Dao.getDao();
			if (dao.user.create(user)) {
				return Actions.BASKET.command;
			}
		}
		return null;
	}
}
