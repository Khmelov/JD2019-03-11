package by.it.eslaikouskaya.project.java.controllers;

import by.it.eslaikouskaya.project.java.beans.Material;
import by.it.eslaikouskaya.project.java.dao.Dao;
import by.it.eslaikouskaya.project.java.utils.FormHelper;
import by.it.eslaikouskaya.project.java.utils.Patterns;
import by.it.eslaikouskaya.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateMat extends Cmd {
	@Override
	public Cmd execute(HttpServletRequest req) throws Exception {

		if (FormHelper.isPost(req)) {
			Material material = new Material(
					0,
					Validator.getString(req, "name", Patterns.MATERIAL),
					Validator.getInt(req, "price", Patterns.NUMBER),
					Validator.getLong(req, "grades_ID", Patterns.NUMBER)
			);
			Dao dao = Dao.getDao();
			if (dao.material.create(material)) {
				req.setAttribute("success", "Материал успешно создан!");
			}
			req.setAttribute("materials", dao.material.getAll());
		}
		return null;
	}
}
