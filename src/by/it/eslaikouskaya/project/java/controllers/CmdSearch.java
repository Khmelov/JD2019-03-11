package by.it.eslaikouskaya.project.java.controllers;

import by.it.eslaikouskaya.project.java.beans.Material;
import by.it.eslaikouskaya.project.java.dao.Dao;
import by.it.eslaikouskaya.project.java.utils.FormHelper;
import by.it.eslaikouskaya.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdSearch extends Cmd {
	@Override
	public Cmd execute(HttpServletRequest req) throws Exception {
		if (FormHelper.isPost(req)) {
			String name = Validator.getString(req, "name");
			Dao dao = Dao.getDao();
			String where = String.format("WHERE name='%s'", name);
			List<Material> materials = dao.material.getAll(where);
			if (materials.size() < 1)
				req.setAttribute("materials", "Матриалов с таким именем не найдено");
			else
				req.setAttribute("materials", materials);
			return null;
		}

		return Actions.SEARCH.command;
	}
}
