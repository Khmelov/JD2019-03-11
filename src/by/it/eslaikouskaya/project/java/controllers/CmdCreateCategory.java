package by.it.eslaikouskaya.project.java.controllers;

import by.it.eslaikouskaya.project.java.beans.Category;
import by.it.eslaikouskaya.project.java.dao.Dao;
import by.it.eslaikouskaya.project.java.utils.FormHelper;
import by.it.eslaikouskaya.project.java.utils.Patterns;
import by.it.eslaikouskaya.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdCreateCategory extends Cmd {
	@Override
	public Cmd execute(HttpServletRequest req) throws Exception {

		if (FormHelper.isPost(req)) {
			Category category = new Category(
					0,
					Validator.getString(req, "category", Patterns.MATERIAL)
			);
			Dao dao = Dao.getDao();
			if (dao.category.create(category)) {
				req.setAttribute("success", "Категория успешно создана!");
			}

			List<Category> categories = dao.category.getAll();
			req.setAttribute("categories", categories);
		}
		return null;
	}
}
