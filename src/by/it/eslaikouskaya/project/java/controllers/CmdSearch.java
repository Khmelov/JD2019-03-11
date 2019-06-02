package by.it.eslaikouskaya.project.java.controllers;

import by.it.eslaikouskaya.project.java.beans.*;
import by.it.eslaikouskaya.project.java.dao.Dao;
import by.it.eslaikouskaya.project.java.utils.FormHelper;
import by.it.eslaikouskaya.project.java.utils.Patterns;
import by.it.eslaikouskaya.project.java.utils.Tools;
import by.it.eslaikouskaya.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdSearch extends Cmd {
	@Override
	public Cmd execute(HttpServletRequest req) throws Exception {
		if (FormHelper.isPost(req)) {
			Dao dao = Dao.getDao();

			if (FormHelper.contains(req, "search")) {
				String name = Validator.getString(req, "name", Patterns.MATERIAL);
				String where = String.format("WHERE name='%s'", name);
				List<Material> materials = dao.material.getAll(where);
				List<Grade> grades = dao.grade.getAll();
				req.setAttribute("grades", grades);

				List<Category> categories = dao.category.getAll();
				req.setAttribute("categories", categories);
				if (materials.size() < 1)
					req.setAttribute("notfound", "Матриалов с таким именем не найдено");
				else
					req.setAttribute("materials", materials);
			}


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
