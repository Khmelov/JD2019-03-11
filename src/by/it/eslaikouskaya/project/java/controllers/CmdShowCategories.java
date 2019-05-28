package by.it.eslaikouskaya.project.java.controllers;

import by.it.eslaikouskaya.project.java.beans.Category;
import by.it.eslaikouskaya.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdShowCategories extends Cmd {
	@Override
	Cmd execute(HttpServletRequest req) throws Exception {
		Dao dao = Dao.getDao();
		List<Category> categories = dao.category.getAll();
		req.setAttribute("categories", categories);
		return null;
	}
}
