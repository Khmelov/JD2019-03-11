package by.it.eslaikouskaya.project.java.controllers;

import by.it.eslaikouskaya.project.java.beans.Grade;
import by.it.eslaikouskaya.project.java.beans.Material;
import by.it.eslaikouskaya.project.java.beans.Purchase;
import by.it.eslaikouskaya.project.java.beans.User;
import by.it.eslaikouskaya.project.java.dao.Dao;
import by.it.eslaikouskaya.project.java.utils.FormHelper;
import by.it.eslaikouskaya.project.java.utils.Patterns;
import by.it.eslaikouskaya.project.java.utils.Tools;
import by.it.eslaikouskaya.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdBasket extends Cmd {
	@Override
	Cmd execute(HttpServletRequest req) throws Exception {
		Dao dao = Dao.getDao();
		User user = Tools.findUserInSession(req);
		if (user == null) {
			return Actions.LOGIN.command;
		}

		if (FormHelper.isPost(req)) {

			if (FormHelper.contains(req, "delete")) {
				long matId = Validator.getLong(req, "material.ID", Patterns.NUMBER);
				Purchase purchase = new Purchase(
						Validator.getLong(req, "purchase.ID", Patterns.NUMBER),
						user.getID(),
						matId,
						Validator.getInt(req, "number", Patterns.NUMBER)
				);
				if (dao.purchase.delete(purchase)) {
					String delete = String.format("Товар '%s' удален из корзины!",
							dao.material.getAll("WHERE ID=" + matId).get(0).getName());
					req.setAttribute("success", delete);
				}
			}

			if (FormHelper.contains(req, "change")) {
				long matId = Validator.getLong(req, "material.ID", Patterns.NUMBER);
				Purchase purchase = new Purchase(
						Validator.getLong(req, "purchase.ID", Patterns.NUMBER),
						user.getID(),
						matId,
						Validator.getInt(req, "number", Patterns.NUMBER)
				);
				if (dao.purchase.update(purchase)) {
					String change = String.format("Количество товара '%s' изменено!",
							dao.material.getAll("WHERE ID=" + matId).get(0).getName());
					req.setAttribute("success", change);
				}
			}

			if (FormHelper.contains(req, "send")) {
				List<Purchase> purchases = dao.purchase.getAll("WHERE users_ID=" + user.getID());
				if (purchases.size() < 1) req.setAttribute("sent", "Корзина пуста");
				for (Purchase purchase : purchases) {
					if (dao.purchase.delete(purchase))
						req.setAttribute("sent", "Спасибо за заказ!");
				}
			}
		}

		List<Purchase> purchases = dao.purchase.getAll("WHERE users_ID=" + user.getID());
		req.setAttribute("purchases", purchases);
		List<Material> materials = dao.material.getAll();
		req.setAttribute("materials", materials);
		List<Grade> grades = dao.grade.getAll();
		req.setAttribute("grades", grades);
		return null;
	}
}
