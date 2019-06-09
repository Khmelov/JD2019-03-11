package by.it.eslaikouskaya.project.java.controllers;

import by.it.eslaikouskaya.project.java.beans.*;
import by.it.eslaikouskaya.project.java.dao.Dao;
import by.it.eslaikouskaya.project.java.utils.FormHelper;
import by.it.eslaikouskaya.project.java.utils.Patterns;
import by.it.eslaikouskaya.project.java.utils.Tools;
import by.it.eslaikouskaya.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
				if (materials.size() < 1) {
					List<Grade> grs = dao.grade.getAll("WHERE grade='" + name + "'");
					if (grs.size() < 1) {
						List<Category> cats = dao.category.getAll("WHERE category='" + name + "'");
						if (cats.size() < 1) req.setAttribute
								("notfound", "По вашему запросу ничего не надено :(");
						else {
							List<Material> materialsFromCategories = new ArrayList<>();
							List<Grade> gradesForMaterials = dao.grade.getAll
									("WHERE categories_ID=" + cats.get(0).getID());
							for (Grade gradeForMaterials : gradesForMaterials) {
								List<Material> materialsFromGrades = dao.material.getAll
										("WHERE grades_ID='" + gradeForMaterials.getID() + "'");
								if (materialsFromGrades.size() > 1)
									materialsFromCategories.addAll(materialsFromGrades);
							}
							req.setAttribute("materials", materialsFromCategories);
						}
					} else
						req.setAttribute("materials", dao.material.getAll
								("WHERE grades_ID='" + grs.get(0).getID() + "'"));
				}
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
						return Actions.BASKET.command;
					}
				}
			}
		}
		return null;
	}
}
