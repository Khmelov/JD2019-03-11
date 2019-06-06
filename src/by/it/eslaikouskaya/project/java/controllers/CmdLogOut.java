package by.it.eslaikouskaya.project.java.controllers;

import by.it.eslaikouskaya.project.java.utils.FormHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdLogOut extends Cmd {
	@Override
	Cmd execute(HttpServletRequest req) throws Exception {

		if (FormHelper.isPost(req)) {

			if (FormHelper.contains(req, "logout")) {
				HttpSession session = req.getSession();
				session.invalidate();
				return Actions.LOGIN.command;
			}
		}
		return null;
	}
}
