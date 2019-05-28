package by.it.eslaikouskaya.project.java.controllers;

import by.it.eslaikouskaya.project.java.beans.Material;
import by.it.eslaikouskaya.project.java.dao.Dao;
import by.it.eslaikouskaya.project.java.utils.FormHelper;
import by.it.eslaikouskaya.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateMat extends Cmd {
	@Override
	public Cmd execute(HttpServletRequest req) throws Exception {

		if (FormHelper.isPost(req)) {
			Material material = new Material(
					0,
					Validator.getString(req, "name"),
					Validator.getInt(req, "price"),
					Validator.getLong(req, "grades_ID")
			);

			Dao dao = Dao.getDao();
			if (dao.material.create(material)) {
				return Actions.INDEX.command;
			}
		}
		return null;
	}
}
