package by.it.eslaikouskaya.project.java;

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
			String where = String.format(" WHERE Name='%s' ", name);
			List<Material> users = Dao.getDao().material.getAll(where);
			if (users.size() > 0) {
				return Actions.INDEX.command;
			}
		}
		return null;
	}
}
