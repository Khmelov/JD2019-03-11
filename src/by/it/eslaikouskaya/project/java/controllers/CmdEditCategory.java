package by.it.eslaikouskaya.project.java.controllers;

import by.it.eslaikouskaya.project.java.beans.Category;
import by.it.eslaikouskaya.project.java.dao.Dao;
import by.it.eslaikouskaya.project.java.utils.FormHelper;
import by.it.eslaikouskaya.project.java.utils.Patterns;
import by.it.eslaikouskaya.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdEditCategory extends Cmd {
	@Override
	public Cmd execute(HttpServletRequest req) throws Exception {

		if (FormHelper.isPost(req)) {
			Dao dao = Dao.getDao();
			if (FormHelper.contains(req, "create")) {
				Category category = new Category(
						0,
						Validator.getString(req, "category", Patterns.MATERIAL)
				);
				if (dao.category.create(category)) {
					req.setAttribute("success", "Категория успешно создана!");
				}
			}

			if (FormHelper.contains(req, "delete")) {
				String category = Validator.getString(req, "category", Patterns.MATERIAL);
				String where = String.format("WHERE category='%s'",
						category);
				List<Category> categories = dao.category.getAll(where);
				if (categories.size() < 1) {
					req.setAttribute("success", "Введите имя категории правильно!");
					return null;
				}
				if (categories.size() > 1) {
					for (Category cat : categories) {
						if (dao.grade.getAll("WHERE categories_ID=" + cat.getID()).size() > 0)
							continue;
						if (dao.category.delete(cat)) {
							req.setAttribute("success", "Категория '" + category + "' успешно удален!");
							req.setAttribute("categories", dao.category.getAll());
							return null;
						}
					}
				}
				long category_id = categories.get(0).getID();
				if (dao.grade.getAll("WHERE categories_ID=" + category_id).size() > 0) {
					req.setAttribute("success", "Невозможно удалить категорию, сначала удалите все классы привязанные к ней!");
					return null;
				}
				if (dao.category.delete(categories.get(0)))
					req.setAttribute("success", "Категория успешно удалена!");
			}
			req.setAttribute("categories", dao.category.getAll());

		}
		return null;
	}
}
