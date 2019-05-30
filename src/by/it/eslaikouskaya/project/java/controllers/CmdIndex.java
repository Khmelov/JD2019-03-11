package by.it.eslaikouskaya.project.java.controllers;

import by.it.eslaikouskaya.project.java.beans.*;
import by.it.eslaikouskaya.project.java.dao.Dao;
import by.it.eslaikouskaya.project.java.utils.FormHelper;
import by.it.eslaikouskaya.project.java.utils.Patterns;
import by.it.eslaikouskaya.project.java.utils.Tools;
import by.it.eslaikouskaya.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends Cmd {
	@Override
	Cmd execute(HttpServletRequest req) throws Exception {
		Dao dao = Dao.getDao();

		if (FormHelper.isPost(req)) {
			User user = Tools.findUserInSession(req);
			String name = Validator.getString(req, "name", Patterns.MATERIAL);
			String price = Validator.getString(req, "price", Patterns.NUMBER);
			String where = String.format("WHERE name='%s' price='%s'", name, price);
			List<Material> chosen = dao.material.getAll(where);
			if (FormHelper.contains(req, "tobasket")) {
				if (user != null) {
					Purchase purchase = new Purchase(
							0,
							user.getID(),
							chosen.get(0).getID(),
							Validator.getInt(req, "number", Patterns.NUMBER)
					);
					dao.purchase.create(purchase);
					if (dao.purchase.create(purchase)) {
						return Actions.PROFILE.command;
					}
				}
			}
		}

		List<Material> materials = dao.material.getAll();
		req.setAttribute("materials", materials);
		List<Grade> grades = dao.grade.getAll();
		req.setAttribute("grades", grades);
		List<Category> categories = dao.category.getAll();
		req.setAttribute("categories", categories);
		return null;
	}
}
