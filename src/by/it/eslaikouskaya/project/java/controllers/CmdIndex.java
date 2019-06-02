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

		List<Material> materials = dao.material.getAll();
		req.setAttribute("materials", materials);
		List<Grade> grades = dao.grade.getAll();
		req.setAttribute("grades", grades);
		List<Category> categories = dao.category.getAll();
		req.setAttribute("categories", categories);

		if (FormHelper.isPost(req)) {
			if (FormHelper.contains(req, "tobasket")) {
				User user = Tools.findUserInSession(req);
				if (user != null) {
					Purchase purchase = new Purchase(
							0,
							user.getID(),
							Validator.getLong(req, "ID", Patterns.NUMBER),
							Validator.getInt(req, "number", Patterns.NUMBER)
					);
					if (dao.purchase.create(purchase)) {
						return Actions.PROFILE.command;
					}
				}
			}
		}

		return null;
	}
}
