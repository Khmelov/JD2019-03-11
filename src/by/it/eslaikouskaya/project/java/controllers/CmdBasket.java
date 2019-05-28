package by.it.eslaikouskaya.project.java.controllers;

import by.it.eslaikouskaya.project.java.beans.Purchase;
import by.it.eslaikouskaya.project.java.beans.User;
import by.it.eslaikouskaya.project.java.dao.Dao;
import by.it.eslaikouskaya.project.java.utils.FormHelper;
import by.it.eslaikouskaya.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdBasket extends Cmd {
	@Override
	public Cmd execute(HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();

		if (session.getAttribute("user") == null) {
			return Actions.LOGIN.command;
		}

		if (FormHelper.isPost(req)) {
			if (Validator.getString(req, "logout").equals("ok")) {
				session.invalidate();
				return Actions.LOGIN.command;
			}
		}

		Dao dao = Dao.getDao();
		User user = (User) session.getAttribute("user");
		List<Purchase> purchases = dao.purchase.getAll("WHERE users_ID=" + user.getID());
		req.setAttribute("purchases", purchases);


		return null;
	}
}
