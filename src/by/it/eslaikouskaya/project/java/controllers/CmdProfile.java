package by.it.eslaikouskaya.project.java.controllers;

import by.it.eslaikouskaya.project.java.beans.Material;
import by.it.eslaikouskaya.project.java.beans.Purchase;
import by.it.eslaikouskaya.project.java.beans.User;
import by.it.eslaikouskaya.project.java.dao.Dao;
import by.it.eslaikouskaya.project.java.utils.FormHelper;
import by.it.eslaikouskaya.project.java.utils.Patterns;
import by.it.eslaikouskaya.project.java.utils.Tools;
import by.it.eslaikouskaya.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdProfile extends Cmd {
	@Override
	public Cmd execute(HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
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
				dao.user.update(user);
				return this; //PRG go to Get
			}


			if (FormHelper.contains(req, "logout")) {
				session.invalidate();
				return Actions.LOGIN.command;
			}

			if (FormHelper.contains(req, "delete")) {
				String name = Validator.getString(req, "name", Patterns.MATERIAL);
				String where = String.format("WHERE name='%s'", name);
				List<Material> chosen = dao.material.getAll(where);

				Purchase purchase = new Purchase(
						0,
						user.getID(),
						chosen.get(0).getID(),
						Validator.getInt(req, "number", Patterns.NUMBER)
				);
				dao.purchase.delete(purchase);
				return this;
			}

			if (FormHelper.contains(req, "send")) {
				req.setAttribute("sent", "Спасибо за заказ!");
				return this;
			}
		}

		List<Purchase> purchases = dao.purchase.getAll("WHERE users_ID=" + user.getID());
		req.setAttribute("purchases", purchases);
		List<Material> materials = dao.material.getAll();
		req.setAttribute("materials", materials);

		return null;
	}
}
