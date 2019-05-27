package by.it.eslaikouskaya.project.java;

import by.it.eslaikouskaya.project.java.beans.Category;
import by.it.eslaikouskaya.project.java.dao.Dao;
import by.it.eslaikouskaya.project.java.utils.FormHelper;
import by.it.eslaikouskaya.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateCategory extends Cmd {
	@Override
	public Cmd execute(HttpServletRequest req) throws Exception {

		if (FormHelper.isPost(req)) {
			Category category = new Category(
					0,
					Validator.getString(req, "category")
			);

			Dao dao = Dao.getDao();
			if (dao.category.create(category)) {
				return Actions.SHOWCATEGORIES.command;
			}
		}
		return null;
	}
}
