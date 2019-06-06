package by.it.eslaikouskaya.project.java.controllers;

import by.it.eslaikouskaya.project.java.beans.Category;
import by.it.eslaikouskaya.project.java.beans.Grade;
import by.it.eslaikouskaya.project.java.dao.Dao;
import by.it.eslaikouskaya.project.java.utils.FormHelper;
import by.it.eslaikouskaya.project.java.utils.Patterns;
import by.it.eslaikouskaya.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdEditGrade extends Cmd {
	@Override
	public Cmd execute(HttpServletRequest req) throws Exception {
		Dao dao = Dao.getDao();
		List<Category> categories = dao.category.getAll();
		req.setAttribute("categories", categories);
		List<Grade> grades = dao.grade.getAll();
		req.setAttribute("grades", grades);

		if (FormHelper.isPost(req)) {

			if (FormHelper.contains(req, "create")) {
				String grade = Validator.getString(req, "grade", Patterns.MATERIAL);
				long categories_id = Validator.getLong(req, "categories_ID", Patterns.NUMBER);
				Grade gr = new Grade(0, grade, categories_id);
				String create = String.format("Класс '%s' успешно создан!", grade);
				if (dao.grade.create(gr))
					req.setAttribute("success", create);
			}

			if (FormHelper.contains(req, "delete")) {
				String grade = Validator.getString(req, "grade", Patterns.MATERIAL);
				long categories_id = Validator.getLong(req, "categories_ID", Patterns.NUMBER);
				String where = String.format("WHERE grade='%s' and categories_ID='%s'",
						grade, categories_id);
				List<Grade> grs = dao.grade.getAll(where);
				if (grs.size() < 1) {
					req.setAttribute("success", "Введите имя класса правильно!");
					return null;
				}
				if (grs.size() > 1) {
					for (Grade gr : grs) {
						if (dao.material.getAll("WHERE grades_ID=" + gr.getID()).size() > 0)
							continue;
						if (dao.grade.delete(gr)) {
							req.setAttribute("success", "Класс '" + grade + "' успешно удален!");
							req.setAttribute("grades", dao.grade.getAll());
							return null;
						}
					}
				}
				long grade_id = grs.get(0).getID();
				if (dao.material.getAll("WHERE grades_ID=" + grade_id).size() > 0) {
					req.setAttribute("success", "Невозможно удалить класс, сначала удалите все матриалы привязанные к нему!");
					return null;
				}
				if (dao.grade.delete(grs.get(0))) {
					String delete = String.format("Класс '%s' успешно удален!", grade);
					req.setAttribute("success", delete);
				}
			}
			req.setAttribute("grades", dao.grade.getAll());
		}
		return null;
	}
}
