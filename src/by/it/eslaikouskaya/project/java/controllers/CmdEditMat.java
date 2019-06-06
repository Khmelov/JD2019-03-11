package by.it.eslaikouskaya.project.java.controllers;

import by.it.eslaikouskaya.project.java.beans.Grade;
import by.it.eslaikouskaya.project.java.beans.Material;
import by.it.eslaikouskaya.project.java.dao.Dao;
import by.it.eslaikouskaya.project.java.utils.FormHelper;
import by.it.eslaikouskaya.project.java.utils.Patterns;
import by.it.eslaikouskaya.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdEditMat extends Cmd {
	@Override
	public Cmd execute(HttpServletRequest req) throws Exception {
		Dao dao = Dao.getDao();
		if (FormHelper.isPost(req)) {
			String name = Validator.getString(req, "name", Patterns.MATERIAL);
			int price = Validator.getInt(req, "price", Patterns.NUMBER);
			long grades_id = Validator.getLong(req, "grades_ID", Patterns.NUMBER);

			if (FormHelper.contains(req, "create")) {
				Material material = new Material(0, name, price, grades_id);
				String create = String.format("Материал '%s' успешно создан!", name);
				if (dao.material.create(material)) {
					req.setAttribute("success", create);
				}
			}

			if (FormHelper.contains(req, "delete")) {
				String where = String.format("WHERE name='%s' and grades_ID='%s'",
						name, grades_id);
				List<Material> materials = dao.material.getAll(where);
				String delete = String.format("Материал '%s' успешно удален!", name);
				if (materials.size() < 1) {
					req.setAttribute("success", "Введите имя материала правильно!");
					return null;
				}
				if (dao.material.delete(materials.get(0)))
					req.setAttribute("success", delete);
			}

		}
		List<Grade> grades = dao.grade.getAll();
		req.setAttribute("grades", grades);
		List<Material> materials = dao.material.getAll();
		req.setAttribute("materials", materials);
		return null;
	}
}
